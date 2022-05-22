package com.crudoperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditData
 */
@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int sl_no=Integer.parseInt(request.getParameter("sl_no"));
		String invoice_currency = request.getParameter("invoice_currency");
		String cust_payment_terms = request.getParameter("cust_payment_terms");
		System.out.println(sl_no);
		String url="jdbc:mysql://localhost:3306/grey_goose";
		String user ="root";
		String password = "kishore123";
		pw.println(cust_payment_terms);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			String sql="update winter_internship set invoice_currency = ? , cust_payment_terms = ? where sl_no = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(3, sl_no);
			pstmt.setString(1, invoice_currency);
			pstmt.setString(2, cust_payment_terms);
			int rs=pstmt.executeUpdate();
			System.out.println(rs);
			
			if(rs!=0) {
				pw.println("Recorded updated");
			}
			else {
				pw.println("Failed");
			}
			con.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
