package com.carshowroom.models;

import com.carshowroom.models.enums.Fuel;
import com.carshowroom.models.enums.Transmission;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cars implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String origin;
    @Column(length = 5000)
    private String description;
    private String poster;
    private String[] screenshots;
    private int year;
    private int count;
    private int discount;
    private float capacity;
    private int mileage;
    private int consumption;

    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dealerships dealership;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Income income;
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comments> comments;

    public Cars(String name, String origin, String description, String poster, String[] screenshots, int year, int price, int count, int discount, float capacity, int mileage, int consumption, Fuel fuel, Transmission transmission) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.poster = poster;
        this.screenshots = screenshots;
        this.year = year;
        this.count = count;
        this.income = new Income(price);
        this.discount = discount;
        this.capacity = capacity;
        this.mileage = mileage;
        this.consumption = consumption;
        this.fuel = fuel;
        this.transmission = transmission;
    }

    public void set(String name, String origin, String description, int year, int price, int count, int discount, float capacity, int mileage, int consumption, Fuel fuel, Transmission transmission) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.year = year;
        this.count = count;
        this.income.setPrice(price);
        this.discount = discount;
        this.capacity = capacity;
        this.mileage = mileage;
        this.consumption = consumption;
        this.fuel = fuel;
        this.transmission = transmission;
    }

    public int getPriceWithDiscount() {
        if (discount == 0) return 0;
        return income.getPrice() - income.getPrice() * discount / 100;
    }

    public void addComment(Comments comment) {
        comments.add(comment);
        comment.setBook(this);
    }

    public void removeComment(Comments comment) {
        comments.remove(comment);
        comment.setBook(null);
    }
}
