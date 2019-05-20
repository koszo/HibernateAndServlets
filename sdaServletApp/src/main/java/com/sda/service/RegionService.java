package com.sda.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sda.dao.RegionDao;
import com.sda.model.Region;

public class RegionService {

    private RegionDao regionDao = new RegionDao();
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<Region> getAllRegions() {
        System.out.println("  Entering RegionService.getAllRegions");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("  Calling RegionDao.getAllRegions");
        List<Region> regions = regionDao.getAllRegions(session);

        tx.commit();
        session.close();

        System.out.println("  Exiting RegionService.getAllRegions");
        return regions;
    }
    
    public void saveRegion(String newRegion) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Region region = new Region();
    	region.setRegionName(newRegion);
    	
    	regionDao.saveRegion(session, region);
    	
    	tx.commit();
    	session.close();
    	
    	
    }
    
    public void deleteRegion(int id) {
    	
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	
    	
    	Region r = new Region();
    	r.setRegionId(id);
    	
    	regionDao.deleteRegion(session, r);
    	
    	tx.commit();
    	session.close();
    }
    
    public void updateRegion(int id, String newName) {
    	
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Region r = session.get(Region.class, id);
    	
    	r.setRegionName(newName);
    	
    	regionDao.updateRegion(session, r);
    	
    	
    	tx.commit();
    	session.close();
    }
   
 public Region getRegionById(int id) {
    	
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	
    	
    	Region r = new Region();
    	r = regionDao.getRegionById(session, id);
    	
    	
    	tx.commit();
    	session.close();
    	
    	return r;
    }
}
