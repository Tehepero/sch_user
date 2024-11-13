package com.sparta.sch_user.service;

import com.sparta.sch_user.dto.UserRequestDto;
import com.sparta.sch_user.dto.UserResponseDto;
import com.sparta.sch_user.entity.User;
import com.sparta.sch_user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .sorted(Comparator.comparing(User::getCreatedAt).reversed())
                .map(UserResponseDto::toDto)
                .toList();
    }

    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User savedUser = userRepository.save(userRequestDto.toEntity());
        return UserResponseDto.toDto(savedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        findUserById(id);
        userRepository.deleteById(id);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }
}
