package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Credentials;
import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.exceptions.ValidationException;
import com.demo.warmedicapp.payload.responses.SoldierResponse;
import com.demo.warmedicapp.repositories.SoldierRepository;
import com.demo.warmedicapp.services.CredentialsService;
import com.demo.warmedicapp.services.SoldierService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SoldierServiceImpl implements SoldierService {
    private final SoldierRepository soldierRepository;
    private final CredentialsService credentialsService;

    @Override
    public List<Soldier> getAllSoldiers() {
        return soldierRepository.findAll();
    }

    @Override
    public List<Soldier> getNotDeletedSoldiers() {
        return soldierRepository.findAll();
    }

    @Override
    public Soldier getSoldierById(Integer id) {
        return soldierRepository
                .findById(id)
                .orElseThrow(() -> new UnexistingSoldierException(id));
    }

    @Override
    public List<Soldier> searchSoldiers(String search) {
        return soldierRepository.searchSoldiers(search);
    }

    @Override
    @Transactional
    public void addSoldier(Soldier soldier) {
        try {
            soldierRepository.save(soldier);
        } catch (Exception e) {
            throw new ValidationException();
        }
    }

    @Override
    @Transactional
    public void updateSoldierById(Integer id, Soldier soldier) {
        Soldier soldierEntity = soldierRepository.findById(id).orElseThrow(() -> new UnexistingSoldierException(id));

        soldier.setId(soldierEntity.getId());

        try {
            soldierRepository.save(soldier);
        } catch (Exception e) {
            throw new ValidationException();
        }
    }

    @Override
    @Transactional
    public void deleteSoldierById(Integer id) {
        Soldier soldierEntity = soldierRepository.findById(id).orElseThrow(() -> new UnexistingSoldierException(id));

        soldierEntity.setDeletedAt(LocalDateTime.now());

        try {
            soldierRepository.save(soldierEntity);
        } catch (Exception e) {
            throw new ValidationException();
        }
    }

    @Override
    public List<SoldierResponse> getAllSoldiersRelatedToTheDoctor(String username) {
        Credentials credentials = credentialsService.findCredentialsByUsername(username);
        List<Soldier> soldiers;
        if (credentials.getRole().getName().equals("warDoctor")
                || credentials.getRole().getName().equals("tacticalDoctor")) {
            soldiers = soldierRepository.findByBrigade(credentials.getDoctor().getBrigade());
        } else {
            soldiers = soldierRepository.findAll();
        }
        return soldiers.stream().map(soldier -> new SoldierResponse(
                soldier.getBrigade(),
                soldier.getName(),
                soldier.getSurname(),
                soldier.getPatronymic(),
                soldier.getAge(),
                soldier.getInfections(),
                soldier.getGeneralSoldierMedicalInfo().getAllergies(),
                soldier.getGeneralSoldierMedicalInfo().getBloodType(),
                soldier.getNeedsBloodTransfusion())).toList();
    }
}
