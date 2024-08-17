package com.hungerhelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungerhelp.models.Agent;
import com.hungerhelp.models.FoodCollection;

@Repository
public interface CollectionRepository extends JpaRepository<FoodCollection, Integer> {

	List<FoodCollection> findByAgent(Agent agent);
}
