package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Medic;
import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.repositories.MedicRepository;
import com.demo.warmedicapp.repositories.SoldierRepository;
import com.demo.warmedicapp.repositories.SoldierToMedicRepository;
import com.demo.warmedicapp.services.SoldierToMedicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SoldierToMedicServiceImpl implements SoldierToMedicService {
    SoldierToMedicRepository soldierToMedicRepository;

    public List<Soldier> getSoldiersByMedicId(Integer id) {
        return soldierToMedicRepository.findAllByMedicId(id);
    }
}
