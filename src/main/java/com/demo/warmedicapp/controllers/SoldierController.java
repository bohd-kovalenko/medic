package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
@RequiredArgsConstructor
public class SoldierController {
    private final SoldierService soldierService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Soldier>> getAllSoldiers() {
        return soldierService.getAllSoldiers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Soldier> getSoldierById(@PathVariable int id) {
        return soldierService.getSoldierById(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addSoldier(@RequestPart("soldier") Soldier soldier,
                                           @RequestPart(value = "images") List<MultipartFile> images) {
        return soldierService.addSoldier(soldier, images);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> editItem(@PathVariable int id,
                                         @RequestPart("soldier") Soldier soldier,
                                         @RequestPart(value = "images", required = false) List<MultipartFile> images) {
        return soldierService.updateSoldierById(id, soldier, images);
    }
}
