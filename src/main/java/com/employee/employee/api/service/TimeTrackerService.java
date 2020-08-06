package com.employee.employee.api.service;

import com.employee.employee.api.model.DailyTracker;
import com.employee.employee.api.model.MonthlyTracker;
import com.employee.employee.api.model.TimeTrackerResponse;

import java.util.List;

public interface TimeTrackerService {

    public void addNewTimeTracker(DailyTracker dailyTracker);

    public List<TimeTrackerResponse> getDailyTracker(Long id, int day);

    public MonthlyTracker getMonthlyTracker(Long id, String month);

}
