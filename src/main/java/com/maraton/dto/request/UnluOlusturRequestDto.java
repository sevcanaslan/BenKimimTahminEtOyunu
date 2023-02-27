package com.maraton.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnluOlusturRequestDto {
    private String image;
    private String name;
    private String özellik1;
    private String özellik2;
    private String özellik3;
    private boolean state;

}
