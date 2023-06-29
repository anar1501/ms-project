package com.example.userservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl {

    private UserRepository userRepository;

    private APIClient apiClient;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseDto getUser(Long userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

        DepartmentDto departmentDto = apiClient.getDepartmentById(user.getDepartmentId());
        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}

