package com.hungerhelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungerhelp.models.Agent;
import com.hungerhelp.models.Donation;
import com.hungerhelp.models.Donor;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
	List<Donation> findByDonorOrderByIdDesc(Donor donor);
	List<Donation> findByAgentOrderByIdDesc(Agent agent);
	List<Donation> findByAgentAndStatus(Agent agent,String status);
}
