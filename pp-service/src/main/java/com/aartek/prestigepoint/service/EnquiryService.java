package com.aartek.prestigepoint.service;

import java.text.ParseException;
import java.util.List;

import com.aartek.prestigepoint.model.Enquiry;

@SuppressWarnings("rawtypes")
public interface EnquiryService {

	public void addEnquiryMessage(Enquiry enquiry) throws ParseException;

	public boolean addAdminEnquiry(Enquiry enquiry) throws ParseException;

	public List getMonthAndYearWiseEnquiryDetails(String month, String year);

	public List getYearWiseEnquiry(String year);

	public List getMonthWiseEnquiry(String month);

}
