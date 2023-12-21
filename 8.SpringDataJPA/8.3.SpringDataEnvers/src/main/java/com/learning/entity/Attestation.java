package com.learning.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.type.NumericBooleanConverter;

@Data
@NoArgsConstructor
@Entity
@Table(name="Database_attestation1")
@Audited
public class Attestation extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String databaseName;
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isSensitive;

    public Attestation(String databaseName, Boolean isSensitive) {
        this.databaseName = databaseName;
        this.isSensitive = isSensitive;
    }
}
