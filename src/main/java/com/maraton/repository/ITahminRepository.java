package com.maraton.repository;

import com.maraton.repository.entity.Tahmin;
import com.maraton.repository.entity.Unlu;
import com.maraton.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITahminRepository  extends JpaRepository<Tahmin,Long> {

    List<Tahmin> findByUserId(Long userId);

    List<Tahmin> findByUnluId(Long unluId);

    int countByUserId(Long userId);

    List<Tahmin> findByUserAndUnlu(User user, Unlu unlu);

}
