package com.cognizant.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.book.bean.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByRoleId(int id);

}
