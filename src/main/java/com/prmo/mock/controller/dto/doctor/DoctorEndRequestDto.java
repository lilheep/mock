package com.prmo.mock.controller.dto.doctor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Завершение осмотра доктором")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorEndRequestDto {

    @Schema(description = "ID доктора", example = "1")
    @NotNull(message = "Поле ID доктора не может быть пустым")
    private Long doctorId;

    @Schema(description = "Пульс", example = "60")
    @NotNull(message = "Поле пульс не может быть пустым")
    private Integer pulse;

    @Schema(description = "Систолическое давление", example = "120")
    @NotNull(message = "Поле систалическое давление не может быть пустым")
    private Integer systolicPressure;

    @Schema(description = "Диастолическое давление", example = "80")
    @NotNull(message = "Поле диастолическое давление не может быть пустым")
    private Integer diastolicPressure;

    @Schema(description = "Температура тела", example = "36.6")
    @NotNull(message = "Поле температура тела не может быть пустым")
    private Double temperature;

    @Schema(description = "Результат алкогольного теста", example = "0.00")
    @NotNull(message = "Поле результат алкогольного теста не может быть пустым")
    private Double alcoholTestResult;

    @Schema(description = "Жалобы")
    private String complaints;

    @Schema(description = "Допуск к вождению", example = "true")
    @NotNull(message = "Поле допуск к вождению не может быть пустым")
    private Boolean admittedToDrive;

    @Schema(description = "Дополнительные комментарии")
    private String comment;

}
