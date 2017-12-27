package com.systango.springboard.mapper;


import com.systango.springboard.domain.model.Faq;
import com.systango.springboard.dto.model.FaqDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Arpit Khandelwal.
 */
public abstract class FaqMapper {

    public static List<FaqDto> mapFaqs(List<Faq> faqs) {
        return faqs.stream().map(FaqMapper::mapFaq).collect(toList());
    }

    public static FaqDto mapFaq(Faq faq) {
        return new FaqDto()
                .setAnswer(faq.getAnswer())
                .setQuestion(faq.getQuestion());
    }
}

