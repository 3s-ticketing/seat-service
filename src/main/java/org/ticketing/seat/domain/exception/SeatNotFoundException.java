package org.ticketing.seat.domain.exception;

import org.ticketing.common.exception.NotFoundException;

import java.util.UUID;

public class SeatNotFoundException extends NotFoundException {

    public SeatNotFoundException(UUID seatId) {
        super("Seat not found: " + seatId);
    }
}