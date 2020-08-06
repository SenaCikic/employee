package com.employee.employee.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyTracker implements Serializable {

    private LocalDateTime totalWorkingHours;
    private LocalDateTime totalPauseTime;
    private int day;

}
