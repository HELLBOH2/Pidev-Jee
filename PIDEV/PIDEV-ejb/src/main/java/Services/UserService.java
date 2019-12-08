package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Interface.UserRemote;
import model.AspNetUser;
import model.CandidateOffer;
import model.Evaluationtest;

@Stateless
@LocalBean
public class UserService implements UserRemote {
	
	@PersistenceContext(unitName = "DBMAP-ejb")
	EntityManager em;
	@Override
	public void addUser(AspNetUser user) {
		// TODO Auto-generated method stub
		
	}
	
	
	public AspNetUser GetCandidateById(int id) {
		return em.find(AspNetUser.class, id);
	}
	
	

	

	@Override
	public AspNetUser getUserByEmailAndPassword(String email, String password) {
		TypedQuery<AspNetUser> query = em
				.createQuery("SELECT e FROM AspNetUser e WHERE e.email=:email AND e.imageURL=:password ", AspNetUser.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		AspNetUser u = null;
		try {
			u = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return u;
	}





	@Override
	public List<CandidateOffer> GetAllCandidates() {
		 List<CandidateOffer> list1 = new ArrayList<>();
		 list1 =  em.createQuery("select e from CandidateOffers e", CandidateOffer.class).getResultList(); 
		return list1;
	}


	@Override
	public CandidateOffer GetCandidateById1(int id) {
		return em.find(CandidateOffer.class, id);
	}


}
