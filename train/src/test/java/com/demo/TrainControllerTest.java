package com.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.controller.TrainController;
import com.demo.dto.Train;
import com.demo.service.TrainService;
import com.demo.service.impl.TrainServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class TrainControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	TrainService trainService;
	
	@InjectMocks
	TrainController trainController;
	
	
	@Autowired
	  private WebApplicationContext wac;
	
	  @Before
	  public void setup() {
		  MockitoAnnotations.initMocks(this);
		  this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
	  }
	
	@Test
	public void trainSearchtest() throws Exception {
		String sDate1="2021-06-01";  
	    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
		Train train=new Train();
		train.setAvailableSeats(10l);
		train.setTotalSeats(100l);
		train.setTrainFrom("delhi");
		train.setTrainTo("bangalore");
		train.setJourneyDate(date1);
		train.setTrainId(100l);
		List<Train> listTrain=new ArrayList<Train>();
		listTrain.add(train);
		  
		when(trainService.findByFromToJourneyDate("delhi", "bangalore", date1)).thenReturn(listTrain);
		mockMvc.perform(MockMvcRequestBuilders
				.post("/train/trains/trainSearch")
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON));
				verify(trainService,times(0)).findByFromToJourneyDate("delhi", "bangalore", date1);
	}
	
	@Test
	public void bookTicketTest() throws Exception{
		String sDate1="2021-06-01";  
	    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
		Train train=new Train();
		train.setAvailableSeats(10l);
		train.setTotalSeats(100l);
		train.setTrainFrom("delhi");
		train.setTrainTo("bangalore");
		train.setJourneyDate(date1);
		train.setTrainId(100l);
		when(trainService.findByTrainId(100l)).thenReturn(train);
		mockMvc.perform(MockMvcRequestBuilders
				.post("/train/trains/bookTicket")
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON));
				verify(trainService,times(0)).findByTrainId(100l);
	}

}
