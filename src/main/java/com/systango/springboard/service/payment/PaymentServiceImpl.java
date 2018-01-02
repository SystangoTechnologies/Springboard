package com.systango.springboard.service.payment;

import com.systango.springboard.domain.model.payment.WalletDetails;
import com.systango.springboard.domain.model.user.ApplicationUser;
import com.systango.springboard.domain.repository.ApplicationUserRepository;
import com.systango.springboard.domain.repository.WalletRepository;
import com.systango.springboard.dto.model.payment.WalletDto;
import com.systango.springboard.service.exception.PaymentException;
import com.systango.springboard.util.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Arpit Khandelwal.
 */
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final ApplicationUserRepository userRepository;

    private final WalletRepository walletRepository;

    public PaymentServiceImpl(ApplicationUserRepository userRepository, WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    @Transactional
    public WalletDetails createUsersWallet(WalletDto walletDto) throws PaymentException {
        AssertUtils.notNull(walletDto);
        Optional<ApplicationUser> user = Optional.ofNullable(userRepository.findByUsername(walletDto.getUserName()));
        if (user.isPresent()) {
            WalletDetails walletDetails = new WalletDetails()
                    .setWalletLevel(walletDto.getWalletLevel())
                    .setApplicationUser(user.get());
            user.get().setWalletDetails(walletDetails);
            walletRepository.save(walletDetails);
            return walletDetails;
        } else {
            LOGGER.debug("User with username :'{}' doesn't exist", walletDto.getUserName());
            throw new PaymentException();
        }
    }
}
