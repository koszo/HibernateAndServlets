package com.sda.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sda.model.Person;
import com.sda.model.Region;
import com.sda.service.RegionService;

public class RegionListServlet extends HttpServlet {
	
	
			
	/**
	 * 
	 */
	private static final long serialVersionUID = 2673893766871825989L;
	private RegionService regionservice = new RegionService();
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println("Entering doGet");

	        List<Region> regionList = new ArrayList<>();
	        regionList = regionservice.getAllRegions();
	        
	        req.setAttribute("regionList", regionList);
	        
	        RequestDispatcher dispatcher = req.getRequestDispatcher("regionList.jsp");
	        dispatcher.forward(req,resp);
	 }
}
