package com.example.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.role.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	 @Query(value = "SELECT * FROM roles WHERE first_name = ?1", nativeQuery = true)
	public Role findByFirstName(@RequestParam("firstName") String firstName);
	 
	 @Query(value = "SELECT * FROM roles WHERE nic = ?1", nativeQuery = true)
	public Role findRoleByNic(@RequestParam("nic") String nic);
	 
	 @Query(value = "SELECT first_name,last_name,nic FROM roles WHERE nic = ?1 AND organization = ?2", nativeQuery = true)
	public List<?> findRoleByNicAndOrganization(@RequestParam("nic") String nic , @RequestParam("organization") String organization);
	 
	 

}
