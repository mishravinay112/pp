package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.CurrentBatch;

public interface CurrentBatchRepository {

  public boolean addCurrentBatchInformation(CurrentBatch currentBatch);

  public List<CurrentBatch> getAllCurrentBatch();

  public void deleteCurrentBatch(Integer currentBatchId);

  public List<CurrentBatch> updateCurrentBatch(Integer currentBatchId);

}
