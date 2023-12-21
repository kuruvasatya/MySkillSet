package com.learning.dao;

import com.learning.entity.Attestation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttestationRepository extends JpaRepository<Attestation, Integer> {
}
