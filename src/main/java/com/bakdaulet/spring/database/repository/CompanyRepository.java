package com.bakdaulet.spring.database.repository;

import com.bakdaulet.spring.bpp.Auditing;
import com.bakdaulet.spring.bpp.Transaction;
import com.bakdaulet.spring.database.entity.Company;
import com.bakdaulet.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transaction
@Auditing
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company> {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CompanyRepository.class);
    private final ConnectionPool pool1;

    private final List<ConnectionPool> poolList;

    @Value("${db.pool.size}")
    private final Integer poolSize;


    @PostConstruct
    private void init() {
        log.warn("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method... ");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method... ");
    }

}
