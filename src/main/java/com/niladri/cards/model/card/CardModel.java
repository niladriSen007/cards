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
@Table(name = "cards")
public class CardModel extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @NotBlank
    @Schema(description = "Name of the card holder", example = "Niladri")
    private String mobileNumber;

    @NotBlank
    private String cardNumber;

    @NotBlank
    private String cardType;

    @NotNull
    private int totalLimit;

    @NotNull
    private int amountUsed;

    @NotNull
    private int availableAmount;
}
