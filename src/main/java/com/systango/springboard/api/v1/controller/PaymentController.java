package com.systango.springboard.api.v1.controller;

import com.systango.springboard.api.v1.request.WalletRequest;
import com.systango.springboard.dto.model.payment.WalletDto;
import com.systango.springboard.service.exception.PaymentException;
import com.systango.springboard.service.payment.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Arpit Khandelwal.
 */
@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/registerwallet")
    public void registerWallet(@RequestBody @Valid WalletRequest walletRequest) throws PaymentException {
        WalletDto walletDto = new WalletDto()
                .setUserName(walletRequest.getUsername())
                .setWalletLevel(walletRequest.getWalletLevel());
        paymentService.createUsersWallet(walletDto);
    }
}
