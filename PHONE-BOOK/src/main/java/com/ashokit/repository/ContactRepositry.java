package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Contact;

public interface ContactRepositry extends JpaRepository<Contact, Serializable>{

}
