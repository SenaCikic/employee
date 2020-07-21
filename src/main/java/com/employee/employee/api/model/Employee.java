package com.employee.employee.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private byte[] avatar;

    private String phone;

    private double hoursActive;

}
