package com.prmo.mock.domain.metrics;

import com.prmo.mock.domain.MedicalCheckMetricService;
import com.prmo.mock.infrastructure.entity.MedicalCheck;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class MedicalCheckMetricServiceImpl implements MedicalCheckMetricService {

    private final MedicalCheckDurationUtil medicalCheckDurationUtil;
    private final Timer patientDurationTimer;
    private final Timer doctorWaitingDurationTimer;
    private final Timer doctorDurationTimer;
    private final Timer totalDurationTimer;

    public MedicalCheckMetricServiceImpl(
            MeterRegistry meterRegistry,
            MedicalCheckDurationUtil medicalCheckDurationUtil
    ) {

        this.medicalCheckDurationUtil = medicalCheckDurationUtil;

        this.patientDurationTimer = Timer.builder(
                "medical_check_patient_duration"
        )
                .description("Patient examination duration")
                .register(meterRegistry);

        this.doctorWaitingDurationTimer = Timer.builder(
                "medical_check_doctor_waiting_duration"
        )
                .description("Doctor waiting duration")
                .register(meterRegistry);

        this.doctorDurationTimer = Timer.builder(
                "medical_check_doctor_duration"
        )
                .description("Doctor examination duration")
                .register(meterRegistry);

        this.totalDurationTimer = Timer.builder(
                "medical_check_total_duration"
        )
                .description("Total examination duration")
                .register(meterRegistry);

    }


    @Override
    public void recordMedicalCheck(MedicalCheck medicalCheck) {
        patientDurationTimer.record(
                medicalCheckDurationUtil.calculatePatientDuration(medicalCheck),
                TimeUnit.MILLISECONDS
        );

        doctorWaitingDurationTimer.record(
                medicalCheckDurationUtil.calculateDoctorWaitingDuration(medicalCheck),
                TimeUnit.MILLISECONDS
        );

        doctorDurationTimer.record(
                medicalCheckDurationUtil.calculateDoctorDuration(medicalCheck),
                TimeUnit.MILLISECONDS
        );

        totalDurationTimer.record(
                medicalCheckDurationUtil.calculateTotalDuration(medicalCheck),
                TimeUnit.MILLISECONDS
        );
    }
}
