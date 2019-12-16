package com.mindtree.cafemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.cafemanagement.entity.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Integer> {

}
