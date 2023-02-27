package com.maraton.mapper;

import com.maraton.dto.request.UserRegisterRequestDto;
import com.maraton.dto.response.LoginResponseDto;
import com.maraton.dto.response.UserFindAllResponseDto;
import com.maraton.repository.entity.Tahmin;
import com.maraton.repository.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-27T15:04:48+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public User toRegister(UserRegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.state( dto.isState() );
        user.name( dto.getName() );
        user.lastName( dto.getLastName() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );

        return user.build();
    }

    @Override
    public LoginResponseDto toLoginResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        LoginResponseDto.LoginResponseDtoBuilder loginResponseDto = LoginResponseDto.builder();

        loginResponseDto.id( user.getId() );
        loginResponseDto.name( user.getName() );
        loginResponseDto.email( user.getEmail() );

        return loginResponseDto.build();
    }

    @Override
    public List<UserFindAllResponseDto> toUserFindAllResponseDtoList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserFindAllResponseDto> list = new ArrayList<UserFindAllResponseDto>( users.size() );
        for ( User user : users ) {
            list.add( userToUserFindAllResponseDto( user ) );
        }

        return list;
    }

    protected UserFindAllResponseDto userToUserFindAllResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserFindAllResponseDto.UserFindAllResponseDtoBuilder userFindAllResponseDto = UserFindAllResponseDto.builder();

        userFindAllResponseDto.id( user.getId() );
        userFindAllResponseDto.name( user.getName() );
        userFindAllResponseDto.lastName( user.getLastName() );
        userFindAllResponseDto.email( user.getEmail() );
        List<Tahmin> list = user.getTahminler();
        if ( list != null ) {
            userFindAllResponseDto.tahminler( new ArrayList<Tahmin>( list ) );
        }

        return userFindAllResponseDto.build();
    }
}
