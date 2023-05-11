//package com.jd.grocery.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.jd.grocery.dao.ItemDao;
//import com.jd.grocery.model.Item;
//
//@WebServlet("/addlink")
//public class AddServlet extends HttpServlet{
//	
//	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
//		String itemName = req.getParameter("item"); 
//		int stock = Integer.parseInt(req.getParameter("stock"));
//		double price = Double.parseDouble(req.getParameter("price"));									
//		
//		Item myItem = new Item();
//		myItem.setItemName(itemName);
//		myItem.setStock(stock);
//		myItem.setPrice(price);
//		
//		ItemDao itemDao = new ItemDao();
//		Item item = itemDao.add(myItem);
//		
//		PrintWriter pw = res.getWriter();
//		
//		if(item==null) {
//			pw.print("Item Addition Failed");
//		}
//		else {
//			pw.print("Item Added Successfully! item: "+myItem);
//			System.out.println("Item Added Successfully! item: "+myItem);
//		}
//		
//		
//	}
//
//}
