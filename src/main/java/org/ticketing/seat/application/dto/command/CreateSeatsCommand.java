package org.ticketing.seat.application.dto.command;

import java.util.List;
import java.util.UUID;

public record CreateSeatsCommand(
        UUID stadiumId,
        List<SeatItem> seats
) {

    public record SeatItem(
            String column,
            Integer seatNumber,
            UUID seatGradeId
    ) {}
}