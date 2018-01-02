package com.systango.springboard.domain.repository;

import com.systango.springboard.domain.model.payment.WalletDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Arpit Khandelwal.
 */
public interface WalletRepository extends CrudRepository<WalletDetails, Long> {
    /**
     * List all the wallets for a given userID
     *
     * @param userID
     * @return
     */
    List<WalletDetails> findByApplicationUser(String userID);
}
