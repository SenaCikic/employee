package com.employee.employee.dao.repository;

import com.employee.employee.dao.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("select e from EmployeeEntity  e  where e.email =:email")
    List<EmployeeEntity> findEmployeesByEmail(@Param("email") String email);

    EmployeeEntity getUserByEmail(@Param("email") String email);

    @Query("select e from EmployeeEntity e where e.email =:email and e.password =:password")
    EmployeeEntity checkPassword(@Param("email") String email, @Param("password") String password);
}
