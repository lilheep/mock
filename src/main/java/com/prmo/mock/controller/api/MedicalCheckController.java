package com.prmo.mock.controller.api;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.controller.dto.doctor.DoctorEndResponseDto;
import com.prmo.mock.controller.dto.doctor.DoctorStartRequestDto;
import com.prmo.mock.controller.dto.driver.DriverRequestDto;
import com.prmo.mock.controller.dto.driver.DriverStartResponseDto;
import com.prmo.mock.domain.MedicalCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medical-check")
@RequiredArgsConstructor
@Tag(name = "Medical Check Controller", description = "Medical Check API")
public class MedicalCheckController {

    private final MedicalCheckService medicalCheckService;

    @PostMapping("/driver/start")
    @Operation(summary = "The beginning of the pre-trip examination by the driver")
    public ResponseEntity<DriverStartResponseDto> startExaminationForDriver(@RequestBody @Valid DriverRequestDto dto) {
        return ResponseEntity.ok(medicalCheckService.startExaminationDriver(dto));
    }

    @PostMapping("/driver/{checkId}/end")
    @Operation(summary = "Completion of the examination by the driver")
    public ResponseEntity<?> endExaminationForDriver(@PathVariable Long checkId,
                                                     @RequestBody @Valid DriverRequestDto dto) {
        medicalCheckService.endExaminationDriver(checkId, dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/doctor/{checkId}/start")
    @Operation(summary = "The beginning of the pre-trip examination by the doctor")
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
