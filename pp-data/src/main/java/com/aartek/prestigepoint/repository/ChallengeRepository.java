package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.AddChallenge;

public interface ChallengeRepository {

	public void addChallengeInformation(AddChallenge addChallenge);

	public List<AddChallenge> allAddChallengeList();

	public List<AddChallenge> viewChallengeDetails();

	public List<Object> updateChallengeInformation(Integer challengeId);

	public void deleteChallengeInformation(Integer challengeId);

	//public AddChallenge ChallengeValue(Integer challengeValue);

}
