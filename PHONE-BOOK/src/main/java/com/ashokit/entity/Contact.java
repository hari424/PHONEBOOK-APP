package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CONTACT_TAB")
@NoArgsConstructor
@AllArgsConstructor
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
