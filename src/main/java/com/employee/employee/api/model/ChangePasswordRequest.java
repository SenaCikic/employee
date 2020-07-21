package com.employee.employee.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest implements Serializable {

    private String oldPassword;

    private String newPassword;

}
