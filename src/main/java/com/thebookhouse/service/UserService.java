package com.thebookhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebookhouse.model.Address;
import com.thebookhouse.model.User;
import com.thebookhouse.repository.AddressRepository;
import com.thebookhouse.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired 
    private MailService mailService;

    public User findOne(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User register(User user) {
        user.setIsActive(0);
        mailService.sendUserRegisterConfirmationMail(user);
        return userRepository.save(user);
    }

    public User confirm(User user) {
        user.setIsActive(1);
        return userRepository.save(user);
    }

    public User deactive(User user) {
        mailService.sendUserDeactiveNotificationMail(user);
        user.setIsActive(0);
        return userRepository.save(user);
    }

    public User updateAddress(User user, Address address) {
        address.setId(0);
        address.setFullAddress(addressRepository.getFullAddressFromReference(address)
                + ", " + address.getDetail());
        user.setAddress(address);
        return userRepository.save(user);
    }
}
