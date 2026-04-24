package org.ticketing.seat.presentation.dto.request;

import org.ticketing.seat.application.dto.command.CreateSeatsBulkCommand;

import java.util.List;
import java.util.UUID;

public record CreateSeatsBulkRequestDto(
        UUID stadiumId,
        UUID seatGradeId,
        List<String> columns,
        Integer startNumber,
        Integer endNumber
) {

    public CreateSeatsBulkCommand toCommand() {
        return new CreateSeatsBulkCommand(
                stadiumId,
                seatGradeId,
                columns,
                startNumber,
                endNumber
        );
    }
}