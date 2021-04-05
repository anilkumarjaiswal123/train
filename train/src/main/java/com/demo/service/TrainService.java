package com.demo.service;


import java.util.List;

import com.demo.dto.Train;

public interface TrainService {

	List<Train> findByFromToJourneyDate(String from,String to,java.util.Date journeyDate);
	Train findByTrainId(Long trainId);
	
	
}

