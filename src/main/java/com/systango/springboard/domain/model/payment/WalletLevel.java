package com.systango.springboard.domain.model.payment;

import java.util.Optional;

/**
 * @author Arpit Khandelwal
 */
public enum WalletLevel {

    WALLET_BITCOIN, WALLET_REGULAR;

    public static Optional<WalletLevel> getByName(String name) {
        for (WalletLevel walletLevel : values()) {
            if (walletLevel.name().equals(name)) {
                return Optional.of(walletLevel);
            }
        }
        return Optional.empty();
    }
}