package org.ticketing.seat.application.dto.command;

import java.util.UUID;

public record DeleteSeatGradeCommand(
        UUID seatGradeId,
        UUID deletedBy
) {
}