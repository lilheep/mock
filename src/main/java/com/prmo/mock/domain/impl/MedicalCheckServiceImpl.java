package com.prmo.mock.domain.impl;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.controller.dto.doctor.DoctorEndResponseDto;
import com.prmo.mock.controller.dto.doctor.DoctorStartRequestDto;
import com.prmo.mock.controller.dto.driver.DriverRequestDto;
import com.prmo.mock.controller.dto.driver.DriverStartResponseDto;
import com.prmo.mock.domain.MedicalCheckDataService;
import com.prmo.mock.domain.MedicalCheckService;
import com.prmo.mock.domain.exception.resource.MedicalCheckNotFoundException;
import com.prmo.mock.domain.exception.state.InvalidStateException;
import com.prmo.mock.domain.exception.state.DoctorAlreadyAssignedException;
import com.prmo.mock.domain.exception.state.DoctorAlreadyStartedException;
import com.prmo.mock.domain.exception.forbidden.InvalidOwnershipException;
import com.prmo.mock.domain.mappers.MedicalCheckMapper;
import com.prmo.mock.infrastructure.entity.MedicalCheck;
import com.prmo.mock.infrastructure.entity.MedicalCheckData;
import com.prmo.mock.infrastructure.entity.MedicalCheckStatus;
import com.prmo.mock.infrastructure.repository.MedicalCheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MedicalCheckServiceImpl implements MedicalCheckService {

    private final MedicalCheckRepository repository;
    private final MedicalCheckDataService medicalCheckDataService;
    private final MedicalCheckMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public MedicalCheck getById(Long id) {
        return repository.findById(id).orElseThrow(MedicalCheckNotFoundException::new);
    }

    @Override
    @Transactional
    public void save(MedicalCheck medicalCheck) {
        repository.save(medicalCheck);
    }

    @Override
    @Transactional
    public DriverStartResponseDto startExaminationDriver(DriverRequestDto dto) {
        MedicalCheck medicalCheck = new MedicalCheck();
        medicalCheck.setDriverId(dto.getDriverId());
        medicalCheck.setDriverStartTime(LocalDateTime.now());
        medicalCheck.setStatus(MedicalCheckStatus.PENDING);
        save(medicalCheck);

        DriverStartResponseDto response = new DriverStartResponseDto();
        response.setCheckId(medicalCheck.getId());
        return response;
    }

    @Override
    @Transactional
    public void endExaminationDriver(Long checkId, DriverRequestDto dto) {
        MedicalCheck medicalCheck = getById(checkId);

        if (!dto.getDriverId().equals(medicalCheck.getDriverId())) {
            throw new InvalidOwnershipException();
        }

        if (medicalCheck.getDriverEndTime() != null) {
            throw new InvalidStateException("Данный осмотр уже закончен");
        }

        if (medicalCheck.getDriverStartTime() == null) {
            throw new InvalidStateException("Данный осмотр еще не начат");
        }

        medicalCheck.setDriverEndTime(LocalDateTime.now());
        save(medicalCheck);
    }

    @Override
    @Transactional
    public void startExaminationDoctor(Long checkId, DoctorStartRequestDto dto) {
        MedicalCheck medicalCheck = getById(checkId);

        if (medicalCheck.getDoctorId() != null) {
            throw new DoctorAlreadyAssignedException();
        }

        if (medicalCheck.getDriverEndTime() == null) {
            throw new DoctorAlreadyStartedException();
        }

        medicalCheck.setDoctorId(dto.getDoctorId());
        medicalCheck.setDoctorStartTime(LocalDateTime.now());
        medicalCheck.setStatus(MedicalCheckStatus.IN_PROGRESS);

        save(medicalCheck);
    }

    @Override
    @Transactional
    public DoctorEndResponseDto endExaminationDoctor(Long checkId, DoctorEndRequestDto dto) {
        MedicalCheck medicalCheck = getById(checkId);

        if (!medicalCheck.getDoctorId().equals(dto.getDoctorId())) {
            throw new InvalidOwnershipException();
        }

        if (medicalCheck.getDoctorStartTime() == null) {
            throw new IllegalStateException("Данный осмотр еще не начат");
        }

        if (medicalCheck.getDoctorEndTime() != null) {
            throw new InvalidStateException("Данный осмотр уже завершен");
        }

        if (medicalCheck.getData() != null) {
            throw new InvalidStateException("Данный осмотр уже завершен");
        }

        medicalCheck.setDoctorEndTime(LocalDateTime.now());
        medicalCheck.setStatus(MedicalCheckStatus.COMPLETED);

        MedicalCheckData data = medicalCheckDataService.create(medicalCheck, dto);
        medicalCheck.setData(data);

        save(medicalCheck);

        DoctorEndResponseDto response = mapper.toDto(medicalCheck);
        response.setCheckId(checkId);
        return response;
    }
}
