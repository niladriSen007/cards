package com.niladri.cards.dto.cards;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(name="Error_Response",description = "Card details")
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    @NotEmpty (message = "Mobile number cannot be empty")
//    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits")
    @Schema(description = "Mobile number", example = "1234567890")
    private String mobileNumber;

    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{16})", message = "Card number should be 16 digits")
    @Schema(description = "Card number", example = "1234567890123456")
    private String cardNumber;

    @NotEmpty(message = "Card type cannot be empty")
    @Schema(description = "Type of the card", example = "Credit")
    private String cardType;

    @Positive(message = "Total limit should be positive")
    @Schema(description = "Total limit of the card", example = "10000")
    private int totalLimit;

    @PositiveOrZero(message = "Amount used should be positive or zero")
    @Schema(description = "Amount used from the card", example = "5000")
    private int amountUsed;

    @PositiveOrZero
    @Schema(description = "Available amount in the card", example = "5000")
    private int availableAmount;


}
