package com.ssreddy.solr.booking.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "booking")
public class BookingDTO {

	@Id
	@Field
	private Integer ticketId;
	@Field
	private String passengerName;
	@Field
	private String bookingDate;
	@Field
	private String sourceStation;
	@Field
	private String destinationStation;
	@Field
	private String email;
	
	public BookingDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookingDTO(Integer ticketId, String passengerName, String bookingDate, String sourceStation,
			String destinationStation, String email) {
		super();
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.email = email;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
