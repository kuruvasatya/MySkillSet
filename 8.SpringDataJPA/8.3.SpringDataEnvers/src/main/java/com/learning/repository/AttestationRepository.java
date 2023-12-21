package com.learning.repository;

import com.learning.entity.Attestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface AttestationRepository extends RevisionRepository<Attestation, Integer, Integer>, JpaRepository<Attestation, Integer>{
}
