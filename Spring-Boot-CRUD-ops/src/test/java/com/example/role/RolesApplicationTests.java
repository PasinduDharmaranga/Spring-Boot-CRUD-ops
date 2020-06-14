package com.example.role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.example.role.controller.RoleController;
import com.example.role.model.Role;
import com.example.role.repository.RoleRepository;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RolesApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleController roleController;

    @MockBean
    private RoleRepository roleRepository;
    
    @Test
    public void addEmployeeTest() throws Exception {
    	
    String jasone = "{\"nic\":\"948769357V\",\"firstName\":\"Beta\",\"lastName\":\"johnston\",\"organization\":\"MIT\",\"roleType\":\"Assistant\"}";
        mockMvc.perform(post("/api/role")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jasone))
            .andExpect(status().isOk());
    }
    
    @Test
    public void getAllRoles() throws Exception {
    	Gson g = new Gson();
    	Role u = new Role();
        Role role = roleController.createNote(u);

        mockMvc.perform(get("/api/role")
            .contentType(MediaType.APPLICATION_JSON)
            .content(g.toJson(role)))
            .andExpect(status().isOk());
    }
     
    @Test
    public void findByFirstname() throws Exception {
    	Gson g = new Gson();
    	 Role u = new Role();
        Role role = roleController.createNote(u);

        mockMvc.perform(get("/api/role/Jude")
            .contentType(MediaType.APPLICATION_JSON)
            .content(g.toJson(role)))
            .andExpect(status().isOk());
    }
    
    @Test
    public void findByNicAndOrganization() throws Exception {
    	Gson g = new Gson();
    	 Role u = new Role();
        Role role = roleController.createNote(u);

        mockMvc.perform(get("/api/role/94867253V/startUp")
            .contentType(MediaType.APPLICATION_JSON)
            .content(g.toJson(role)))
            .andExpect(status().isOk());
    }
    
    @Test
    public void deleteById() throws Exception {
    	
        roleController.deleteNote((long) 10);

        mockMvc.perform(delete("/api/role/10")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
    
   @Test
    public void updateById() throws Exception {
        String jason = "{\"nic\":\"948769357V\",\"firstName\":\"Beta\",\"lastName\":\"johnston\",\"organization\":\"MIT\",\"roleType\":\"Assistant\"}";
        mockMvc.perform(put("/api/role/11")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jason))
            .andExpect(status().isOk());
    }     
}











/*
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class EasyNotesApplicationTests {
 * 
 * @Autowired
 * 
 * @Test public void testHomeController() { IndexController homeController = new
 * IndexController(); String result = homeController.sayHello();
 * assertEquals(result,
 * "Hello and Welcome to the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint."
 * );
 * 
 * }
 * 
 * @InjectMocks private RoleController roleController;
 * 
 * @Mock private RoleRepository roleRepository;
 * 
 * //@Before public void init() { MockitoAnnotations.initMocks(this); }
 * 
 * @Test public void testGetUserById() { Role u = new Role();
 * u.setFirstName("Jude");
 * when(roleRepository.findByFirstName("Jude")).thenReturn(u);
 * 
 * Role role = roleController.getRolesByFirstName("Jude");
 * 
 * verify(roleRepository).findByFirstName("Jude");
 * 
 * assertEquals("Jude", role.getFirstName()); }
 * 
 * 
 * @Autowired MockMvc mvc; //@MockBean EmployeeService employeeService;
 * 
 * @Test public void addEmployeeTest() throws Exception { Gson g = new Gson();
 * Role u = new Role(); Role emp = roleController.createNote(u);
 * 
 * mvc.perform(post("/api/employee") .contentType(MediaType.APPLICATION_JSON)
 * .content(g.toJson(emp))) .andExpect(status().isOk()); }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */