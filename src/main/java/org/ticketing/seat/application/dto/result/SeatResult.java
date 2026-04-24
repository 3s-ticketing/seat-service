package org.ticketing.seat.application.dto.result;

import java.util.UUID;

public record SeatResult(
        UUID seatId,
        UUID stadiumId,
        String column,
        Integer seatNumber,
        UUID seatGradeId,
        String gradeName
) {
}
