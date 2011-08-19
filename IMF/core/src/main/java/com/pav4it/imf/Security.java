package com.pav4it.imf;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Andrey Popov creates on 28.07.11 (12:39)
 */
@Entity
@Table(name = "security")
public class Security extends BaseEntity {
    @Column(name = "uuid", unique = true)
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
