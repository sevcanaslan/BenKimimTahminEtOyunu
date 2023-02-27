package com.maraton.service;

import com.maraton.repository.ITahminRepository;
import com.maraton.repository.entity.Tahmin;
import com.maraton.repository.entity.Unlu;
import com.maraton.repository.entity.User;
import com.maraton.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TahminService extends ServiceManager<Tahmin,Long> {

    private final ITahminRepository tahminRepository;

    public TahminService(ITahminRepository tahminRepository) {
        super(tahminRepository);
       this.tahminRepository=tahminRepository;
    }
    public List<Tahmin> getTahminByUserAndUnlu(User user, Unlu unlu) {
        return tahminRepository.findByUserAndUnlu(user, unlu);
    }
    public Tahmin createTahmin(Tahmin tahmin) {
        User user = tahmin.getUser();
        Unlu unlu = tahmin.getUnlu();
        List<Tahmin> tahminList = getTahminByUserAndUnlu(user, unlu);
        if (tahminList.size() >= 5) {
            throw new RuntimeException("Bir kullanıcı en fazla 5 tahmin yapabilir.");
        }
        return tahminRepository.save(tahmin);
    }

    public Tahmin getTahminById(Long id) {
        return tahminRepository.findById(id).orElse(null);
    }

    public List<Tahmin> getTahminByUserId(Long userId) {
        return tahminRepository.findByUserId(userId);
    }

    public List<Tahmin> getTahminByUnluId(Long unluId) {
        return tahminRepository.findByUnluId(unluId);
    }

    public boolean checkTahmin(Tahmin tahmin) {
        String dogruTahmin = tahmin.getUnlu().getName();
        boolean sonuc = tahmin.getTahmin().equalsIgnoreCase(dogruTahmin);
        tahmin.setCorrect(sonuc);
        tahminRepository.save(tahmin);
        return sonuc;
    }

    public int getRemainingAttempts(Long userId) {
        int toplamTahminSayisi = tahminRepository.countByUserId(userId);
        return 3 - toplamTahminSayisi;
    }
}
