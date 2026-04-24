package org.ticketing.seat.application.dto.command;

import java.util.UUID;

public record CreateSeatGradeCommand(
        UUID stadiumId,
        String gradeName
) {
}