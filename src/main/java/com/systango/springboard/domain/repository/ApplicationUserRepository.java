package com.systango.springboard.domain.repository;

import com.systango.springboard.domain.model.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    /**
     * Finds a user by userName field.
     *
     * @param username
     * @return
     */
    ApplicationUser findByUsername(String username);
}
