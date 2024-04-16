package com.carshowroom.repo;

import com.carshowroom.models.Dealerships;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealershipRepo extends JpaRepository<Dealerships, Long> {
}
