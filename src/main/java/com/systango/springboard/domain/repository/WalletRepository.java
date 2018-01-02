package com.systango.springboard.domain.repository;

import com.systango.springboard.domain.model.payment.WalletDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface WalletRepository extends CrudRepository<WalletDetails, Long> {
    /**
     * List the wallet details for a given userID
     *
     * @param userID
     * @return
     */
    WalletDetails findByApplicationUser_Id(Long userID);
}
