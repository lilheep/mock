package com.prmo.mock.domain.validation;

import com.prmo.mock.infrastructure.entity.MedicalCheck;

public interface MedicalCheckValidationService {

    void validationEndExaminationDriver(MedicalCheck medicalCheck);

    void validationStartExaminationDoctor(MedicalCheck medicalCheck);

    void validationEndExaminationDoctor(MedicalCheck medicalCheck);

}
