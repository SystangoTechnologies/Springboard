package com.systango.springboard.domain.repository;

import com.systango.springboard.domain.model.Settings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arpit Khandelwal
 */
@Repository
public interface SettingsRepository extends CrudRepository<Settings, Long> {

    @Query("SELECT s FROM Settings s WHERE s.settingKey = 'about'")
    Settings findAbout();

    @Query("SELECT s FROM Settings s WHERE s.settingKey = 'terms_and_conditions'")
    Settings findTermsAndConditions();

    @Query("SELECT s FROM Settings s WHERE s.settingKey = 'privacy_policy'")
    Settings findPrivacyPolicy();

}