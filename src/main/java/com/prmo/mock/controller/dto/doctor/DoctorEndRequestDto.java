package com.prmo.mock.controller.dto.doctor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Конец осмотра доктором")
@Data
public class DoctorEndRequestDto {

    @Schema(description = "ID доктора", example = "1")
    @NotNull(message = "Поле ID доктора не может быть пустым")
    private Long doctorId;

}
