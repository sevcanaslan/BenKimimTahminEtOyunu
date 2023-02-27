package com.maraton.mapper;

import com.maraton.dto.request.UnluOlusturRequestDto;
import com.maraton.repository.entity.Unlu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUnluMapper {

    IUnluMapper INSTANCE= Mappers.getMapper(IUnluMapper.class);

    Unlu toUnlu(final UnluOlusturRequestDto dto);
}
