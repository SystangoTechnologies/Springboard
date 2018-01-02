package com.systango.springboard.mapper;


import com.systango.springboard.domain.model.payment.WalletDetails;
import com.systango.springboard.dto.model.payment.WalletDto;

/**
 * @author Arpit Khandelwal
 */
public class WalletMapper {

    public static WalletDto mapWallet(WalletDetails walletDetails) {
        return new WalletDto()
                .setBalance(walletDetails.getBalance())
                .setUserName(walletDetails.getApplicationUser().getUsername())
                .setWalletLevel(walletDetails.getWalletLevel());
    }
}