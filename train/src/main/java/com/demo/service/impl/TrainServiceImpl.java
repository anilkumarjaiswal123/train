package com.demo.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.Train;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.TrainRepository;
import com.demo.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {
	
	private Logger logger  = LoggerFactory.getLogger(TrainServiceImpl.class);
	
	@Autowired
	TrainRepository trainRepository;
	
	public List<Train> findByFromToJourneyDate(String trainFrom,String trainTo ,java.util.Date journeyDate){
		List<Train> listTrain=trainRepository.findByFromToJourneyDate(trainFrom, trainTo, journeyDate);
		if(listTrain.isEmpty()) {
			logger.error("Train Not found.:-{}",listTrain);
			throw new ResourceNotFoundException("Train Not Found");
		}
		
		return listTrain;	
	}
	
	@Transactional
	public Train findByTrainId(Long trainId){
		Train train=trainRepository.findByTrainId(Long.valueOf(trainId));
		if(train==null) {
	     logger.error("Train Not found.:-{}",train);
	     return null;		
	  }
		return train;
  }
//	@Transactional
//	public Train findByTrainId(Long trainId,Long noOfSeats){
//		Train updatedTrain=null;
//		Train train=trainRepository.findByTrainId(Long.valueOf(trainId));
//		if(train==null) {
//			logger.error("Train Not found.:-{}",train);
//			throw new ResourceNotFoundException("Train Not Found");
//		}
//		Long availableSeats=train.getAvailableSeats();
//		availableSeats=availableSeats-noOfSeats.longValue();
//		if(availableSeats>=noOfSeats) {
//			trainRepository.updateTrain(availableSeats, trainId);
//			updatedTrain=trainRepository.findByTrainId(Long.valueOf(trainId));
//		}
//		else {
//			logger.error("Seats Not Available");
//			throw new ResourceNotFoundException("Seats Not Available");
//		}
//		return updatedTrain;
//	}

}
