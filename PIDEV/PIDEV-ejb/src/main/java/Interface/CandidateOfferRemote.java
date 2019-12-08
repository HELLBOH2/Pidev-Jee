package Interface;

import java.util.List;

import javax.ejb.Remote;

import model.CandidateOffer;

@Remote
public interface CandidateOfferRemote {
	public List<CandidateOffer> GetAllCandidates();
}
