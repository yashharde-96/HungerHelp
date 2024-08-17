package com.hungerhelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerhelp.models.Donation;
import com.hungerhelp.models.Donor;
import com.hungerhelp.models.User;
import com.hungerhelp.repository.DonationRepository;
import com.hungerhelp.repository.DonorRepository;

@Service
public class DonorService {

	@Autowired DonorRepository repo;
	@Autowired DonationRepository drepo;
	@Autowired UserService uservice;
	
	public void saveDonor(Donor donor,String pwd) {
		donor=repo.save(donor);
		User user=new User();
		user.setRole("Donor");
		user.setPwd(pwd);
		user.setId(donor.getId());
		user.setUname(donor.getName());
		user.setUserid(donor.getEmail());
		uservice.saveUser(user);		
	}
	
	public void donate(Donation don) {
		don.setStatus("Pending");
		drepo.save(don);
	}
	
	public List<Donation> getMyDonations(Donor donor){
		return drepo.findByDonorOrderByIdDesc(donor);
	}
	
	
	public boolean checkEmail(String email) {
		Donor donor= repo.findByEmail(email);
		return donor==null;
	}
	
	public List<Donor> listDonors(){
		return repo.findAll();
	}
	
	public Donor findById(int id) {
		return repo.getById(id);
	}
}
