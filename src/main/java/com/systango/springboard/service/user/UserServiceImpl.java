package com.systango.springboard.service.user;

import com.systango.springboard.domain.model.user.ApplicationUser;
import com.systango.springboard.domain.repository.ApplicationUserRepository;
import com.systango.springboard.dto.model.user.UserDto;
import com.systango.springboard.service.exception.UserExistsException;
import com.systango.springboard.util.AssertUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Arpit Khandelwal.
 */
public class UserServiceImpl implements UserService {

    private final ApplicationUserRepository userRepository;

    /**
     * @param userRepository
     */
    public UserServiceImpl(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public String addUser(UserDto userDto) throws UserExistsException {
        AssertUtils.notNull(userDto, userDto.getUsername(), userDto.getPassword());
        Optional<ApplicationUser> user = Optional.ofNullable(userRepository.findByUsername(userDto.getUsername()));

        if (user.isPresent()) {
            throw new UserExistsException();
        } else {
            ApplicationUser appUser = new ApplicationUser()
                    .setUsername(userDto.getUsername())
                    .setPassword(userDto.getPassword());
            userRepository.save(appUser);
        }
        return null;
    }
}
