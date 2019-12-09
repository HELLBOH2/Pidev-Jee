package service;

import java.util.List;

import javax.ejb.Remote;

import model.Event;

@Remote
public interface EventServiceRemote {

	public int addEvent(Event event);
	void UpdateEvent(Event event);
	void DeleteEvent(int idEvent);
	List<Event> listEvents();
	public byte[] listEventspicture(int event);
	public List<Event> listEventValidate();
	//public  boolean sendMail(String from,String password, String message,String to[]);
	public byte[] findPictureByProductName(String productName) ;
	Event findEventByName(String EventName);
}
