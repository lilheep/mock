package com.prmo.mock.domain;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.controller.dto.doctor.DoctorEndResponseDto;
import com.prmo.mock.controller.dto.doctor.DoctorStartRequestDto;
import com.prmo.mock.controller.dto.driver.DriverRequestDto;
import com.prmo.mock.controller.dto.driver.DriverStartResponseDto;
import com.prmo.mock.infrastructure.entity.MedicalCheck;

public interface MedicalCheckService {

    MedicalCheck getById(Long id);

    void save(MedicalCheck medicalCheck);

    DriverStartResponseDto startExaminationDriver(DriverRequestDto dto);

    void endExaminationDriver(Long checkId, DriverRequestDto dto);

    void startExaminationDoctor(Long checkId, DoctorStartRequestDto dto);

    DoctorEndResponseDto endExaminationDoctor(Long checkId, DoctorEndRequestDto dto);

}
