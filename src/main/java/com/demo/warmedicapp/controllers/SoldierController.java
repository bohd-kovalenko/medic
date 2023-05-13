package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
@RequiredArgsConstructor
public class SoldierController {
    private final SoldierService soldierService;

    @GetMapping
    public ResponseEntity<List<Soldier>> searchSoldiers(@RequestParam(required = false) String search) {
        List<Soldier> soldiers;

        if (search != null) {
            soldiers = soldierService.searchSoldiers(search);
        } else {
            soldiers = soldierService.getAllSoldiers();
        }

        return new ResponseEntity<>(soldiers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soldier> getSoldierById(@PathVariable int id) {
        Soldier soldier = soldierService.getSoldierById(id);
        return new ResponseEntity<>(soldier, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> addSoldier(@RequestBody Soldier soldier) {
        soldierService.addSoldier(soldier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editItem(@PathVariable int id,
                                         @RequestBody Soldier soldier) {
        soldierService.updateSoldierById(id, soldier);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
