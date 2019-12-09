package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interface.ClaimRemote;
import Interface.PackRemote;
import model.Pack;

@Stateless
@LocalBean
public class PackService implements PackRemote  {
	@PersistenceContext(unitName = "DBMAP-ejb")
	EntityManager em;

	@Override
		public List<Pack> getAllPacks() {
			// TODO Auto-generated method stub
		    return em.createQuery("SELECT a FROM Pack a ", Pack.class).getResultList();  
		}

}
