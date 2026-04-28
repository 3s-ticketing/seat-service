package org.ticketing.seat.domain.service;

import java.util.UUID;

public interface StadiumProvider {
    boolean existsById(UUID stadiumId);
}
