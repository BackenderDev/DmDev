package com.bakdaulet.spring.service;

import com.bakdaulet.spring.database.entity.Company;
import com.bakdaulet.spring.database.repository.CrudRepository;
import com.bakdaulet.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}