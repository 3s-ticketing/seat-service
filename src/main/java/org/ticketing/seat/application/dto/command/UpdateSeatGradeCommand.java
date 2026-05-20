package org.ticketing.seat.application.dto.command;

import java.util.UUID;

public record UpdateSeatGradeCommand(
        UUID seatId,
        UUID seatGradeId
) {
}