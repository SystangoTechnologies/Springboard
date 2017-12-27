package com.systango.springboard.api.v1.controller;


import com.systango.springboard.domain.repository.FaqRepository;
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

    private FaqRepository faqRepository;

    @Autowired
    public AboutController(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @GetMapping(value = "/faq", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getFaq() {
        return Response.ok().setPayload(FaqMapper.mapFaqs(faqRepository.findAll()));
    }

}

