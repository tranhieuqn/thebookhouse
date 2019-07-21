package com.thebookhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebookhouse.model.Address;
import com.thebookhouse.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public String getFullAddressFromReference(Address address) {
        return addressRepository.getFullAddressFromReference(address);
    }
}
