package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.Upload;

public interface UploadService {

  public void uploadJar(Upload upload);

  public List<Upload> downloadJar();

}
