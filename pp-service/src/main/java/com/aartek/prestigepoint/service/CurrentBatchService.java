package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.CurrentBatch;

public interface CurrentBatchService {

	public boolean addCurrentBatchInformation(CurrentBatch currentBatch);

	public List<CurrentBatch> getAllCurrentBatch();

	public void deleteCurrentBatch(Integer currentBatchId);

	public CurrentBatch updateCurrentBatch(Integer currentBatchId);

}
