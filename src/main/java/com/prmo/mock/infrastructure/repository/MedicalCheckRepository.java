package com.prmo.mock.infrastructure.repository;

import com.prmo.mock.infrastructure.entity.MedicalCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCheckRepository extends JpaRepository<MedicalCheck, Long> {

}
