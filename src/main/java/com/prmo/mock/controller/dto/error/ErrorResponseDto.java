package com.prmo.mock.controller.dto.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Ошибка")
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseDto {

    @Schema(description = "HTTP статус", example = "500")
    private Integer status;

    @Schema(description = "Сообщение")
    private String message;

}
