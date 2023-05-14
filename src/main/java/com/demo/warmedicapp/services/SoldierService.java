package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.payload.responses.SoldierResponse;

import java.util.List;

public interface SoldierService {
    List<Soldier> getAllSoldiers();

    List<Soldier> getNotDeletedSoldiers();

    Soldier getSoldierById(Integer id);

    List<Soldier> searchSoldiers(String search);

    void addSoldier(Soldier soldier);

    void updateSoldierById(Integer id, Soldier soldier);

    void deleteSoldierById(Integer id);

    List<SoldierResponse> getAllSoldiersRelatedToTheDoctor(String username);
}
