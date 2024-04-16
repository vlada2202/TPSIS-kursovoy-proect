package com.carshowroom.repo;

import com.carshowroom.models.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Carts, Long> {
}
