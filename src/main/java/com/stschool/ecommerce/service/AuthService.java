package com.stschool.ecommerce.service;

import com.stschool.ecommerce.exceptions.CustomerExistsException;
import com.stschool.ecommerce.exceptions.CustomerNotFoundException;
import com.stschool.ecommerce.exceptions.InvalidCredentialsException;
import com.stschool.ecommerce.entity.Customer;

public interface AuthService {

    Customer signup(Customer customer) throws CustomerExistsException;

    Customer login(String email, String password) throws InvalidCredentialsException;

    Customer getCustomerByEmail(String email) throws CustomerNotFoundException;
}
