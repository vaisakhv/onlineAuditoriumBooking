package com.ust_global.user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class selectedEventsBean
 */
@Stateless
public class selectedEventsBean implements selectedEventsBeanRemote {

    /**
     * Default constructor. 
     */
    public selectedEventsBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(name="selectedEventsUnit")
    EntityManager entityManager;
    
    

}
