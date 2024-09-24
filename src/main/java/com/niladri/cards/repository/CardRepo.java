package com.niladri.cards.repository;

import com.niladri.cards.model.card.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<CardModel, Long> {
    Optional<CardModel> findByMobileNumber(String mobileNumber);

    Optional<CardModel> findByCardNumber(String cardNumber);
}
