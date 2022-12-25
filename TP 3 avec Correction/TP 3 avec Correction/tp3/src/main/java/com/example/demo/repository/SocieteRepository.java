package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Societe;

@Repository
public interface SocieteRepository extends JpaRepository<Societe, Long> {

}
