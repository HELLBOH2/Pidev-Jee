package Interface;

import java.util.List;

import javax.ejb.Remote;

import model.AspNetUser;
import model.CandidateOffer;
@Remote
public interface UserRemote {
	public void addUser(AspNetUser user);
	public AspNetUser getUserByEmailAndPassword(String email,String password);
	public List<CandidateOffer> GetAllCandidates();
	public AspNetUser GetCandidateById(int id);
	public CandidateOffer GetCandidateById1(int id);

}
