package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.CurrentBatch;
import com.aartek.prestigepoint.repository.CurrentBatchRepository;
import com.aartek.prestigepoint.util.IConstant;

/**
 * CurrentButchRepositoryImpl, all the business logics related to current batch
 * defined here.
 * 
 * The functionality it performs are:
 * <ul>
 * <li>Add current batch information</li>
 * <li>Show the current batch information</li>
 * <li>Delete the current batch information</li>
 * <li>Edit the current batch information</li>
 * </ul>
 * 
 * @version 1.0
 * @author Aartek Software Solutions
 * @purpose Current batch business logic
 * @last_modified_dt 18th Nov 2014
 * @last_modified_by Aartek Software Solutions
 */
@Repository
@SuppressWarnings("unchecked")
public class CurrentBatchRepositoryImpl implements CurrentBatchRepository {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CurrentBatchRepositoryImpl.class);

  @Autowired
  private HibernateTemplate hibernateTemplate;

  /**
   * Add current batch information into database.
   */
  public boolean addCurrentBatchInformation(CurrentBatch currentBatch) {
    if (currentBatch != null) {
      hibernateTemplate.saveOrUpdate(currentBatch);
      return true;
    }
    return false;
  }

  /**
   * get all current batch.
   */
  public List<CurrentBatch> getAllCurrentBatch() {
    List<CurrentBatch> currentBatchs = hibernateTemplate.find("from CurrentBatch cb where cb.isDeleted="
        + IConstant.IS_DELETED);
    return currentBatchs;
  }

  public void deleteCurrentBatch(Integer currentBatchId) {
    CurrentBatch currentBatch = (CurrentBatch) hibernateTemplate.get(CurrentBatch.class, currentBatchId);
    currentBatch.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
    if (null != currentBatch) {
      hibernateTemplate.update(currentBatch);
    }
  }

  public List<CurrentBatch> updateCurrentBatch(Integer currentBatchId) {
    List<CurrentBatch> list = null;
    list = hibernateTemplate.find("from CurrentBatch cb where cb.currentBatchId=" + currentBatchId);
    return list;
  }
}
