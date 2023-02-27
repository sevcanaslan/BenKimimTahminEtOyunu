package com.maraton.repository;

import com.maraton.repository.entity.Unlu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUnluRepository  extends JpaRepository<Unlu,Long> {

    List<Unlu> findAllByNameLike(String name);
    List<Unlu> findAllByÖzellik1(String ozellik);


}
