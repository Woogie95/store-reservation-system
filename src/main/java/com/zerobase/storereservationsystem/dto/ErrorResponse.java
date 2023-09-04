package com.zerobase.storereservationsystem.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String filed;
    private String message;

}
