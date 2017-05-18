package com.example.common.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class ErrorMessageDTO {
    String code;
    String message;
}
