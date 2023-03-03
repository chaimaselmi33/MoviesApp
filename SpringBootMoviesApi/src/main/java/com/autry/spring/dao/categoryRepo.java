package com.autry.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autry.spring.models.Category;

@Repository
public interface categoryRepo extends JpaRepository<Category, Long>{

}
