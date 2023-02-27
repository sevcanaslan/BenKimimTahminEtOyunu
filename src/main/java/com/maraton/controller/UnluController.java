package com.maraton.controller;

import com.maraton.dto.request.UnluOlusturRequestDto;
import com.maraton.dto.response.ResultDto;
import com.maraton.dto.response.UserFindAllResponseDto;
import com.maraton.repository.entity.Unlu;
import com.maraton.service.UnluService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maraton.constants.RestEndPoints.*;
@RestController
@RequestMapping(VERSION+API+UNLU)
@RequiredArgsConstructor
public class UnluController {

    private final UnluService unluService;

    @PostMapping(UNLUOLUSTUR)
    public ResponseEntity<UnluOlusturRequestDto> unluOlustur(@RequestBody UnluOlusturRequestDto dto){
        unluService.unluOlustur(dto);
        return ResponseEntity.ok(UnluOlusturRequestDto.builder().state(true).build());
    }
    @GetMapping("/findbyid")
    public ResponseEntity<Unlu> findById(Long id){

        return ResponseEntity.ok(unluService.getUnluById(id));
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Unlu>> findAllUsers() {
        return ResponseEntity.ok(unluService.findAll());
    }

    @GetMapping("/findbynamewithlike")
    public ResponseEntity< List<Unlu>> findAllByNameLike(String name){

        return ResponseEntity.ok(unluService.findAllByNameLike("%"+name+"%"));
    }
    @GetMapping("/findallbyözellik1like")
    public ResponseEntity< List<Unlu>> findAllByÖzellik1Like(String ozellik){

        return ResponseEntity.ok(unluService.findAllByÖzellik1Like("%"+ozellik+"%"));
    }
}
