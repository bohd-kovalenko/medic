package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
@RequiredArgsConstructor
public class SoldierController {
    private final SoldierService soldierService;

    @GetMapping
    public ResponseEntity<List<Soldier>> getAllSoldiers() {
        return soldierService.getAllSoldiers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soldier> getSoldierById(@PathVariable int id) {
        return soldierService.getSoldierById(id);
    }

    @PostMapping()
    public ResponseEntity<Void> addSoldier(@RequestPart("soldier") Soldier soldier) {
        return soldierService.addSoldier(soldier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editItem(@PathVariable int id,
                                         @RequestPart("soldier") Soldier soldier) {
        return soldierService.updateSoldierById(id, soldier);
    }
}
