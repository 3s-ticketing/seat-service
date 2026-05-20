package org.ticketing.seat.presentation.dto.request;

import org.ticketing.seat.application.dto.command.UpdateSeatGradeCommand;

import java.util.UUID;

public record UpdateSeatGradeRequestDto(
        UUID seatGradeId
) {

    public UpdateSeatGradeCommand toCommand(UUID seatId) {
        return new UpdateSeatGradeCommand(
                seatId,
                seatGradeId
        );
    }
}