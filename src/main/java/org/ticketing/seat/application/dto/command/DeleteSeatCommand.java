package org.ticketing.seat.application.dto.command;

import java.util.UUID;

public record DeleteSeatCommand(
        UUID seatId,
        UUID deletedBy
) {
}