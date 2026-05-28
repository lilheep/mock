package com.prmo.mock.controller.dto.patient;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Начало/завершение осмотра пациентом")
@Getter
@Setter
public class PatientRequestDto {

    @Schema(description = "ID пациента", example = "1")
    @NotNull(message = "Поле ID пациента не может быть пустым")
    private Long patientId;

}
