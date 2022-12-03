package com.basenko.shoppingcart.service;

import com.basenko.shoppingcart.dto.request.UserDto;
import com.basenko.shoppingcart.exception.LoginIsAlreadyExistsException;
import com.basenko.shoppingcart.exception.MailIsAlreadyExistsException;
import com.basenko.shoppingcart.exception.PhoneIsAlreadyExistsException;
import com.basenko.shoppingcart.exception.UserNotFoundException;
import com.basenko.shoppingcart.model.Role;
import com.basenko.shoppingcart.model.User;
import com.basenko.shoppingcart.repo.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(()->
                new UserNotFoundException(id));
    }

    @Transactional
    public void createUser(UserDto userDto) {
        if(userRepository.findByLogin(userDto.getLogin()).isPresent()){
            throw new LoginIsAlreadyExistsException(userDto.getLogin());
        }
        if(userRepository.findByPhoneNumber(userDto.getPhoneNumber()).isPresent()){
            throw new PhoneIsAlreadyExistsException(userDto.getPhoneNumber());
        }
        if(userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new MailIsAlreadyExistsException(userDto.getEmail());
        }
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .phoneNumber(userDto.getPhoneNumber())
                .password(new BCryptPasswordEncoder().encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .login(userDto.getLogin())
                .role(Role.CLIENT)
                .build();
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(()->
                new UserNotFoundException (login , true)
        );
    }
}
