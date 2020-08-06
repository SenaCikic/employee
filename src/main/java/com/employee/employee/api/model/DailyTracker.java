package com.employee.employee.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyTracker implements Serializable {

    private String actionPurposeCode;

    private LocalDateTime actionStartTime;

    private Long employeeId;
}
