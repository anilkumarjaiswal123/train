package com.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.controller.UserController;
import com.demo.dto.User;
import com.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	UserService userService;
	
	@InjectMocks
	UserController userController;
	
	@Autowired
	  private WebApplicationContext wac;
	
	  @Before
	  public void setup() {
		  MockitoAnnotations.initMocks(this);
		  this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
	  }
	
	    @Test
		public void userLogin() throws Exception{
		  User user=new User();
		  user.setMobNo(1234567890l);
		  user.setPassword("123456");
		  user.setUserId("chhote");
		  mockMvc.perform(MockMvcRequestBuilders
					.post("/login/users/userLogin")
				    .contentType(MediaType.APPLICATION_JSON)
				    .accept(MediaType.APPLICATION_JSON));
					verify(userService,times(0)).findByUserIdPassword("chhote", "123456");
	  }
	  
	  
}
