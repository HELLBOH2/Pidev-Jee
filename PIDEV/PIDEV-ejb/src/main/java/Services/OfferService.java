package Services;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Interface.OfferRemote;
import model.JobOffer;

@Stateless
@LocalBean
public class OfferService implements OfferRemote {


	@PersistenceContext(unitName = "DBMAP-ejb")
	EntityManager em;
	
	public Set<JobOffer> getAlloffre() {
		TypedQuery<JobOffer> query = em
				.createQuery("SELECT e FROM JobOffer e ", JobOffer.class);
		Set<JobOffer> offre = new HashSet<JobOffer>();
		offre.addAll(query.getResultList());
		return offre;
		
	}
}
