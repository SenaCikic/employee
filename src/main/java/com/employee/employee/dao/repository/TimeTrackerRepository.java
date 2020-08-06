package com.employee.employee.dao.repository;

import com.employee.employee.dao.entity.TimeTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTrackerRepository extends JpaRepository<TimeTrackerEntity, Long> {
    @Query("select t from TimeTrackerEntity t where t.employee.id =:id and t.day =:day")
    List<TimeTrackerEntity> findTrackingForEmployee(@Param("id") Long id, @Param("day") int day);

    @Query("select t from TimeTrackerEntity t where t.employee.id =:id and t.month =:month")
    List<TimeTrackerEntity> findMonthlyTrackingForEmployee(@Param("id") Long id, @Param("month") String month);
}
