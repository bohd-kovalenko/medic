package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.repositories.SoldierToMedicRepository;
import com.demo.warmedicapp.services.SoldierToMedicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SoldierToMedicServiceImpl implements SoldierToMedicService {
    SoldierToMedicRepository soldierToMedicRepository;

    public List<Soldier> getSoldiersByMedicId(Integer id) {
        return soldierToMedicRepository.findAllByMedicId(id);
    }
}
