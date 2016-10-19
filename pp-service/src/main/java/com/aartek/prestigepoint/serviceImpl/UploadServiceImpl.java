package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Upload;
import com.aartek.prestigepoint.repository.UploadRepository;
import com.aartek.prestigepoint.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

  @Autowired
  private UploadRepository uploadRepository;

  public void uploadJar(Upload upload) {
    uploadRepository.uploadJar(upload);
  }

  public List<Upload> downloadJar() {
    List<Upload> l = uploadRepository.downloadJar();
    return l;
  }
}
