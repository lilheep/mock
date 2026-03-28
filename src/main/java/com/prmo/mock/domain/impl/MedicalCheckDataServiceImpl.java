package com.prmo.mock.domain.impl;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.domain.MedicalCheckDataService;
import com.prmo.mock.domain.mappers.MedicalCheckDataMapper;
import com.prmo.mock.infrastructure.entity.MedicalCheck;
import com.prmo.mock.infrastructure.entity.MedicalCheckData;
import com.prmo.mock.infrastructure.repository.MedicalCheckDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MedicalCheckDataServiceImpl implements MedicalCheckDataService {

    private final MedicalCheckDataRepository repository;
    private final MedicalCheckDataMapper mapper;

    @Override
    @Transactional
    public MedicalCheckData create(MedicalCheck medicalCheck, DoctorEndRequestDto dto) {
        MedicalCheckData medicalCheckData = mapper.toEntity(dto);
        medicalCheckData.setMedicalCheck(medicalCheck);
        save(medicalCheckData);
        return medicalCheckData;
    }

    @Override
    @Transactional
    public void save(MedicalCheckData medicalCheckData) {
        repository.save(medicalCheckData);
    }
}
