package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interface.CandidateOfferRemote;
import model.CandidateOffer;
import model.Criteria;
import model.Evaluationtest;



@Stateless 
@LocalBean
public class CandidateOfferService implements CandidateOfferRemote{

	@PersistenceContext(unitName = "DBMAP-ejb")
	EntityManager em;
	
	
	@Override
	public List<CandidateOffer> GetAllCandidates() {
		 List<CandidateOffer> list1 = new ArrayList<>();
		 list1 =  em.createQuery("select e from CandidateOffer e", CandidateOffer.class).getResultList(); 
		 //get the lazy associations 
 		 for (CandidateOffer test : list1) {
	
 			test.getAspNetUser();
			test.getJobOffer();
		}
		 
		 return list1;
	}

}
