package com.prmo.mock.domain.mappers;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.infrastructure.entity.MedicalCheckData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalCheckDataMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "medicalCheck", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    MedicalCheckData toEntity(DoctorEndRequestDto dto);

}
