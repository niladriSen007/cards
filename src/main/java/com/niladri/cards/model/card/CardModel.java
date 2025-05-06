package com.niladri.cards.model.card;

import com.niladri.cards.model.common.BaseModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "t_cards")
public class CardModel extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;

    @NotBlank
    @Schema(description = "Name of the card holder", example = "Niladri")
    @Column(name = "mobile_number")
    private String mobileNumber;

    @NotBlank
    @Column(name = "card_number")
    private String cardNumber;

    @NotBlank
    @Column(name = "card_type")
    private String cardType;

    @NotNull
    @Column(name = "total_limit")
    private int totalLimit;

    @NotNull
    @Column(name = "amount_used")
    private int amountUsed;

    @NotNull
    @Column(name = "available_amount")
    private int availableAmount;
}
