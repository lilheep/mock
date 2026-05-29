package com.prmo.mock.controller.dto.duration;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Длительность осмотра")
@Getter
@Setter
public class MedicalCheckDurationResponseDto {

    @Schema(description = "Длительность прохождения осмотра пациентом (в мс)", example = "1000")
    private Long patientDurationMs;

    @Schema(description = "Время ожидания врача после прохождения осмотра пациентом (в мс)", example = "1000")
    private Long doctorWaitingMs;

    @Schema(description = "Длительность работы врача (в мс)", example = "1000")
    private Long doctorDurationMs;

    @Schema(description = "Общее время прохождения осмотра (в мс)", example = "1000")
    private Long total;


}
