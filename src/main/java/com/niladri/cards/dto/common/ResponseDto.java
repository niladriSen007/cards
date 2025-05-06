package com.niladri.cards.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(name = "Response", description = "Response details")
public class ResponseDto {

    public ResponseDto(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    @Schema(description = "Status code", example = "200")
    @NotNull
    public String statusCode;

    @Schema(description = "Status message", example = "Success")
    @NotNull
    public String statusMessage;
}
