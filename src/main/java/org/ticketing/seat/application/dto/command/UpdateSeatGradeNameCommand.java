package org.ticketing.seat.application.dto.command;

import java.util.UUID;

public record UpdateSeatGradeNameCommand(
        UUID seatGradeId,
        String gradeName
) {
}