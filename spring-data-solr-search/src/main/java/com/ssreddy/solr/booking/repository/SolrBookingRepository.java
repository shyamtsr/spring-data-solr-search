package com.ssreddy.solr.booking.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.ssreddy.solr.booking.model.BookingDTO;


public interface SolrBookingRepository extends SolrCrudRepository<BookingDTO, Integer>{
	
	BookingDTO findByPassengerName(String passengerName);
}
