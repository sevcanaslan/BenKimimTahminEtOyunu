package com.maraton.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegisterRequestDto {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private boolean state;
}
