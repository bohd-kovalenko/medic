package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.exceptions.ValidationException;
import com.demo.warmedicapp.repositories.SoldierRepository;
import com.demo.warmedicapp.services.ImageService;
import com.demo.warmedicapp.services.SoldierService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SoldierServiceImpl implements SoldierService {
    private final SoldierRepository soldierRepository;

    private final ImageService imageService;

    @Override
    public ResponseEntity<List<Soldier>> getAllSoldiers() {
        List<Soldier> allRooms = soldierRepository.findAll();

        return new ResponseEntity<>(allRooms, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Soldier> getSoldierById(Integer id) {
        Soldier room = soldierRepository
                .findById(id)
                .orElseThrow(() -> new UnexistingSoldierException(id));

        return new ResponseEntity<>(room, HttpStatus.OK);
    }


    @Override
    @Transactional
    public ResponseEntity<Void> addSoldier(Soldier soldier, List<MultipartFile> images) {
        try {
            soldier = soldierRepository.save(soldier);
        } catch (Exception e) {
            throw new ValidationException();
        }

        imageService.saveAllImages(images, soldier.getId());


        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> updateSoldierById(Integer id, Soldier soldier, List<MultipartFile> images) {
        Soldier soldierEntity = soldierRepository.findById(id).orElseThrow(() -> new UnexistingSoldierException(id));

        soldier.setId(soldierEntity.getId());

        try {
            soldierRepository.save(soldier);
        } catch (Exception e) {
            throw new ValidationException();
        }

        if (images != null) {
            imageService.deleteAllImagesBySoldierId(id);
            imageService.saveAllImages(images, id);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    public ResponseEntity<Void> addSoldier(Soldier soldier) {
//        try {
//            roomRepository.save(room);
//        } catch (Exception e) {
//            throw new RoomAlreadyExistsException(room.getIdentifier());
//        }
//
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
}
