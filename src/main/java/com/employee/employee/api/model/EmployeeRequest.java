package com.employee.employee.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest implements Serializable {

    private Long id;

    private String phone;

    private String firstName;

    private String lastName;

    private String password;

}
