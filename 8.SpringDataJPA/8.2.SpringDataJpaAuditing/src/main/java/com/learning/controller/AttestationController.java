package com.learning.controller;

import com.learning.entity.Attestation;
import com.learning.service.AttestationService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class AttestationController {
    private AttestationService service;

    public AttestationController(AttestationService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Attestation createAtteation(@RequestBody Attestation attestation) {
        return service.saveAttestation(attestation);
    }

    @PutMapping("/update/{id}")
    public Attestation updateAttestation(@PathVariable("id") int id, @RequestBody Attestation attestation) {
        return service.updateAttestation(id, attestation);
    }

    @GetMapping("/read")
    public List<Attestation> printAttestations() {
        return service.getAllAttestations();
    }
}
