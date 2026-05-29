package com.prmo.mock.domain.impl;

import com.prmo.mock.controller.dto.duration.MedicalCheckDurationResponseDto;
import com.prmo.mock.controller.dto.timeline.MedicalCheckTimelineEventResponseDto;
import com.prmo.mock.controller.dto.timeline.MedicalCheckTimelineResponseDto;
import com.prmo.mock.domain.MedicalCheckService;
import com.prmo.mock.domain.MedicalCheckTimelineService;
import com.prmo.mock.domain.util.MedicalCheckDurationUtil;
import com.prmo.mock.infrastructure.entity.MedicalCheck;
import com.prmo.mock.infrastructure.entity.MedicalCheckStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MedicalCheckTimelineServiceImpl implements MedicalCheckTimelineService {

    private final MedicalCheckService medicalCheckService;
    private final MedicalCheckDurationUtil medicalCheckDurationUtil;

    @Override
    public MedicalCheckTimelineResponseDto getTimeLine(Long checkId) {

        MedicalCheck medicalCheck = medicalCheckService.getById(checkId);
        List<MedicalCheckTimelineEventResponseDto> events = addEvents(medicalCheck);

        MedicalCheckTimelineResponseDto response = new MedicalCheckTimelineResponseDto();
        response.setCheckId(medicalCheck.getId());
        response.setEvents(events);

        return response;

    }

    @Override
    public MedicalCheckDurationResponseDto getDuration(Long checkId) {

        MedicalCheck medicalCheck = medicalCheckService.getById(checkId);

        return new MedicalCheckDurationResponseDto(
                medicalCheckDurationUtil.calculatePatientDuration(medicalCheck),
                medicalCheckDurationUtil.calculateDoctorWaitingDuration(medicalCheck),
                medicalCheckDurationUtil.calculateDoctorDuration(medicalCheck),
                medicalCheckDurationUtil.calculateTotalDuration(medicalCheck)
        );
    }

    private List<MedicalCheckTimelineEventResponseDto> addEvents(
            MedicalCheck medicalCheck
    ) {

        List<MedicalCheckTimelineEventResponseDto> events = new ArrayList<>();

        if (medicalCheck.getPatientStartTime() != null) {
            events.add(new MedicalCheckTimelineEventResponseDto(
                    MedicalCheckStatus.PATIENT_IN_PROGRESS, medicalCheck.getPatientStartTime()));
        }

        if (medicalCheck.getPatientEndTime() != null) {
            events.add(new MedicalCheckTimelineEventResponseDto(
                    MedicalCheckStatus.WAITING_DOCTOR, medicalCheck.getPatientEndTime()
            ));
        }

        if (medicalCheck.getDoctorStartTime() != null) {
            events.add(new MedicalCheckTimelineEventResponseDto(
                    MedicalCheckStatus.DOCTOR_IN_PROGRESS, medicalCheck.getDoctorStartTime()
            ));
        }

        if (medicalCheck.getDoctorEndTime() != null) {
            events.add(new MedicalCheckTimelineEventResponseDto(
                    MedicalCheckStatus.COMPLETED, medicalCheck.getDoctorEndTime()
            ));
        }

        return events;

    }
}
