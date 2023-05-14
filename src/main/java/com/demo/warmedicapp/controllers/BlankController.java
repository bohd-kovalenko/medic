package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.payload.requests.BlankRequest;
import com.demo.warmedicapp.payload.responses.BlankResponse;
import com.demo.warmedicapp.services.BlankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequestMapping("/soldiers")
@RequiredArgsConstructor
public class BlankController {
    private final BlankService blankService;

    @GetMapping("/{id}/blank")
    public ResponseEntity<BlankResponse> getAllNotesBySoldierId(@PathVariable int id) {
        BlankResponse blankResponses = blankService.getBlankResponsesBySoldierId(id);

        return new ResponseEntity<>(blankResponses, HttpStatus.OK);
    }

    @PostMapping("/{id}/blank")
    public ResponseEntity<List<Void>> addBlankBySoldierId(@PathVariable int id,
                                                          @RequestBody BlankRequest blankRequest) {
        blankService.addBlankResponseBySoldierId(id, blankRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
