package com.employee.employee.core.impl;

import com.employee.employee.api.model.DailyTracker;
import com.employee.employee.api.model.MonthlyTracker;
import com.employee.employee.api.model.TimeTrackerResponse;
import com.employee.employee.api.service.TimeTrackerService;
import com.employee.employee.dao.entity.TimeTrackerEntity;
import com.employee.employee.dao.repository.TimeTrackerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TimeTrackerServiceImpl implements TimeTrackerService {

    TimeTrackerRepository timeTrackerRepository;


    @Override
    public void addNewTimeTracker(DailyTracker dailyTracker) {

        TimeTrackerEntity newTimeTrackerEntity = new TimeTrackerEntity();

        newTimeTrackerEntity.setActionPurposeCode(dailyTracker.getActionPurposeCode());
        newTimeTrackerEntity.setActionStartTime(LocalDateTime.now());
        newTimeTrackerEntity.setDay(dailyTracker.getActionStartTime().getDayOfMonth());
        newTimeTrackerEntity.setMonth(dailyTracker.getActionStartTime().getMonth().toString());
        newTimeTrackerEntity.setId(dailyTracker.getEmployeeId());

        timeTrackerRepository.save(newTimeTrackerEntity);
    }

    @Override
    public List<TimeTrackerResponse> getDailyTracker(Long id, int day) {
      List<TimeTrackerEntity> entities =  timeTrackerRepository.findTrackingForEmployee(id, day);
      List<TimeTrackerResponse> timeTrackerResponse = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            timeTrackerResponse.get(i).setActionPurposeCode(entities.get(i).getActionPurposeCode());
            timeTrackerResponse.get(i).setEmployeeId(entities.get(i).getEmployee().getId());
            timeTrackerResponse.get(i).setActionStartTime(entities.get(i).getActionStartTime());
            timeTrackerResponse.get(i).setDay(entities.get(i).getDay());
            timeTrackerResponse.get(i).setMonth(entities.get(i).getMonth());
            timeTrackerResponse.get(i).setEmployeeId(entities.get(i).getEmployee().getId());
        }
      return timeTrackerResponse;
    }

    @Override
    public MonthlyTracker getMonthlyTracker(Long id, String month) {

//        List<TimeTrackerEntity> entities = timeTrackerRepository.findMonthlyTrackingForEmployee(id, month);
//        List<MonthlyTracker> monthlyTracker = new ArrayList<MonthlyTracker>();
//        for(int i=0; 0<entities.size(); i++){
//            entities.get(i).getActionStartTime().get
//        }
        return null;

    }

    Duration findTimeDifference(LocalDateTime start, LocalDateTime end){
       return Duration.between(end, start);
    }



}
