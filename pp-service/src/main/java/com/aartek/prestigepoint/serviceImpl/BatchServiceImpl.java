package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.repository.BatchRepository;
import com.aartek.prestigepoint.service.BatchService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class BatchServiceImpl implements BatchService {

	private static final Logger logger = Logger.getLogger(BatchServiceImpl.class);

	@Autowired
	private BatchRepository batchRepository;

	/**
	 * Method get all batch list form database and display in table.
	 */
	public List<Batch> getAllBatchName() {
		List<Batch> list = new ArrayList<Batch>();
		logger.info("This is Info service!");
		list = batchRepository.getAllBatchName();
		return list;
	}

	/**
	 * Get batch information for edit batch details.
	 * 
	 * @param batchId
	 */
	public Batch editBatch(Integer batchId) {
		List<Object> list = new ArrayList<Object>();
		Batch batch = null;
		list = batchRepository.editBatch(batchId);
		for (Object object : list) {
			batch = (Batch) object;
		}
		return batch;
	}

	/**
	 * Method use for save batch information.
	 * 
	 * @param batch
	 */
	public boolean addBatch(Batch batch) {
		boolean status = false;
		if (batch != null) {
			batch.setIsDeleted(IConstant.IS_DELETED);
			status = batchRepository.addBatch(batch);
			return status;
		} else {
			return status;
		}
	}

	/**
	 * Delete batch information.
	 * 
	 * @param batchId
	 */
	public void deleteBatch(Integer batchId) {
		batchRepository.deleteBatch(batchId);
	}

}
