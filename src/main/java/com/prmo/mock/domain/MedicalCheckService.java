package com.prmo.mock.domain;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.controller.dto.doctor.DoctorStartRequestDto;
import com.prmo.mock.controller.dto.driver.DriverEndRequestDto;
import com.prmo.mock.controller.dto.driver.DriverStartRequestDto;
import com.prmo.mock.controller.dto.driver.DriverStartResponseDto;
import com.prmo.mock.infrastructure.entity.MedicalCheck;

public interface MedicalCheckService {

    MedicalCheck getById(Long id);

    void save(MedicalCheck medicalCheck);

    DriverStartResponseDto startExaminationDriver(DriverStartRequestDto dto);

    void endExaminationDriver(Long checkId, DriverEndRequestDto dto);

    void startExaminationDoctor(Long checkId, DoctorStartRequestDto dto);

    void endExaminationDoctor(Long checkId, DoctorEndRequestDto dto);

}
