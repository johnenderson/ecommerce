package tech.buildrun.ecommerce.service;

import org.springframework.stereotype.Service;
import tech.buildrun.ecommerce.controller.dto.CreateUserDTO;
import tech.buildrun.ecommerce.entities.BillingAddressEntity;
import tech.buildrun.ecommerce.entities.UserEntity;
import tech.buildrun.ecommerce.exception.CreateBillingAddressException;
import tech.buildrun.ecommerce.exception.CreateUserException;
import tech.buildrun.ecommerce.repository.BillingAddressRepository;
import tech.buildrun.ecommerce.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.util.StringUtils.hasText;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDTO dto) {

        var billingAddress = new BillingAddressEntity();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());

//        var savedBillingAddress = billingAddressRepository.save(billingAddress);

        var user = new UserEntity();
        user.setFullName(dto.fullName());
        user.setBillingAddressEntity(billingAddress);

        return userRepository.save(user);
    }

    public Optional<UserEntity> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    public boolean deletedById(UUID userId) {

        var user = userRepository.findById(userId);

        if (user.isPresent()) {
            userRepository.deleteById(userId);
//            billingAddressRepository.deleteById(user.get().getBillingAddressEntity().getBillingAddressId());
        }

        return user.isPresent();
    }
}
