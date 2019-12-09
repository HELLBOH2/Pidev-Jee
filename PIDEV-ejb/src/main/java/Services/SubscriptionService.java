package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interface.SubscriptionRemote;

import model.Subscription;

@Stateless
@LocalBean
public class SubscriptionService implements SubscriptionRemote {
	@PersistenceContext(unitName = "DBMAP-ejb")
	EntityManager em;
	@Override
	public List<Subscription> getAllSubscriptions(int id) {
		 return em.createQuery("SELECT a FROM Subscription a WHERE a.aspNetUser="+id+"", Subscription.class).getResultList();
		
	}
	

}
