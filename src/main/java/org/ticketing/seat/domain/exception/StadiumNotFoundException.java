package org.ticketing.seat.domain.exception;

import org.ticketing.common.exception.NotFoundException;

import java.util.UUID;

public class StadiumNotFoundException extends NotFoundException {

    public StadiumNotFoundException(UUID stadiumId) {
        super("Stadium not found: " + stadiumId);
    }
}
