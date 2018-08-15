package com.ssreddy.solr.booking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssreddy.solr.booking.model.BookingDTO;
import com.ssreddy.solr.booking.model.Ticket;
import com.ssreddy.solr.booking.repository.SolrBookingRepository;
import com.ssreddy.solr.booking.repository.TicketBookingRepository;

/**
 * Author : Shyamsundar T <br>
 * Created on : 06th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Controller class to handle create and update booking requests.
 * <br>
 * JIRA: CM-16053 <br>
 */
@RestController
@RequestMapping(value = "/booking")
public class BookingController {

	@Autowired
	private SolrBookingRepository solrBookingRepository;

	@Autowired
	private TicketBookingRepository bookingRepository;

	@PostConstruct
	private void InsertMySqlData() {
		/*
		 * List<BookingDTO> mySqlData = new ArrayList<>(); mySqlData.add(new
		 * BookingDTO(201, "Shyamsundar", "15-Aug-2018", "Tirupathi", "Bangalore",
		 * "shyam.tr@gmail.com")); mySqlData.add(new BookingDTO(201, "Surendra",
		 * "20-Aug-2018", "Chittor", "Tirupathi", "suri.t@gmail.com"));
		 * mySqlData.add(new BookingDTO(201, "MohanReddy", "10-Aug-2018", "Tirupathi",
		 * "Puttur", "mohan.p@gmail.com"));
		 */
		
		List<BookingDTO> mySqlData = new ArrayList<>();
		
		List<Ticket> bookingDetails = (List<Ticket>) bookingRepository.findAll();
		
		bookingDetails.stream().forEach(booking -> {
			BookingDTO dto= new BookingDTO();
			dto.setTicketId(booking.getTicketId());
			dto.setPassengerName(booking.getPassengerName());
			dto.setEmail(booking.getEmail());
			dto.setSourceStation(booking.getSourceStation());
			dto.setDestinationStation(booking.getDestinationStation());
			dto.setBookingDate(booking.getBookingDate());
			
			mySqlData.add(dto);
		});

		solrBookingRepository.saveAll(mySqlData);
	}

	@GetMapping(value = "/ticket/allbookings")
	public Iterable<BookingDTO> getBookingDetails() {
		Iterable<BookingDTO> allBookings = solrBookingRepository.findAll();
		return allBookings;
	}
	
	/*@GetMapping(value = "/ticket/allbookings")
	public Iterable<Ticket> getBookingDetails() {
		Iterable<Ticket> allBookings = bookingRepository.findAll();
		return allBookings;
	}*/

	@GetMapping(value = "/ticket/{name}")
	public BookingDTO getBookingDetailsById(@PathVariable("name") String name) {

		return solrBookingRepository.findByPassengerName(name);
	}

}
