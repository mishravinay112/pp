package com.aartek.prestigepoint.repository;

import com.aartek.prestigepoint.model.Enquiry;

public interface ContactRepository {

  public boolean addContactMessage(Enquiry enquiry);

}
