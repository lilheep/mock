package com.prmo.mock.controller.dto.timeline;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Временная шкала обследования")
@Getter
@Setter
public class MedicalCheckTimelineResponseDto {

    @Schema(description = "ID осмотра", example = "1")
    private Long checkId;

    @Schema(description = "Список событий")
    private List<MedicalCheckTimelineEventResponseDto> events;

}
