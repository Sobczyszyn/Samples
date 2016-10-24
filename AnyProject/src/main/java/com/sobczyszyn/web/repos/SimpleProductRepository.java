package com.sobczyszyn.web.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SimpleProductRepository extends JpaRepository<Product, Integer> {

}
