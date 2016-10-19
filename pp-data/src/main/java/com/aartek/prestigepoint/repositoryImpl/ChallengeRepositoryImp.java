package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.AddChallenge;
import com.aartek.prestigepoint.repository.ChallengeRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class ChallengeRepositoryImp implements ChallengeRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ChallengeRepositoryImp.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void addChallengeInformation(AddChallenge addChallenge) {
		hibernateTemplate.saveOrUpdate(addChallenge);
	}

	public List<AddChallenge> allAddChallengeList() {
		List<AddChallenge> allAddChallengeList = hibernateTemplate.find("from AddChallenge ac where ac.isDeleted="
				+ IConstant.IS_DELETED);
		return allAddChallengeList;
	}

	public List<AddChallenge> viewChallengeDetails() {
		List<AddChallenge> getChallengeDetails = hibernateTemplate.find("from AddChallenge ac where ac.isDeleted="
				+ IConstant.IS_DELETED + "and ac.isActive=" + IConstant.IS_DELETED);
		return getChallengeDetails;
	}

	public List<Object> updateChallengeInformation(Integer challengeId) {
		List<Object> challengeList = hibernateTemplate.find("from AddChallenge a where a.challengeId=" + challengeId);
		return challengeList;
	}

	public void deleteChallengeInformation(Integer challengeId) {
		AddChallenge addChallenge = hibernateTemplate.get(AddChallenge.class, challengeId);
		addChallenge.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != addChallenge) {
			hibernateTemplate.update(addChallenge);
		}
	}

	/*public AddChallenge ChallengeValue(Integer challengeValue) {
		AddChallenge addChallenge2 = null;
		List<AddChallenge> addChallenge = hibernateTemplate.find("from AddChallenge acw where acw.challengeId="
				+ challengeValue);
		if (addChallenge != null) {
			addChallenge2 = addChallenge.get(0);
		}
		return addChallenge2;
	}*/

}