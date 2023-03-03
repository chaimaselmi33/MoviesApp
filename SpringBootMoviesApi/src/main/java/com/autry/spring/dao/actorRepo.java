package com.autry.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autry.spring.models.Actor;

@Repository
public interface actorRepo extends JpaRepository<Actor, Long>{

}
