package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Event;

/**
 * Session Bean implementation class EventService
 */
@Stateless
@LocalBean
public class EventService implements EventServiceRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public EventService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addEvent(Event event) {
		// TODO Auto-generated method stub
		em.persist(event);
		return event.getEventId();
	}

	@Override
	public void UpdateEvent(Event event) {
		// TODO Auto-generated method stub
		em.merge(event);
	}

	@Override
	public void DeleteEvent(int idEvent) {
		// TODO Auto-generated method stub
		em.remove(em.find(Event.class, idEvent));
	}

	@Override
	public List<Event> listEvents() {
		// TODO Auto-generated method stub
		List<Event> events = em.createQuery("select e from Event e", Event.class).getResultList();
		return events;
	}

	@Override
	public byte[] listEventspicture(int event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> listEventValidate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] findPictureByProductName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event findEventByName(String EventName) {
		// TODO Auto-generated method stub
		return null;
	}

}
