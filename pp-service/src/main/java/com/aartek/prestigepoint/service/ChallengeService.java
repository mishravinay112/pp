package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.AddChallenge;

public interface ChallengeService {

	public boolean addChallengeInformation(AddChallenge addChallenge);

	public List<AddChallenge> allAddChallengeList();

	public List<AddChallenge> viewChallengeDetails();

	public AddChallenge updateChallengeInformation(Integer challengeId);

	public void deleteChallengeInformation(Integer challengeId);

	public void ChallengeValue(String challengeIdValue, Integer challengeValue);

}
