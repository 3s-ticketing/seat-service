package org.ticketing.seat.domain.exception;

import org.ticketing.common.exception.BadRequestException;

import java.util.UUID;

public class SeatAlreadyDeletedException extends BadRequestException {

    public SeatAlreadyDeletedException(UUID seatId) {
        super("Seat already deleted: " + seatId);
    }
}