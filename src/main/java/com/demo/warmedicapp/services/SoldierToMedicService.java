package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Soldier;

import java.util.List;

public interface SoldierToMedicService {
    public List<Soldier> getSoldiersByMedicId(Integer id);
}
