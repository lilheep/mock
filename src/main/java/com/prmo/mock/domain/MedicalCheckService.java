package com.prmo.mock.domain;

import com.prmo.mock.controller.dto.doctor.DoctorRequestDto;
import com.prmo.mock.controller.dto.driver.DriverRequestDto;
import com.prmo.mock.controller.dto.driver.DriverStartResponseDto;
import com.prmo.mock.infrastructure.entity.MedicalCheck;

public interface MedicalCheckService {

    MedicalCheck getById(Long id);

    void save(MedicalCheck medicalCheck);

    DriverStartResponseDto startExaminationDriver(DriverRequestDto dto);

    void endExaminationDriver(Long checkId, DriverRequestDto dto);

    void startExaminationDoctor(Long checkId, DoctorRequestDto dto);

    void endExaminationDoctor(Long checkId, DoctorRequestDto dto);

}
