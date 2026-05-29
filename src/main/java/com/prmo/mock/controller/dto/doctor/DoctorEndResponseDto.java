package com.prmo.mock.controller.dto.doctor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Результат осмотра")
@Getter
@Setter
public class DoctorEndResponseDto {

    @Schema(description = "ID осмотра", example = "1")
    private Long checkId;

    @Schema(description = "ID пациента", example = "1")
    private Long patientId;

    @Schema(description = "Результат", example = "true")
    private Boolean result;

}
