package com.maraton.mapper;

import com.maraton.dto.request.UserRegisterRequestDto;
import com.maraton.dto.response.LoginResponseDto;
import com.maraton.dto.response.UserFindAllResponseDto;
import com.maraton.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);

    User toRegister(final UserRegisterRequestDto dto);
    LoginResponseDto toLoginResponseDto(final User user);

    List<UserFindAllResponseDto> toUserFindAllResponseDtoList(List<User> users);
}
