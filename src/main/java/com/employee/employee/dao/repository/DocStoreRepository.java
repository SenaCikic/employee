package com.employee.employee.dao.repository;

import com.employee.employee.dao.entity.DocStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocStoreRepository  extends JpaRepository<DocStoreEntity, Long> {
}
