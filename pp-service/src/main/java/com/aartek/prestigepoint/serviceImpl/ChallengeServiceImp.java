package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.AddChallenge;
import com.aartek.prestigepoint.repository.ChallengeRepository;
import com.aartek.prestigepoint.service.ChallengeService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class ChallengeServiceImp implements ChallengeService {
	@Autowired
	private ChallengeRepository addChallengeRepository;

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ChallengeServiceImp.class);

	public boolean addChallengeInformation(AddChallenge addChallenge) {
		addChallenge.setIsDeleted(IConstant.IS_DELETED);
		addChallenge.setIsActive(IConstant.IS_DELETED_DEACTIVE);
		addChallengeRepository.addChallengeInformation(addChallenge);
		return true;
	}

	public List<AddChallenge> allAddChallengeList() {
		List<AddChallenge> allAddChallengeList = new ArrayList<AddChallenge>();
		allAddChallengeList = addChallengeRepository.allAddChallengeList();
		return allAddChallengeList;
	}

	public List<AddChallenge> viewChallengeDetails() {
		List<AddChallenge> getChallengeDetails = new ArrayList<AddChallenge>();
		getChallengeDetails = addChallengeRepository.viewChallengeDetails();
		return getChallengeDetails;
	}

	public AddChallenge updateChallengeInformation(Integer challengeId) {
		List<Object> allAddChallengeList = new ArrayList<Object>();
		AddChallenge addChallenge = null;
		allAddChallengeList = addChallengeRepository.updateChallengeInformation(challengeId);
		for (Object object : allAddChallengeList) {
			addChallenge = (AddChallenge) object;
		}
		return addChallenge;
	}

	public void ChallengeValue(String challengeIdValue, Integer challengeValue) {

		if (challengeIdValue != null && challengeValue != null) {
			AddChallenge addChallenge = (AddChallenge) addChallengeRepository.updateChallengeInformation(challengeValue).get(0);
			if (challengeIdValue.equals("true")) {

				addChallenge.setIsActive(IConstant.IS_DELETED);

				addChallengeRepository.addChallengeInformation(addChallenge);
			} else {
				System.out.println("else=" + addChallenge);
				addChallenge.setIsActive(IConstant.IS_DELETED_DEACTIVE);
				addChallengeRepository.addChallengeInformation(addChallenge);
			}

		}
	}

	public void deleteChallengeInformation(Integer challengeId) {
		addChallengeRepository.deleteChallengeInformation(challengeId);
	}
}
