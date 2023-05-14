package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.payload.responses.SoldierResponse;
import com.demo.warmedicapp.services.JWTService;
import com.demo.warmedicapp.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequestMapping("/doctor/soldiers")
@RequiredArgsConstructor
public class DoctorController {
    private final SoldierService soldierService;
    private final JWTService jwtService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SoldierResponse>> getAllSoldiersRelatedToTheDoctor(@CookieValue("tokenCookie") String token) {
        return new ResponseEntity<>(soldierService.getAllSoldiersRelatedToTheDoctor(jwtService.extractUsername(token)),
                HttpStatus.OK);
    }
}
