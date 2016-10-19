package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Enquiry;

@SuppressWarnings("rawtypes")
public interface EnquiryRepository {

	public void addEnquiryMessage(Enquiry enquiry);

	public boolean addAdminEnquiry(Enquiry enquiry);

	public List getMonthAndYearWiseEnquiryDetails(String month, String year);

	public List getYearWiseEnquiry(String year);

	public List getMonthWiseEnquiry(String month);

}
