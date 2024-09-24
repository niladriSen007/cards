package com.niladri.cards.service;

import com.niladri.cards.constants.CardConstants;
import com.niladri.cards.dto.cards.CardDto;
import com.niladri.cards.mapper.CardMapper;
import com.niladri.cards.model.card.CardModel;
import com.niladri.cards.repository.CardRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardService implements CardServiceInterface {

    private CardRepo cardRepo;

    @Override
    public String createCard(String mobileNumber) {
        Optional<CardModel> cardDetails = cardRepo.findByMobileNumber(mobileNumber);
        System.out.println("Card: " + cardDetails);
        if(cardDetails.isPresent()) {
            throw new RuntimeException("Card already exists for the mobile number");
        }

        CardModel newCard = cardRepo.save(createNewCard(mobileNumber));
        return  newCard.getCardNumber();
    }

    @Override
    public CardDto getCardDetails(String cardNumber) {
       CardModel cardDetails = cardRepo.findByCardNumber(cardNumber).orElseThrow(()->new RuntimeException("Card not found"));
       return CardMapper.toCardDto(cardDetails);
    }

    @Override
    public CardDto updateCardDetails(String cardNumber, CardDto cardDto) {
        CardModel cardDetails = cardRepo.findById(Long.parseLong(cardNumber)).orElseThrow(()-> new RuntimeException("Card not found"));
        CardModel updatedCard = cardRepo.save(CardMapper.toCardModel(cardDto));
        return CardMapper.toCardDto(updatedCard);
    }

    @Override
    public void deleteCard(String cardNumber) {
        CardModel cardDetails = cardRepo.findById(Long.parseLong(cardNumber)).orElseThrow(()-> new RuntimeException("Card not found"));
        cardRepo.deleteById(Long.parseLong(cardNumber));
    }

    private CardModel createNewCard(String mobileNumber) {
        CardModel newCardModel = new CardModel();
        newCardModel.setMobileNumber(mobileNumber);
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCardModel.setCardNumber(Long.toString(randomCardNumber));
        newCardModel.setCardType(CardConstants.CREDIT_CARD);
        newCardModel.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        newCardModel.setAmountUsed(0);
        newCardModel.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return newCardModel;
    }
}
