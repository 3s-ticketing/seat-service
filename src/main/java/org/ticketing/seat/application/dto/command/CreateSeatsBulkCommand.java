package org.ticketing.seat.application.dto.command;

import java.util.List;
import java.util.UUID;

public record CreateSeatsBulkCommand(
        UUID stadiumId,
        UUID seatGradeId,
        List<String> columns,
        Integer startNumber,
        Integer endNumber
) {
}