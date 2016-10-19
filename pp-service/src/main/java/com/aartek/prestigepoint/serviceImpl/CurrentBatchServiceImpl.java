package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.CurrentBatch;
import com.aartek.prestigepoint.repository.CurrentBatchRepository;
import com.aartek.prestigepoint.service.CurrentBatchService;
import com.aartek.prestigepoint.util.CamelCase;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class CurrentBatchServiceImpl implements CurrentBatchService {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CurrentBatchServiceImpl.class);
  /**
   * CurrentButchServiceImpl, acts as a interface between controller and
   * Repository in order to serve request for current batch page.
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
  @Autowired
  private CurrentBatchRepository currentBatchRepository;

  /**
   * use for add current batch information
   * 
   * @param currentBatch
   */
  public boolean addCurrentBatchInformation(CurrentBatch currentBatch) {
    boolean status = false;
    if (currentBatch != null) {
      currentBatch.setIsDeleted(IConstant.IS_DELETED);
      String name= CamelCase.produceCamelCase(currentBatch.getBatchName());
      currentBatch.setBatchName(name);
    
      status = currentBatchRepository.addCurrentBatchInformation(currentBatch);
      return status;
    }
    return status;
  }

  /**
   * get all current batch.
   */
  public List<CurrentBatch> getAllCurrentBatch() {
    List<CurrentBatch> currentBatchs = currentBatchRepository.getAllCurrentBatch();
    
    return currentBatchs;
  }

  /**
   * Delete current batch.
   */
  public void deleteCurrentBatch(Integer currentBatchId) {
    currentBatchRepository.deleteCurrentBatch(currentBatchId);
  }

  /**
   * Update current batch information
   */
  public CurrentBatch updateCurrentBatch(Integer currentBatchId) {
    List<CurrentBatch> currentBatchs = currentBatchRepository.updateCurrentBatch(currentBatchId);
    if (currentBatchs != null) {
      CurrentBatch batch = currentBatchs.get(0);
      return batch;
    }
    return null;
  }

}
