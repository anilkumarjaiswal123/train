package com.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.dto.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long>{
	
	@Query("SELECT t FROM Train t WHERE t.trainFrom = ?1 and t.trainTo=?2 and t.journeyDate=?3")
    List<Train> findByFromToJourneyDate(String trainFrom,String trainTo,java.util.Date journeyDate );
	
	@Query("SELECT t FROM Train t WHERE t.trainId = ?1")
    Train findByTrainId(Long trainId );
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Train t SET t.availableSeats = :availableSeats WHERE t.trainId = :trainId")
    int updateTrain(@Param("availableSeats") Long availableSeats, @Param("trainId") Long trainId);
	
	
	

}
