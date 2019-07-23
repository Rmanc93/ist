package com.ssw.ist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssw.ist.model.Role;
import com.ssw.ist.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepo;

	public Optional<Role> getRoleById(int id) {
		return roleRepo.findById(id);

	}

}
