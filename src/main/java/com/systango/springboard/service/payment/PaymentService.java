package com.systango.springboard.service.payment;

import com.systango.springboard.domain.model.payment.WalletDetails;
import com.systango.springboard.dto.model.payment.WalletDto;
import com.systango.springboard.service.exception.PaymentException;

/**
 * Created by Arpit Khandelwal.
 */
public interface PaymentService {

    /**
     * Get a user's wallet details.
     *
     * @param userName
     * @return
     * @throws PaymentException
     */
    WalletDetails getWalletDetails(String userName) throws PaymentException;

    /**
     * Create a new wallet for the user with given id
     *
     * @param walletDto
     * @return
     * @throws PaymentException
     */
    WalletDetails createUsersWallet(WalletDto walletDto) throws PaymentException;

}
