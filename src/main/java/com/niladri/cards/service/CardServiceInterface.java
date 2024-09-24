package com.niladri.cards.service;

import com.niladri.cards.dto.cards.CardDto;
import jakarta.validation.Valid;

import java.util.Optional;

public interface CardServiceInterface {
    String createCard(@Valid String mobileNumber);

    CardDto getCardDetails(String cardNumber);

    CardDto updateCardDetails(String mobileNumber, @Valid CardDto cardDto);

    void deleteCard(String cardNumber);
}
