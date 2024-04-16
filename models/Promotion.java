package com.carshowroom.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Promotion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private String photo;
    @Column(length = 5000)
    private String description;

    @ManyToOne
    private Users owner;

    public Promotion(String name, String photo, String description, Users owner) {
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.owner = owner;
    }
}
