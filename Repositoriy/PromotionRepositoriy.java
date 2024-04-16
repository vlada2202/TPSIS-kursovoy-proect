package com.carshowroom.repo;

import com.carshowroom.models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepo extends JpaRepository<Promotion, Long> {
}
