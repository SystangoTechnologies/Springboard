package com.systango.springboard.service.admin;

import com.systango.springboard.domain.model.Faq;
import com.systango.springboard.domain.repository.FaqRepository;
import com.systango.springboard.dto.model.FaqDto;
import com.systango.springboard.service.exception.FaqExistsException;
import com.systango.springboard.util.AssertUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Arpit Khandelwal.
 */
public class AdminServiceImpl implements AdminService {

    private final FaqRepository faqRepository;

    public AdminServiceImpl(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @Override
    @Transactional
    public String addFaq(FaqDto faqDto) throws FaqExistsException {
        AssertUtils.notNull(faqDto, faqDto.getQuestion());

        //check for an existing faq and report an error if its already there
        List<Faq> faqs = faqRepository.findAll();
        for (Faq faq : faqs) {
            if (faqDto.getQuestion().equalsIgnoreCase(faq.getQuestion())) {
                throw new FaqExistsException();
            }
        }

        //persist the new faq
        Faq newFaq = new Faq()
                .setQuestion(faqDto.getQuestion())
                .setAnswer(faqDto.getAnswer());
        faqRepository.save(newFaq);

        return "FAQ added successfully";
    }
}
