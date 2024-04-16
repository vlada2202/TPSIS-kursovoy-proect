package com.carshowroom.repo;

import com.carshowroom.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepo extends JpaRepository<Income, Long> {
}
