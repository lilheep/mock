package com.prmo.mock.domain.metrics;

import com.prmo.mock.infrastructure.entity.MedicalCheck;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class MedicalCheckDurationUtil {

    public Long calculatePatientDuration(MedicalCheck medicalCheck) {

        if (medicalCheck.getPatientStartTime() == null || medicalCheck.getPatientEndTime() == null) {
            return null;
        }

        return Duration.between(
                medicalCheck.getPatientStartTime(),
                medicalCheck.getPatientEndTime()
        ).toMillis();
    }

    public Long calculateDoctorWaitingDuration(MedicalCheck medicalCheck) {
        if (medicalCheck.getPatientEndTime() == null || medicalCheck.getDoctorStartTime() == null) {
            return null;
        }

        return Duration.between(
                medicalCheck.getPatientEndTime(),
                medicalCheck.getDoctorStartTime()
        ).toMillis();
    }

    public Long calculateDoctorDuration(MedicalCheck medicalCheck) {
        if (medicalCheck.getDoctorStartTime() == null || medicalCheck.getDoctorEndTime() == null) {
            return null;
        }

        return Duration.between(
                medicalCheck.getDoctorStartTime(),
                medicalCheck.getDoctorEndTime()
        ).toMillis();
    }

    public Long calculateTotalDuration(MedicalCheck medicalCheck) {
        if (medicalCheck.getPatientStartTime() == null || medicalCheck.getDoctorEndTime() == null) {
            return null;
        }

        return Duration.between(
                medicalCheck.getPatientStartTime(),
                medicalCheck.getDoctorEndTime()
        ).toMillis();
    }

}
