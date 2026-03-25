package com.prmo.mock.controller.dto.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Конец осмотра водителем")
@Data
public class DriverEndRequestDto {

    @Schema(description = "ID водителя", example = "1")
    @NotNull(message = "Поле ID водителя не может быть пустым")
    private Long driverId;

}
