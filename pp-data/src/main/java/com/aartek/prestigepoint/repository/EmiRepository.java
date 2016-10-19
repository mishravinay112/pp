package com.aartek.prestigepoint.repository;

import java.util.List;
import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;

public interface EmiRepository {
	List<Emi> getFeesDetails(Integer emiId);

	List<Registration> getRegistrationDetails(Integer emiId);

	List<Emi> getRegistrationId(Integer emiId);

	void deleteEmiDetails(Integer emiId);

	public List<Object> editEmi(Integer emiId);

	List<Emi> getAllEmiId();

	boolean addEmiInfo(Emi emi);

	Emi editEimForSingleRecord(Integer emiId);

	boolean editEmiInfo(Emi emi);

	List<Registration> getEmiDetails(Integer stuRegistrationId);

}
