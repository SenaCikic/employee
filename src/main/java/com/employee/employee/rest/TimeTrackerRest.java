package com.employee.employee.rest;

import com.employee.employee.api.model.DailyTracker;
import com.employee.employee.api.model.MonthlyTracker;
import com.employee.employee.api.model.TimeTrackerResponse;
import com.employee.employee.api.service.TimeTrackerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http:/localhost:4200", allowedHeaders = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping(value="/time-tracker")
@Api(tags="timeTracker")
public class TimeTrackerRest {

    TimeTrackerService timeTrackerService;


    @ApiOperation(value = "Add new Time Tracker")
    @PostMapping("{id}/add-new")
    public void addNewTimeTracker(@PathVariable Long id, @RequestBody DailyTracker dailyTracker){
        timeTrackerService.addNewTimeTracker(dailyTracker);
    }

    @ApiOperation(value = "Get daily review")
    @GetMapping("{id}/{day}/day")
    public List<TimeTrackerResponse> getDailyTracker(@PathVariable  Long id, @PathVariable int day){
        return timeTrackerService.getDailyTracker(id, day);
    }

    @ApiOperation(value = "Get monthly review")
    @GetMapping("{id}/{month}/month")
    public MonthlyTracker getMonthlyTracker(@PathVariable Long id, @PathVariable String month){
        return timeTrackerService.getMonthlyTracker(id, month);
    }

}
