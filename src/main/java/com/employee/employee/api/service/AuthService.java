package com.employee.employee.api.service;

import com.employee.employee.api.model.LoginRequest;
import com.employee.employee.api.model.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest) throws Exception;
}
