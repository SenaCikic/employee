package com.employee.employee.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="time_tracker")
public class TimeTrackerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "action_purpose_code")
    private String actionPurposeCode;

    @Column(name = "action_start_time")
    private LocalDateTime actionStartTime;

    @Column(name = "day")
    private int day;

    @Column(name="month")
    private String month;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeEntity employee;

}
