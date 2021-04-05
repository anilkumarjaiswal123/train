package com.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.dto.Train;

@Validated
@FeignClient(value = "train-service", url = "http://localhost:8301/train/trains")
//@FeignClient(name = "http://TRAIN-SERVICE/train/trains",fallback = TicketFallback.class,configuration = FooConfiguration.class)
public interface TicketClient {

	@GetMapping("findByTrainId/{trainId}")
	public Train findByTrainId(@PathVariable Long trainId);
	
}


