package com.prmo.mock.controller.dto.doctor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Schema(description = "Начало/завершение осмотра доктором")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorRequestDto {

    @Schema(description = "ID доктора", example = "1")
    @NotNull(message = "Поле ID доктора не может быть пустым")
    private Long doctorId;

}
