package com.prmo.mock.controller.dto.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Начало/завершение осмотра водителем")
@Getter
@Setter
public class DriverRequestDto {

    @Schema(description = "ID водителя", example = "1")
    @NotNull(message = "Поле ID водителя не может быть пустым")
    private Long driverId;

}
