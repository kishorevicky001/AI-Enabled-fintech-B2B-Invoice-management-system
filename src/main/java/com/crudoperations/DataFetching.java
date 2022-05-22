package com.crudoperations;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DataFetching {
	public ArrayList<Dataset> getData()
	{
		ArrayList<Dataset> data =new ArrayList<Dataset>();
		
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
		 //Connection conn = getConnection();
		 String url ="jdbc:mysql://localhost:3306/grey_goose";
		 String user = "root";
		 String pass ="kishore123";
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=DriverManager.getConnection(url,user,pass);
		
		 String sql_query="SELECT * from winter_internship";
		 PreparedStatement pst = conn.prepareStatement(sql_query);
		 //System.out.println(pst);
		 
		 ResultSet rs = pst.executeQuery();
		
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
		 
//		 for(Dataset stud: data)
//		 {
//			 System.out.println(stud.toString());
//		 }
		 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
		
		
		return data;
		
	
	}
	
	
}
