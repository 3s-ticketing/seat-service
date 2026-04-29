package org.ticketing.seat.domain.exception;

import java.util.UUID;

public class StadiumNotFoundException extends RuntimeException {

    public StadiumNotFoundException(UUID stadiumId) {
        super("Stadium not found: " + stadiumId);
    }
}
