package com.maraton.dto.request;

import com.maraton.repository.entity.Unlu;
import com.maraton.repository.entity.User;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TahminOlusturRequestDto {

    private Long userId;
    private Long unluId;
    private String tahmin;
    private boolean isCorrect;
    private boolean state;

}
