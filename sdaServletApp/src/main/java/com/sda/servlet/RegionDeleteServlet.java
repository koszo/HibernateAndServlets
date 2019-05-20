package com.sda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sda.service.RegionService;

@WebServlet("/regionDelete")
public class RegionDeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3423350820867769302L;
	
	private RegionService regionService = new RegionService();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String regionId = req.getParameter("regionId");
		
		regionService.deleteRegion(Integer.valueOf(regionId));
		
		 req.setAttribute("regionList", regionService.getAllRegions());
		
		 RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/regionList.jsp");
	        dispatcher.forward(req, resp);
		
	
		
	}
	
	
	
	
	
	
}
