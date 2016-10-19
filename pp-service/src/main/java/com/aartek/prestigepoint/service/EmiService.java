package com.aartek.prestigepoint.service;

import java.text.ParseException;
import java.util.List;

import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;

public interface EmiService {

	List<Emi> getFeesDetails(Integer emiId);

	public boolean addEmiInfo(Emi emi) throws ParseException;

	List<Registration> getRegistrationDetails(Integer emiId);

	public Integer getRegistrationId(Integer emiId);

	void deleteEmiDetails(Integer emiId);

	List<Emi> getAllEmiId();

	public Emi editEmi(Integer emiId);

	public Emi editEimForSingleRecord(Integer emiId);

	boolean editEmiInfo(Emi emi) throws ParseException;

}
