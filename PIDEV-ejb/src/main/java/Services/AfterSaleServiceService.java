package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Interface.AfterSaleRemote;
import Interface.ClaimRemote;
import model.AfterSaleService;
import model.Claim;
@Stateless
@LocalBean
public class AfterSaleServiceService implements AfterSaleRemote {
	@PersistenceContext(unitName = "DBMAP-ejb")
	EntityManager em;

	@Override
	public void addAfter(AfterSaleService c) {
		// TODO Auto-generated method stub
		em.persist(c);
		
	}
	@Override
	public void modifier(AfterSaleService emp) {
		
		em.merge(emp);
	}

	@Override
	public void supprimer(int idclaim) {
		// TODO Auto-generated method stub
		AfterSaleService cont = em.find(AfterSaleService.class, idclaim);
		em.remove(cont);
	}
	@Override
	public List<AfterSaleService> getAllAfters(int id) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM AfterSaleService a WHERE a.aspNetUser="+id+"ORDER BY a.requestDate DESC", AfterSaleService.class).getResultList();  
	}
	@Override
	public List<AfterSaleService> getAllAftersale(){
		return em.createQuery("SELECT a FROM AfterSaleService a ORDER BY a.requestDate DESC", AfterSaleService.class).getResultList();  
		
	}
	@Override
	public List<AfterSaleService> getByDes(String a ,int id){
		//int i="SELECT a.aspNetUser1 FROM Claim a WHERE 
		return em.createQuery("SELECT a FROM AfterSaleService a WHERE a.aspNetUser="+id+" and a.description='"+a+"' ORDER BY a.requestDate DESC", AfterSaleService.class).getResultList();  
		
	}
	@Override
	public int getnb(int idpack) {
		System.out.println("entreeeee  in service");
		//return (User) em.createQuery("FROM User a WHERE  u.email = :email").setParameter(email, "Not Found");
	    
		
		List<AfterSaleService> l =em.createQuery("SELECT a FROM AfterSaleService a  WHERE a.pack="+idpack+"ORDER BY a.requestDate DESC", AfterSaleService.class).getResultList();
		
		
		return l.size();
	}

	

	
	
	

}
