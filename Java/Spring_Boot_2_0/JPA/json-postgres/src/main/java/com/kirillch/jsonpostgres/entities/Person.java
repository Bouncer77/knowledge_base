package com.kirillch.jsonpostgres.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="jpa", name = "person")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private Long pk;

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String country;
    private String ipAddress;

    public Person() {
    }
}
