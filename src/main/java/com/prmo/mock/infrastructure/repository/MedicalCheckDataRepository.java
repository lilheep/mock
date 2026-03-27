package com.prmo.mock.infrastructure.repository;

import com.prmo.mock.infrastructure.entity.MedicalCheckData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCheckDataRepository extends JpaRepository<MedicalCheckData, Long> { }
