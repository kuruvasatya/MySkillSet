package com.learning.security;


import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.Random;

public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String currentUser = "User" + new Random().nextInt(1, 100);
        return Optional.of(currentUser);
    }
}
