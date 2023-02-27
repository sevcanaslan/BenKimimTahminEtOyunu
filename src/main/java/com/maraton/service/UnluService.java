package com.maraton.service;

import com.maraton.dto.request.UnluOlusturRequestDto;
import com.maraton.dto.response.UserFindAllResponseDto;
import com.maraton.mapper.IUnluMapper;
import com.maraton.repository.IUnluRepository;
import com.maraton.repository.entity.Unlu;
import com.maraton.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnluService extends ServiceManager<Unlu,Long> {

    private final IUnluRepository unluRepository;


    public UnluService(IUnluRepository unluRepository) {
        super(unluRepository);
        this.unluRepository=unluRepository;


    }

    public void unluOlustur(UnluOlusturRequestDto dto){
        save(IUnluMapper.INSTANCE.toUnlu(dto));
    }


    public Unlu getUnluById(Long unluId) {
        Optional<Unlu> unlu=unluRepository.findById(unluId);
        if(unlu.isPresent()){
            return unlu.get();
        }else{
            throw new RuntimeException("Kullanici bulunamadi!");
        }
    }

    public List<Unlu> findAll(){
        return unluRepository.findAll();
    }
    public List<Unlu> findAllByNameLike(String name){

        return unluRepository.findAllByNameLike(name);
    }
    public List<Unlu> findAllByÖzellik1Like(String ozellik){
        return unluRepository.findAllByÖzellik1(ozellik);
    }

}
