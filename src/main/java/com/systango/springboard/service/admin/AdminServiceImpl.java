package com.systango.springboard.service.admin;

import com.systango.springboard.domain.model.Faq;
import com.systango.springboard.domain.repository.FaqRepository;
import com.systango.springboard.dto.model.FaqDto;
import com.systango.springboard.service.exception.FaqExistsException;
import com.systango.springboard.util.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Arpit Khandelwal.
 */
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
    private final FaqRepository faqRepository;

    public AdminServiceImpl(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @Override
    @Transactional
    public String addFaq(FaqDto faqDto) throws FaqExistsException {
        AssertUtils.notNull(faqDto, faqDto.getQuestion());

        Optional<Faq> faq = Optional.ofNullable(faqRepository.findByQuestion(faqDto.getQuestion()));
        if (faq.isPresent()) {
            LOGGER.debug("FAQ with Question:'{}' and Answer: '{}' already exists", faqDto.getQuestion(), faqDto.getAnswer());
            throw new FaqExistsException();
        } else {
            //persist the new faq
            Faq newFaq = new Faq()
                    .setQuestion(faqDto.getQuestion())
                    .setAnswer(faqDto.getAnswer());
            faqRepository.save(newFaq);
        }
        return "FAQ added successfully";
    }
}
