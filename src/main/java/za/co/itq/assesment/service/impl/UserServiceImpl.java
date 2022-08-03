package za.co.itq.assesment.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.itq.assesment.domain.UserRequestDto;
import za.co.itq.assesment.domain.UserResponseDto;
import za.co.itq.assesment.entity.UserEntity;
import za.co.itq.assesment.repository.UserRepository;
import za.co.itq.assesment.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        UserEntity user = modelMapper.map(userRequestDto, UserEntity.class);
        Optional<UserEntity> userEntity = Optional.ofNullable(userRepository.save(user));
        return userEntity.isPresent() ? modelMapper.map(userEntity.get(), UserResponseDto.class) : null;
    }

    @Override
    public UserResponseDto retrieveUserById(UUID uuid) {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findUserEntityById(uuid));
        if(user.isPresent()){
            return modelMapper.map(user.get(),UserResponseDto.class).toUpperCase();
        } else {
            return null;
        }
    }

    @Override
    public List<UserResponseDto> findAll() {
        return modelMapper.map(userRepository.findAll(), new TypeToken<List<UserResponseDto>>() {}.getType());
    }




}
