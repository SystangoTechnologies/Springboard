package com.systango.springboard.service.admin;

import com.systango.springboard.dto.model.FaqDto;
import com.systango.springboard.service.exception.FaqExistsException;

/**
 * Created by Arpit Khandelwal.
 */

public interface AdminService {

    /**
     * Add a new FAQ to the existing list of those
     *
     * @param faqDto
     * @return confirmation message
     */
    String addFaq(FaqDto faqDto) throws FaqExistsException;
}
