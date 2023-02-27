package com.maraton.dto.response;


import com.maraton.repository.entity.Tahmin;
import com.maraton.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFindAllResponseDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private List<Tahmin> tahminler;


}

