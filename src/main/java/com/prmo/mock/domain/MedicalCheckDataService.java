package com.prmo.mock.domain;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.infrastructure.entity.MedicalCheck;
import com.prmo.mock.infrastructure.entity.MedicalCheckData;

public interface MedicalCheckDataService {

    MedicalCheckData create(MedicalCheck medicalCheck, DoctorEndRequestDto dto);

    void save(MedicalCheckData medicalCheckData);
}
