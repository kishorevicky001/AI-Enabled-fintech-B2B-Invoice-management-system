package com.crudoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

	   String invoice=null;
	 try { 
		  PrintWriter pw=response.getWriter();
		  String url="jdbc:mysql://localhost:3306/grey_goose";
		  String user ="root";
		  String password = "kishore123";
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  
		  
		  BufferedReader reader = request.getReader();
	      invoice = reader.readLine();
	      System.out.println(invoice);

	      
	      invoice =  invoice.substring(1, invoice.length() - 1);
	      String final_values[] = invoice.split(",");
	      
	      for(int i = 0; i < final_values.length; ++i) {
	        final_values[i] = final_values[i].split(":")[1];
	        final_values[i] = final_values[i].substring(1, final_values[i].length() - 1);
	        System.out.println(final_values[i]);
	      }
	      

	      String business_code = final_values[0];
	      String cust_number = final_values[1];
	      String clear_date = final_values[2];
	      String buisness_year = final_values[3];
	      String doc_id = final_values[4];
	      String posting_date = final_values[5];
	      String document_create_date = final_values[6];
	      String due_in_date = final_values[7];
	      String invoice_currency = final_values[8];
	      String document_type = final_values[9];
	      String posting_id = final_values[10];
	      String total_open_amount = final_values[11];
	      String baseline_create_date = final_values[12];
	      String cust_payment_terms = final_values[13];
	      String invoice_id = final_values[14];
		  
		  
		  
		  

//	 
	      Connection con = DriverManager.getConnection(url,user,password);  
	      String query = "INSERT INTO winter_internship (business_code, cust_number, clear_date, buisness_year, doc_id, posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) values (?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?)"; 
	      PreparedStatement st = con.prepareStatement(query); 
	      st.setString(1, business_code); 
	      st.setString(2,cust_number); 
	      st.setString(3, clear_date); 
	       
	      st.setString(4,buisness_year); 
	 
	      st.setString(5, doc_id); 
	      st.setString(6,  posting_date); 
	      st.setString(7, document_create_date); 
	      st.setString(8, due_in_date); 
	 
	      st.setString(9, invoice_currency); 
	       
	      st.setString(10, document_type); 
	      st.setString(11,posting_id); 
	      st.setString(12,total_open_amount); 
	 
	 
	      st.setString(13, baseline_create_date); 
	      st.setString(14, cust_payment_terms); 
	      st.setString(15,invoice_id); 
	 
	      pw.println(invoice_id);
	     
	      int rs= st.executeUpdate(); 
	      if (rs>0) {
	    	  pw.println("inserted");
	      }
	      con.close(); 
	       
	 
	    } 
	    catch (Exception e) { 
	      e.printStackTrace(); 
	    } 
	
}
}
