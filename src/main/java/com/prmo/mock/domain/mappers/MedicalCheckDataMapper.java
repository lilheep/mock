package com.prmo.mock.domain.mappers;

import com.prmo.mock.controller.dto.doctor.DoctorEndRequestDto;
import com.prmo.mock.domain.constants.MedicalCheckDataMapperFields;
import com.prmo.mock.domain.constants.MedicalCheckMapperFields;
import com.prmo.mock.infrastructure.entity.MedicalCheckData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalCheckDataMapper {

    @Mapping(target = MedicalCheckDataMapperFields.ID, ignore = true)
    @Mapping(target = MedicalCheckDataMapperFields.MEDICAL_CHECK, ignore = true)
    @Mapping(target = MedicalCheckDataMapperFields.CREATED_AT, ignore = true)
    MedicalCheckData toEntity(DoctorEndRequestDto dto);

}
