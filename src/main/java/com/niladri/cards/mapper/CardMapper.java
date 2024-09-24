package com.niladri.cards.mapper;

import com.niladri.cards.dto.cards.CardDto;
import com.niladri.cards.model.card.CardModel;

public class CardMapper {
    public static CardDto toCardDto(CardModel cardModel) {
        CardDto cardDto = new CardDto();
        cardDto.setMobileNumber(cardModel.getMobileNumber());
        cardDto.setCardNumber(cardModel.getCardNumber());
        cardDto.setCardType(cardModel.getCardType());
        cardDto.setTotalLimit(cardModel.getTotalLimit());
        cardDto.setAmountUsed(cardModel.getAmountUsed());
        cardDto.setAvailableAmount(cardModel.getAvailableAmount());
        return cardDto;

    }

    public static CardModel toCardModel(CardDto cardDto) {
        CardModel cardModel = new CardModel();

        cardModel.setCardNumber(cardDto.getCardNumber());
        cardModel.setMobileNumber(cardDto.getMobileNumber());
        cardModel.setCardType(cardDto.getCardType());
        cardModel.setTotalLimit(cardDto.getTotalLimit());
        cardModel.setAmountUsed(cardDto.getAmountUsed());
        cardModel.setAvailableAmount(cardDto.getAvailableAmount());
        return cardModel;
    }
    }
