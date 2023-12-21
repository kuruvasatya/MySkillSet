package com.learning.controller;

import com.learning.dto.RevisionResponse;
import com.learning.entity.Attestation;
import com.learning.service.AttestationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttestationController {

    private AttestationService service;

    public AttestationController(AttestationService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Attestation createAttestation(@RequestBody Attestation attestation) {
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

    @GetMapping("/revisions/{id}")
    public RevisionResponse getAllRevisions(@PathVariable int id) {
        return service.getHistoricalChanges(id);
    }
}
