package com.prmo.mock.domain;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.controller.dto.doctor.DoctorEndResponseDto;
import com.prmo.mock.controller.dto.doctor.DoctorStartRequestDto;
import com.prmo.mock.controller.dto.patient.PatientRequestDto;
import com.prmo.mock.controller.dto.patient.PatientStartResponseDto;
import com.prmo.mock.infrastructure.entity.MedicalCheck;

public interface MedicalCheckService {

    MedicalCheck getById(Long id);

    void save(MedicalCheck medicalCheck);

    PatientStartResponseDto startExaminationPatient(PatientRequestDto dto);

    void endExaminationPatient(Long checkId, PatientRequestDto dto);

    void startExaminationDoctor(Long checkId, DoctorStartRequestDto dto);

    DoctorEndResponseDto endExaminationDoctor(Long checkId, DoctorEndRequestDto dto);

}
