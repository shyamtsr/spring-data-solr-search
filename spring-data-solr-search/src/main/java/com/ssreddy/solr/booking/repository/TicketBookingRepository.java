package com.ssreddy.solr.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssreddy.solr.booking.model.Ticket;


public interface TicketBookingRepository extends CrudRepository<Ticket, Integer>{

}
