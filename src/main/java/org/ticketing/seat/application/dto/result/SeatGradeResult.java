package org.ticketing.seat.application.dto.result;

import java.util.UUID;

public record SeatGradeResult(
        UUID seatGradeId,
        String gradeName
) {
}