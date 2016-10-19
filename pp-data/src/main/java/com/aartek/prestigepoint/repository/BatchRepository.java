package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Batch;

public interface BatchRepository {

	public List<Batch> getAllBatchName();

	public List<Object> editBatch(Integer batchId);

	public boolean addBatch(Batch batch);

	public void deleteBatch(Integer batchId);

}
