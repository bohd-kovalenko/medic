package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Soldier;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SoldierService {
    ResponseEntity<List<Soldier>> getAllSoldiers();

    ResponseEntity<Soldier> getSoldierById(Integer id);

    ResponseEntity<Void> addSoldier(Soldier soldier);

    ResponseEntity<Void> updateSoldierById(Integer id, Soldier soldier);
}
