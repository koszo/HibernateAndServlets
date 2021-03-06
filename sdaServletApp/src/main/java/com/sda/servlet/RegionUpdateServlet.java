package com.sda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sda.model.Region;
import com.sda.service.RegionService;

@WebServlet("/regionUpdate")
public class RegionUpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2509967252418162149L;

	private RegionService regionService = new RegionService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String regionId = req.getParameter("regionId");
		
		
		Region region = regionService.getRegionById(Integer.valueOf(regionId));
		
		
		req.setAttribute("region", region);
		
		

		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/regionUpdate.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String regionId = req.getParameter("regionId");
		String regionName = req.getParameter("regionName");

		regionService.updateRegion(Integer.valueOf(regionId), regionName);

		req.setAttribute("regionList", regionService.getAllRegions());

		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/regionList.jsp");
		dispatcher.forward(req, resp);

	}

}
