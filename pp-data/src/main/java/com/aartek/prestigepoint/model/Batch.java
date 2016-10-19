package com.aartek.prestigepoint.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "batch")
public class Batch implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BATCH_ID")
	private Integer batchId;

	@Column(name = "BATCH_NAME")
	private String batchName;

	@Column(name = "START_DATE")
	private String startDate;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "BATCH_ID", updatable = false)
	private List<Registration> registrationList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "BATCH_ID")
	private List<CurrentBatch> currentBatchList;

	/**
	 * @return the batchId
	 */
	public Integer getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId
	 *            the batchId to set
	 */
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}

	/**
	 * @param batchName
	 *            the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the isDeleted
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the registrationList
	 */
	public List<Registration> getRegistrationList() {
		return registrationList;
	}

	/**
	 * @param registrationList
	 *            the registrationList to set
	 */
	public void setRegistrationList(List<Registration> registrationList) {
		this.registrationList = registrationList;
	}

	public List<CurrentBatch> getCurrentBatchList() {
		return currentBatchList;
	}

	public void setCurrentBatchList(List<CurrentBatch> currentBatchList) {
		this.currentBatchList = currentBatchList;
	}

}
