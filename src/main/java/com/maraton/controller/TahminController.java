package com.maraton.controller;
import com.maraton.dto.request.TahminOlusturRequestDto;
import com.maraton.repository.entity.Tahmin;
import com.maraton.repository.entity.Unlu;
import com.maraton.repository.entity.User;
import com.maraton.service.TahminService;
import com.maraton.service.UnluService;
import com.maraton.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.maraton.constants.RestEndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+TAHMİN)
public class TahminController {

    private final TahminService tahminService;
    private final UserService userService;
    private final UnluService unluService;

    @PostMapping(TAHMINOLUSTUR)
    public ResponseEntity<TahminOlusturRequestDto> createTahmin(@RequestBody TahminOlusturRequestDto requestDto) {
        User user = userService.getUserById(requestDto.getUserId());
        Unlu unlu = unluService.getUnluById(requestDto.getUnluId());
        String tahmin = requestDto.getTahmin().toLowerCase();

        boolean tahminDogru = tahmin.equals(unlu.getName().toLowerCase());
        if (user.getAttemptsLeft() == 0) {
            throw new RuntimeException("Tahmin hakkınız kalmadı.");
        } else {
            user.setAttemptsLeft(user.getAttemptsLeft() - 1);
            userService.save(user);
        }
        Tahmin tahminObj = Tahmin.builder()
                .user(user)
                .unlu(unlu)
                .tahmin(tahmin)
                .isCorrect(tahminDogru)
                .build();
        if (tahminDogru==true) {
            System.out.println("Tebrikler! Tahmininiz doğru.");
        } else {
            System.out.println("Maalesef, tahmininiz yanlış.");
        }

         tahminService.createTahmin(tahminObj);
        return ResponseEntity.ok(TahminOlusturRequestDto.builder().state(true).build());
    }

    @GetMapping("/getTahminById")
    public ResponseEntity<Tahmin> getTahminById(Long id) {
        return  ResponseEntity.ok(tahminService.getTahminById(id));
    }

    @GetMapping("/getTahminByUserId")
    public ResponseEntity<List<Tahmin>> getTahminByUserId(Long userId) {
        return ResponseEntity.ok(tahminService.getTahminByUserId(userId));
    }

    @GetMapping("/getTahminByUnluId")
    public ResponseEntity<List<Tahmin>> getTahminByUnluId( Long unluId) {
        return ResponseEntity.ok(tahminService.getTahminByUnluId(unluId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Tahmin>> findAll(){
        return ResponseEntity.ok(tahminService.findAll());
    }



}
