package com.thebookhouse.repository;

import org.springframework.stereotype.Repository;

import com.thebookhouse.model.Address;

@Repository
public interface AddressRepository {

    public String getFullAddressFromReference(Address address);

}
