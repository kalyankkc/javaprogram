package com.mindtree.campusmind.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.campusmind.entity.CampusMind;

@Repository
public interface CampusmindRepository extends JpaRepository<CampusMind, Integer>{

	@Query("from CampusMind")
	List<CampusMind> getMinds();
}
