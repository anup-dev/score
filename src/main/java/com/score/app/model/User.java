package com.score.app.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * Created by Anup on 27/5/19.
 */

@Getter
@Setter
public class User {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dob;
    private String gender;



}
