package com.example.proba.services;

import com.example.proba.models.Appointment;
import com.example.proba.repositories.AppoinmentRepository;
import com.example.proba.repositories.DealerRepositiries;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class DealersService {
    private final DealerRepositiries dealerRepositiries;
    public List<DealerRepositiries> list(String name)
    {
        return dealerRepositiries.findAll();
    }

    public boolean addToDealers(Appointment appointment) {
        if (dealerRepositiries.findAllByName(dealer.getName()) != null) {
            return false;
        }
        dealerRepositiries.save(appointment);
        return true;
    }

    public void deleteDealers(Long id) {
        dealerRepositiries.deleteById(id);
    }
}