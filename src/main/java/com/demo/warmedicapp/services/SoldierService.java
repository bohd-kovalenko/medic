package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Soldier;

import java.util.List;

public interface SoldierService {
    List<Soldier> getAllSoldiers();

    Soldier getSoldierById(Integer id);

    void addSoldier(Soldier soldier);

    void updateSoldierById(Integer id, Soldier soldier);
}
