package ManagedBean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Services.ClaimService;
import Services.SubscriptionService;
import model.AspNetUser;
import model.Claim;
import model.Pack;
import model.Subscription;

@ManagedBean
@SessionScoped
public class SubscriptionBean {
	private Date date_debut;
	private Date end_date;
	private String payment_method;
	private AspNetUser aspNetUser;
	private Pack pack;
	 private List<Subscription>subscriptions;
	 private String descriptionpack;
	 
	public SubscriptionBean() {
		super();
	}
	
	@EJB
	SubscriptionService subscriptionServices;
	public List<Subscription> getSubscriptions() {
		System.out.println("Subscriptiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiion");
		
			
			subscriptions=subscriptionServices.getAllSubscriptions(LoginBean.i);	
		
		
	
		return subscriptions;
	}
public void submit() {
		//System.out.println("user+   "+ description);
		//List<Subscription>subscriptions=subscriptionServices.getAllSubscriptionsSerch(LoginBean.i,descriptionpack);
	}
	public void Keypress() {
		pack.getDescription();
		System.out.println("keypressssssssssss" );
	}
	
	
	
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public AspNetUser getAspNetUser() {
		return aspNetUser;
	}
	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getDescriptionpack() {
		return descriptionpack;
	}

	public void setDescriptionpack(String descriptionpack) {
		this.descriptionpack = descriptionpack;
	}
	 

}
