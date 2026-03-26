package com.prmo.mock.controller.dto.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Schema(description = "Создание осмотра")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverStartResponseDto {

    @Schema(description = "ID осмотра", example = "1")
    @NotNull(message = "Поле ID осмотра не может быть пустым")
    private Long checkId;

}
