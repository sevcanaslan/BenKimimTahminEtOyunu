package com.maraton.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserLoginRequestDto {

    private String email;
    private String password;
    private boolean state;
}
