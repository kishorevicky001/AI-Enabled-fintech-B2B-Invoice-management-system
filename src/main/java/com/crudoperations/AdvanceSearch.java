package com.crudoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AdvanceSearch
 */
@WebServlet("/AdvanceSearch")
public class AdvanceSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvanceSearch() {
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
		int invoice_id1=Integer.parseInt(request.getParameter("invoice_id"));
		String doc_id1 = request.getParameter("doc_id");
		int cust_number1 = Integer.parseInt(request.getParameter("cust_number"));
		String buisness_year1 = request.getParameter("buisness_year");
//		System.out.println(invoice_id);
		String url="jdbc:mysql://localhost:3306/grey_goose";
		String user ="root";
		String password = "kishore123";
		String invoice=null;

		int sl_no;
		String business_code;
		int cust_number;
		String clear_date;
		String buisness_year;
		String doc_id;
		String posting_date;
		String document_create_date;
		String document_craete_date1;
		String due_in_date;
		String invoice_currency;
		String document_type;
		int posting_id;
		String area_business;
		Double total_open_amount;
		String baseline_create_date;
		String cust_payment_terms;
		int invoice_id;
		int isopen;
		String aging_bucket;
		int is_deleted;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,user,password);
			Statement st =con.createStatement();
			

			
			ResultSet rs =st.executeQuery("select * from winter_internship where doc_id="+doc_id1+" AND "+"invoice_id="+invoice_id1+" AND "+"cust_number = "+cust_number1+" AND "+"buisness_year = "+buisness_year1);
			
		    
		 
		     
		  
			ArrayList<Dataset> data = new ArrayList<>();
			 while(rs.next())
			 {
					Dataset s = new Dataset();
					sl_no=rs.getInt("sl_no");
					business_code=rs.getString("business_code");
					cust_number=rs.getInt("cust_number");
					clear_date=rs.getString("clear_date");
					buisness_year=rs.getString("buisness_year");
					doc_id=rs.getString("doc_id");
					posting_date=rs.getString("posting_date");
					document_create_date=rs.getString("document_create_date");
					document_craete_date1=rs.getString("document_create_date1");
					due_in_date=rs.getString("due_in_date");
					invoice_currency=rs.getString("invoice_currency");
					document_type=rs.getString("document_type");
					posting_id=rs.getInt("posting_id");
					area_business=rs.getString("area_business");
					total_open_amount=rs.getDouble("total_open_amount");
					baseline_create_date=rs.getString("baseline_create_date");
					cust_payment_terms=rs.getString("cust_payment_terms");
					invoice_id=rs.getInt("invoice_id");
					isopen=rs.getInt("isopen");
					aging_bucket=rs.getString("aging_bucket");
					is_deleted=rs.getInt("is_deleted");
					
					
					
					s.setSl_no(sl_no);
					s.setBusiness_code(business_code);
					s.setCust_number(cust_number);
					s.setClear_date(clear_date);
					s.setBuisness_year(buisness_year);
					
					s.setDoc_id(doc_id);
					s.setPosting_date(posting_date);
					s.setDocument_create_date(document_create_date);
					s.setDocument_craete_date1(document_craete_date1);
					s.setDue_in_date(due_in_date);
					s.setInvoice_currency(invoice_currency);
					s.setDocument_type(document_type);
					s.setPosting_id(posting_id);
					s.setArea_business(area_business);
					s.setTotal_open_amount(total_open_amount);
					s.setBaseline_create_date(baseline_create_date);
					s.setCust_payment_terms(cust_payment_terms);
					s.setInvoice_id(invoice_id);
					s.setIsopen(isopen);
					s.setAging_bucket(aging_bucket);
					s.setIs_deleted(is_deleted);
					
					
					
					
			
					
					
					data.add(s);
					
					
			 }

			Gson gson = new GsonBuilder().serializeNulls().create();
			String invoices  = gson.toJson(data);
			response.setContentType("application/json");
			try {
				response.getWriter().write(invoices);//getWriter() returns a PrintWriter object that can send character text to the client. 
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
			System.out.println(invoices);
			rs.close();
			st.close();
			con.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
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

