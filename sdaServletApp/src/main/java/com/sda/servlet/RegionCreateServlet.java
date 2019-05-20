package com.sda.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sda.model.Region;
import com.sda.service.RegionService;


public class RegionCreateServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5433049120771067864L;
	private RegionService regionservice = new RegionService();
	
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println("Entering regionCreate doget");
	    
	        
	        RequestDispatcher dispatcher = req.getRequestDispatcher("regionCreate.jsp");
	        dispatcher.forward(req,resp);
	 }
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("entering regionCreate doPost");
		 
		 String regionName = req.getParameter("newRegion");
	     
		 regionservice.saveRegion(regionName);
	      
		 req.setAttribute("regionList", regionservice.getAllRegions());
		 
		 
		 RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/regionList.jsp");
		 dispatcher.forward(req, resp);
		 
	 }
}
