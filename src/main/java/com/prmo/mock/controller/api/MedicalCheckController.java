package com.prmo.mock.controller.api;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.controller.dto.doctor.DoctorEndResponseDto;
import com.prmo.mock.controller.dto.doctor.DoctorStartRequestDto;
import com.prmo.mock.controller.dto.patient.PatientRequestDto;
import com.prmo.mock.controller.dto.patient.PatientStartResponseDto;
import com.prmo.mock.domain.MedicalCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/medical-check")
@RestController
@Tag(name = "Medical Check Controller",
     description = "Medical Check API")
public class MedicalCheckController {

    private final MedicalCheckService medicalCheckService;

    @PostMapping("/patient/start")
    @Operation(summary = "The beginning of the examination by the patient")
    public ResponseEntity<PatientStartResponseDto> startExaminationForDriver(@RequestBody @Valid PatientRequestDto dto) {
        return ResponseEntity.ok(medicalCheckService.startExaminationPatient(dto));
    }

    @PostMapping("/patient/{checkId}/end")
    @Operation(summary = "Completion of the examination by the patient")
    public ResponseEntity<?> endExaminationForDriver(@PathVariable Long checkId,
                                                     @RequestBody @Valid PatientRequestDto dto) {
        medicalCheckService.endExaminationPatient(checkId, dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/doctor/{checkId}/start")
    @Operation(summary = "The beginning of the examination by the doctor")
    public ResponseEntity<?> startExaminationForDoctor(@PathVariable Long checkId,
                                                       @RequestBody @Valid DoctorStartRequestDto dto) {
        medicalCheckService.startExaminationDoctor(checkId, dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("doctor/{checkId}/end")
    @Operation(summary = "Completion of the examination by the doctor")
    public ResponseEntity<DoctorEndResponseDto> endExaminationForDoctor(@PathVariable Long checkId,
                                                                        @RequestBody @Valid DoctorEndRequestDto dto) {
        return ResponseEntity.ok(medicalCheckService.endExaminationDoctor(checkId, dto));
    }

}
