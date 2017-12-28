package com.systango.springboard.service.user;

import com.systango.springboard.dto.model.user.UserDto;
import com.systango.springboard.service.exception.UserExistsException;

/**
 * Created by Arpit Khandelwal.
 */
public interface UserService {
    /**
     * Service method to add a new user.
     *
     * @param userDto
     * @return
     * @throws UserExistsException
     */
    String addUser(UserDto userDto) throws UserExistsException;
}
