package com.prmo.mock.domain.impl.validation;

import com.prmo.mock.domain.validation.MedicalCheckValidationService;
import com.prmo.mock.domain.exception.state.InvalidStateException;
import com.prmo.mock.infrastructure.entity.MedicalCheck;
import org.springframework.stereotype.Service;

@Service
public class MedicalCheckValidationServiceImpl implements MedicalCheckValidationService {

    @Override
    public void validationEndExaminationDriver(MedicalCheck medicalCheck) {
        if (medicalCheck.getDriverEndTime() != null) {
            throw new InvalidStateException("Данный осмотр уже закончен");
        }

        if (medicalCheck.getDriverStartTime() == null) {
            throw new InvalidStateException("Данный осмотр еще не начат");
        }
    }

    @Override
    public void validationStartExaminationDoctor(MedicalCheck medicalCheck) {
        if (medicalCheck.getDriverEndTime() != null) {
            throw new InvalidStateException("Данный осмотр уже закончен");
        }

        if (medicalCheck.getDriverStartTime() == null) {
            throw new InvalidStateException("Данный осмотр еще не начат");
        }
    }

    @Override
    public void validationEndExaminationDoctor(MedicalCheck medicalCheck) {
        if (medicalCheck.getDoctorStartTime() == null) {
            throw new IllegalStateException("Данный осмотр еще не начат");
        }

        if (medicalCheck.getDoctorEndTime() != null) {
            throw new InvalidStateException("Данный осмотр уже завершен");
        }

        if (medicalCheck.getData() != null) {
            throw new InvalidStateException("Данный осмотр уже завершен");
        }
    }

}
