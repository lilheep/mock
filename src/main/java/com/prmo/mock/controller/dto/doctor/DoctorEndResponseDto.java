package com.prmo.mock.controller.dto.doctor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Результат осмотра")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorEndResponseDto {

    @Schema(description = "ID осмотра", example = "1")
    private Long checkId;

    @Schema(description = "ID водителя", example = "1")
    private Long driverId;

    @Schema(description = "Допуск к вождению", example = "true")
    private Boolean admittedToDrive;

}
