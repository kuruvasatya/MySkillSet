package com.learning.service;

import com.learning.dao.AttestationRepository;
import com.learning.entity.Attestation;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AttestationService {
    private AttestationRepository repo;
    public AttestationService(AttestationRepository repo) {
        this.repo = repo;
    }

    public Attestation saveAttestation(Attestation attestation) {
        System.out.println(attestation);
        return repo.save(attestation);
    }

    public Attestation updateAttestation(int id, Attestation attestation) {
        Attestation old = repo.findById(id).get();
        if(old != null) {
            old.setIsSensitive(attestation.getIsSensitive());
        } else {
            throw new RuntimeException("Attestation with id : " + id + " is not found");
        }
        return repo.save(old);
    }

    public List<Attestation> getAllAttestations() {
        return repo.findAll();
    }
}
