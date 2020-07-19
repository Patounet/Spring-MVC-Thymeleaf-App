package com.mvc.App.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private Tested test;

}
