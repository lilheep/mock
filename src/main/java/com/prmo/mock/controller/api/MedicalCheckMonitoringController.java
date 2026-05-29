package com.prmo.mock.controller.api;

import com.prmo.mock.controller.dto.duration.MedicalCheckDurationResponseDto;
import com.prmo.mock.controller.dto.timeline.MedicalCheckTimelineResponseDto;
import com.prmo.mock.domain.MedicalCheckTimelineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/medical-check")
@RestController
@Tag(name = "Medical Check Monitoring Controller",
     description = "Monitoring of the medical examination process")
public class MedicalCheckMonitoringController {

    private final MedicalCheckTimelineService medicalCheckTimelineService;

    @GetMapping("/{checkId}/timeline")
    @Operation(summary = "Get medical examination timeline")
    public ResponseEntity<MedicalCheckTimelineResponseDto> getTimeline(@PathVariable Long checkId) {

        MedicalCheckTimelineResponseDto response = medicalCheckTimelineService.getTimeLine(checkId);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{checkId}/duration")
    @Operation(summary = "Get medical examination duration")
    public ResponseEntity<MedicalCheckDurationResponseDto> getDuration(@PathVariable Long checkId) {

        MedicalCheckDurationResponseDto response = medicalCheckTimelineService.getDuration(checkId);
        return ResponseEntity.ok(response);

    }
}
