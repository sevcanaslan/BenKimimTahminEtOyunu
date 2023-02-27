package com.maraton.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblunlu")
public class Unlu  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String özellik1;
    private String özellik2;
    private String özellik3;
    @OneToMany(mappedBy = "unlu",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tahmin> tahminList;


}
