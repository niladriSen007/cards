package com.niladri.cards.controller;

import com.niladri.cards.dto.cards.CardDto;
import com.niladri.cards.dto.common.ResponseDto;
import com.niladri.cards.service.CardService;
import com.niladri.cards.service.CardServiceInterface;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/v1/cards")
@RestController
@AllArgsConstructor
@Validated
public class CardController {

    private CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber) {
        String cardNumber = cardService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "Card created successfully with card number: " + cardNumber));
    }

    @GetMapping("/get/{cardNumber}")
    public ResponseEntity<CardDto> getCardDetails( @PathVariable String cardNumber) {
        CardDto cardDetails = cardService.getCardDetails(cardNumber);
        return ResponseEntity.ok(cardDetails);
    }

    @PutMapping("/update/{cardNumber}")
    public ResponseEntity<CardDto> updateCardDetails(@PathVariable String cardNumber, @Valid @RequestBody CardDto cardDto) {
        CardDto updatedCard = cardService.updateCardDetails(cardNumber, cardDto);
        return ResponseEntity.ok(updatedCard);
    }


    @DeleteMapping("/delete/{cardNumber}")
    public ResponseEntity<ResponseDto> deleteCard(@PathVariable String cardNumber) {
        cardService.deleteCard(cardNumber);
        return ResponseEntity.ok(new ResponseDto("200", "Card deleted successfully"));
    }
}
