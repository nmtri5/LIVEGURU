package com.liveguru.purchase;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShippingInformationJson {

	public static ShippingInformationJson get(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(filename), ShippingInformationJson.class);
	}

	@JsonProperty("firstname")
	String firstName;
	
	@JsonProperty("middlename")
	String middleName;
	
	@JsonProperty("lastname")
	String lastName;
	
	@JsonProperty("company")
	String company;
	
	@JsonProperty("address")
	String address;
	
	@JsonProperty("streetaddress")
	String streetAddress;
	
	@JsonProperty("city")
	String city;
	
	@JsonProperty("zip")
	String zip;
	
	@JsonProperty("telephone")
	String telephone;
	
	@JsonProperty("fax")
	String fax;
	
	@JsonProperty("state")
	String state;
	
	@JsonProperty("country")
	String country;
	
	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getFax() {
		return fax;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}
	
}
