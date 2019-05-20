package com.sda.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sda.model.Region;

public class RegionDao {

    public List<Region> getAllRegions(Session session) {
        System.out.println("    Entering RegionDao.getAllRegions");
        
        Query query = session.createQuery("from Region");
        List<Region> regions = query.getResultList();
        
        System.out.println("    Exiting RegionDao.getAllRegions");
        return regions;
    }

    public void saveRegion(Session session, Region region) {
    	
    	session.save(region);
    	
    }
    
    public void deleteRegion(Session session, Region region) {
    	session.delete(region);
    }
    
    public void updateRegion(Session session, Region region) {
    	session.update(region);
    	
    }
    
    public Region getRegionById(Session session, int regionId) {
    	
    	Region region = new Region();
    	
    	region =  session.get(Region.class, regionId);
    	return region;
    }
    
    
    
}
