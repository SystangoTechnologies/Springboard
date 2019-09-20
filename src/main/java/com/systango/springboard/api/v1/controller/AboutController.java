package com.systango.springboard.api.v1.controller;


import com.systango.springboard.domain.repository.FaqRepository;
import com.systango.springboard.domain.repository.SettingsRepository;
import com.systango.springboard.dto.response.Response;
import com.systango.springboard.mapper.FaqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arpit Khandelwal.
 */
@RestController
@RequestMapping("/v1/about")
public class AboutController {

    private SettingsRepository settingsRepository;
    private FaqRepository faqRepository;


    @Autowired
    public AboutController(FaqRepository faqRepository, SettingsRepository settingsRepository) {
        this.faqRepository = faqRepository;
        this.settingsRepository = settingsRepository;
    }

    @GetMapping(value = "/faq", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Object> getFaq() {
        return Response.ok().setPayload(FaqMapper.mapFaqs(faqRepository.findAll()));
    }

    @GetMapping(value = "/terms-and-conditions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Object> getTermsAndConditions() {
        return Response.ok().setPayload(settingsRepository.findTermsAndConditions().getSettingValue());
    }

    @GetMapping(value = "/privacy-policy", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Object> getPrivacyPolicy() {
        return Response.ok().setPayload(settingsRepository.findPrivacyPolicy().getSettingValue());
    }

    @GetMapping(value = "/about-us", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Object> getAboutUs() {
        return Response.ok().setPayload(settingsRepository.findAbout().getSettingValue());
    }

}

