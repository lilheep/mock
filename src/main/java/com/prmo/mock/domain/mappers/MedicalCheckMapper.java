package com.prmo.mock.domain.mappers;

import com.prmo.mock.controller.dto.doctor.DoctorEndResponseDto;
import com.prmo.mock.infrastructure.entity.MedicalCheck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalCheckMapper {

    @Mapping(source = "data.admittedToDrive", target = "admittedToDrive")
    DoctorEndResponseDto toDto(MedicalCheck medicalCheck);

}
