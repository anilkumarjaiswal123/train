package com.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.Train;
import com.demo.model.TrainResponse;
import com.demo.service.TrainService;

@RestController
@RequestMapping("trains")
@Validated
public class TrainController {
	private Logger logger = LoggerFactory.getLogger(TrainController.class);

	@Autowired
	TrainService trainService;
	
	@PostMapping("trainSearch")
	public ResponseEntity<List<Train>> trainSearch(@Valid @RequestBody TrainResponse trainResponse){
		logger.info("Train search is being called for service: {}",trainResponse);
		List<Train> listTrain=trainService.findByFromToJourneyDate(trainResponse.getTrainFrom(), trainResponse.getTrainTo(), trainResponse.getJourneyDate());
		return ResponseEntity.ok().body(listTrain);	
	}
	
	@GetMapping("findByTrainId/{trainId}")
	public Train findByTrainId(@PathVariable @Positive  Long trainId){
		logger.info("Train find is being called for service: {}",trainId);
		Train train=trainService.findByTrainId(trainId);
		return train;
	}
	
}
