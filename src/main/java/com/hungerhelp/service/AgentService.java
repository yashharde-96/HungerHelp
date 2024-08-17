package com.hungerhelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerhelp.models.Agent;
import com.hungerhelp.models.Donation;
import com.hungerhelp.models.FoodCollection;
import com.hungerhelp.models.User;
import com.hungerhelp.repository.AgentRepository;
import com.hungerhelp.repository.CollectionRepository;
import com.hungerhelp.repository.DonationRepository;

@Service
public class AgentService {

	@Autowired AgentRepository repo;
	@Autowired UserService uservice;
	@Autowired DonationRepository drepo;
	@Autowired CollectionRepository crepo;
	
	public void saveAgent(Agent agent,String pwd) {
		agent=repo.save(agent);
		User user=new User();
		user.setRole("Agent");
		user.setPwd(pwd);
		user.setId(agent.getId());
		user.setUname(agent.getName());
		user.setUserid(agent.getEmail());
		uservice.saveUser(user);		
	}
	
	public List<Donation> getMyDonations(Agent agent){
		return drepo.findByAgentAndStatus(agent, "In Process");
	}
	
	public Donation getDonationsDetails(int id){
		return drepo.getById(id);
	}
	
	public void collectFood(FoodCollection fc) {
		crepo.save(fc);
	}
	
	public void updateStatus(int id) {
		Donation don=drepo.getById(id);
		don.setStatus("Collected");
		drepo.save(don);
	}
	
	public boolean checkEmail(String email) {
		Agent agent= repo.findByEmail(email);
		return agent==null;
	}
	
	public List<Agent> listAgents(){
		return repo.findAll();
	}
	
	public Agent findById(int id) {
		return repo.getById(id);
	}
	
	public List<FoodCollection> getHistory(int id){
		Agent agent=findById(id);
		return crepo.findByAgent(agent);
	}
	
}
