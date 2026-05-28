package com.prmo.mock.controller.dto.patient;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Создание осмотра")
@Getter
@Setter
public class PatientStartResponseDto {

    @Schema(description = "ID осмотра", example = "1")
    @NotNull(message = "Поле ID осмотра не может быть пустым")
    private Long checkId;

}
