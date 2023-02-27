package com.maraton.service;

import com.maraton.dto.request.UserLoginRequestDto;
import com.maraton.dto.request.UserRegisterRequestDto;
import com.maraton.dto.response.LoginResponseDto;
import com.maraton.dto.response.UserFindAllResponseDto;
import com.maraton.exception.ErrorType;
import com.maraton.exception.MaratonException;
import com.maraton.mapper.IUserMapper;
import com.maraton.repository.IUserRepository;
import com.maraton.repository.entity.User;
import com.maraton.utility.ServiceManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService extends ServiceManager<User,Long> {

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;


    public UserService(IUserRepository userRepository,IUserMapper userMapper) {
        super(userRepository);
        this.userRepository=userRepository;
        this.userMapper = userMapper;
    }
    public void register(UserRegisterRequestDto dto){
        User user= IUserMapper.INSTANCE.toRegister(dto);
        Optional<User> user1=userRepository.findOptionalByEmailAndPassword(user.getEmail(),user.getPassword());
        if(user1.isEmpty()){
            user.setAttemptsLeft(5);
            save(user);
        }else{
            throw new MaratonException(ErrorType.KULLANICI_KAYITLI);
        }

    }

    public LoginResponseDto login(UserLoginRequestDto dto){
        Optional<User> user= userRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if(user.isPresent()){
            return IUserMapper.INSTANCE.toLoginResponseDto(user.get());

        }else {
            throw new MaratonException(ErrorType.KULLANICI_BULUNAMADI);
        }
    }
    public User getUserById(Long userId){
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new RuntimeException("Kullanici Bulunamadi");
        }
    }
    public List<UserFindAllResponseDto> findAllUsers() {
        return userRepository.findAll().stream().map(x->{
            return UserFindAllResponseDto.builder()
                    .id(x.getId())
                    .name(x.getName())
                    .lastName(x.getLastName())
                    .tahminler(x.getTahminler())
                    .build();

        }).collect(Collectors.toList());
    }
    public  List<User> findAllByOrderByName(){

        return userRepository.findAllByOrderByName();
    }
    public List<User> findAllByNameLike(String name){

        return userRepository.findAllByNameLike(name);
    }
}
