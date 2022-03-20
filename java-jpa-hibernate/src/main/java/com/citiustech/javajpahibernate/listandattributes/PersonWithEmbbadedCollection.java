package com.citiustech.javajpahibernate.listandattributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "personwithembeddedcollection")
public class PersonWithEmbbadedCollection {

	    @Id
	    @GeneratedValue
	    private int id;
	    private String name;
	    
	    @ElementCollection
	    @CollectionTable(name = "PERSON_TICKET",
	            joinColumns = {
	            @JoinColumn(name = "PERSON_ID", referencedColumnName = "Id")
	            }
	    )
	    private List<TicketEmbaddedList> ticketList = new ArrayList<>();
	    @ElementCollection
	    @MapKeyColumn(name = "ATTR_NAME")
	    @Column(name = "ATTR_VALUE")
	    @CollectionTable(name = "PERSON_ATTRIBUTE",
	            joinColumns = {
	                    @JoinColumn(name = "PERSON_ID", referencedColumnName = "Id")
	            }
	    )
	    private Map<String, String> attributes = new HashMap<>();
	    public void addAttribute(String key, String value) {
	        attributes.put(key, value);
	    }

	    public void addTicket(TicketEmbaddedList ticket) {
	        ticketList.add(ticket);
	    }

	    public Map<String, String> getAttributes() {
	        return attributes;
	    }

	    public void setAttributes(Map<String, String> attributes) {
	        this.attributes = attributes;
	    }

	    public List<TicketEmbaddedList> getTicketList() {
	        return ticketList;
	    }

	    public void setTicketList(List<TicketEmbaddedList> ticketList) {
	        this.ticketList = ticketList;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
}
