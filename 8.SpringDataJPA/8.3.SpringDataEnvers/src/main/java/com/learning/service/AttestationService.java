package com.learning.service;

import com.learning.dto.RevisionResponse;
import com.learning.entity.Attestation;
import com.learning.repository.AttestationRepository;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttestationService {
    private AttestationRepository repo;

    public AttestationService(AttestationRepository attestationRepository) {
        this.repo = attestationRepository;
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

    public Revisions<Integer, Attestation> getAllRevisions(int id) {
       return repo.findRevisions(id);
    }

    public RevisionResponse getHistoricalChanges(int id) {
        Revisions<Integer, Attestation> revisions = repo.findRevisions(id);
        RevisionResponse response = new RevisionResponse();
        response.setId(id);
        List<RevisionResponse.RevisionDetails> revisionDetailsList = new ArrayList<>();
        for (Revision<Integer, Attestation> revision : revisions) {
             RevisionResponse.RevisionDetails revisionDetails = new RevisionResponse().new RevisionDetails();
             Attestation attestation = revision.getEntity();
             revisionDetails.setRevId(revision.getRevisionNumber().get());
             revisionDetails.setIsDatabaseSensitive(attestation.getIsSensitive());
             revisionDetails.setAttestedBy(attestation.getLastModifiedBy());
             revisionDetails.setAttestedDate(attestation.getLastModifiedDate());
             revisionDetailsList.add(revisionDetails);
        }
        response.setRevisionDetailsList(revisionDetailsList);
        return response;
    }
}
