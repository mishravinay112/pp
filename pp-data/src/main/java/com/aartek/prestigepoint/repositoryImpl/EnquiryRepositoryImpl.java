package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.repository.EnquiryRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("rawtypes")
@Repository
public class EnquiryRepositoryImpl implements EnquiryRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(EnquiryRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void addEnquiryMessage(Enquiry enquiry) {
		hibernateTemplate.saveOrUpdate(enquiry);
	}

	public boolean addAdminEnquiry(Enquiry enquiry) {
		if (enquiry != null) {
			hibernateTemplate.saveOrUpdate(enquiry);
			return true;
		}
		return false;
	}

	public List getYearWiseEnquiry(String year) {
		List enquiryList = hibernateTemplate
				.find("select COUNT(e.enquiryId) ,e.date, SUM(CASE WHEN e.status = '1' THEN 1 ELSE 0 END) from Enquiry e where e.isDeleted="
						+ IConstant.IS_DELETED + " and YEAR(e.date) = '" + year + "' GROUP BY MONTH(e.date)");
		return enquiryList;
	}

	public List getMonthAndYearWiseEnquiryDetails(String month, String year) {
		List enquiryList = hibernateTemplate
				.find("select COUNT(e.enquiryId) ,e.date, SUM(CASE WHEN e.status = '1' THEN 1 ELSE 0 END),handledBy from Enquiry e where e.isDeleted="
						+ IConstant.IS_DELETED
						+ " and YEAR(e.date) = '"
						+ year
						+ "' and MONTH(e.date)='"
						+ month
						+ "' GROUP BY handledBy");

		return enquiryList;
	}

	public List getMonthWiseEnquiry(String month) {
		List enquiryList = hibernateTemplate
				.find("select COUNT(e.enquiryId) ,e.date, SUM(CASE WHEN e.status = '1' THEN 1 ELSE 0 END) from Enquiry e where e.isDeleted="
						+ IConstant.IS_DELETED + " and MONTH(e.date) = '" + month + "' GROUP BY YEAR(e.date)");
		return enquiryList;
	}
}
