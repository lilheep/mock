package com.prmo.mock.domain;

import com.prmo.mock.controller.dto.duration.MedicalCheckDurationResponseDto;
import com.prmo.mock.controller.dto.timeline.MedicalCheckTimelineResponseDto;

public interface MedicalCheckTimelineService {

    MedicalCheckTimelineResponseDto getTimeLine(Long checkId);

    MedicalCheckDurationResponseDto getDuration(Long checkId);
}
