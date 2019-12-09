package tn.esprit.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Event;
import service.EventService;

@ManagedBean
@SessionScoped
public class EventBean implements Serializable {

	private String name;
	private int number_P;
    private Date dateEvent;
	private String description;
	private String image;
	private int eventIdToBeUpdate;
	private List<Event> events;
	
	@EJB
	EventService eventService;
	
	public EventBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String addEvent() 
	{
		Event event = new Event();
		event.setName(name);
		event.setNumber_P(number_P);
		event.setDateEvent(dateEvent);
		event.setDescription(description);
		event.setImage(image);
		eventService.addEvent(event);
		System.out.println("Event Added");
		return "/Event/afficheEvent?faces-redirect=true";
		
	}
	
	public void deleteEvent(int idEvent) 
	{
		eventService.DeleteEvent(idEvent);
	}
	public String modifier(Event event) 
	{
		this.setName(event.getName());
		this.setDescription(event.getDescription());
		this.setDateEvent(event.getDateEvent());
		this.setNumber_P(event.getNumber_P());
		this.setImage(event.getImage());
		this.setEventIdToBeUpdate(event.getEventId());
		return "/Event/editEvent?faces-redirect=true";
	}
	public String mettreAjourEvent() {
		eventService.UpdateEvent(new Event(eventIdToBeUpdate, dateEvent, description, image, name, number_P));
		return "/Event/afficheEvent?faces-redirect=true";
	}

	public List<Event> getEvents() {
		events = eventService.listEvents();
		return events;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber_P() {
		return number_P;
	}

	public void setNumber_P(int number_P) {
		this.number_P = number_P;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public int getEventIdToBeUpdate() {
		return eventIdToBeUpdate;
	}

	public void setEventIdToBeUpdate(int eventIdToBeUpdate) {
		this.eventIdToBeUpdate = eventIdToBeUpdate;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	
}
