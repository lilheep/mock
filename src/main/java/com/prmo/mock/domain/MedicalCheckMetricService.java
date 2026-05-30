package com.prmo.mock.domain;

import com.prmo.mock.infrastructure.entity.MedicalCheck;

public interface MedicalCheckMetricService {

    void recordMedicalCheck(MedicalCheck medicalCheck);

}
