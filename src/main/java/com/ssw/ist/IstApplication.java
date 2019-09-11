package com.ssw.ist;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.ssw.ist.model.Employee;
import com.ssw.ist.model.Role;
import com.ssw.ist.repository.RoleRepository;
import com.ssw.ist.repository.UserRepository;

@SpringBootApplication
public class IstApplication {
	
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(IstApplication.class, args);
	}
	
	@PostConstruct
	private void addusers() {
		
		Role adminr = new Role();
		adminr.setId(1);
		adminr.setName("ROLE_ADMIN");
		
		Role userr = new Role();
		userr.setId(2);
		userr.setName("ROLE_USER");
		
		roleRepo.save(adminr);
		roleRepo.save(userr);
		
		List<Employee> adminL = userRepo.getOneByUsername("admin");
		
		if(adminL.size() == 0) {
			Employee admin = new Employee();
			admin.setsName("admin");
			admin.setName("admin");
			admin.setUsername("admin");
			admin.setPassword("12345");
			admin.setRole(adminr);
			userRepo.save(admin);
		}
	}
	

}
