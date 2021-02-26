package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_TAB")
public class Contact {
	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactid;
	@Column(name = "CONTACT_NAME")
	private String contactname;
	@Column(name = "CONTACT_EMAIL")
	private String contactemail;
	@Column(name = "CONTACT_NUMBER")
	private Long contactnumber;

}
