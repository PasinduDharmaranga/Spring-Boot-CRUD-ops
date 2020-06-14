package com.example.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.role.exception.ResourceNotFoundException;
import com.example.role.model.Role;
import com.example.role.repository.RoleRepository;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/role")
    public  List<Role> getAllNotes() {
        return roleRepository.findAll();
    }
 
    @GetMapping("/role/{nic}")
    public Role getRoleByNic(@PathVariable(value = "nic") String Nic) {
         return roleRepository.findRoleByNic(Nic);
     }
    
    @GetMapping("/role/{nic}/{organization}")
    public List<?> getRoleByNicAndOrganization(@PathVariable(value = "nic") String Nic , @PathVariable(value = "organization") String Organization) {
         return roleRepository.findRoleByNicAndOrganization(Nic , Organization);
     }
    
    @PostMapping("/role")
    public Role createNote(@Valid @RequestBody Role role) {
        return roleRepository.save(role);
    }
    
    @PutMapping("/role/{id}")
    public Role updateNote(@PathVariable(value = "id") Long roleId,
                                           @Valid @RequestBody Role Newrole) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", roleId));

        role.setFirstName(Newrole.getFirstName());
        role.setLastName(Newrole.getLastName());
        role.setNic(Newrole.getNic());
        role.setOrganization(Newrole.getOrganization());
        role.setRoleType(Newrole.getRoleType());
       
        Role updatedNote = roleRepository.save(role);
        return updatedNote;
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", roleId));

        roleRepository.delete(role);

        return ResponseEntity.ok().build();
    }
}
