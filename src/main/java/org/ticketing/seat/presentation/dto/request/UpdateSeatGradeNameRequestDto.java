package org.ticketing.seat.presentation.dto.request;

import org.ticketing.seat.application.dto.command.UpdateSeatGradeNameCommand;

import java.util.UUID;

public record UpdateSeatGradeNameRequestDto(
        String gradeName
) {

    public UpdateSeatGradeNameCommand toCommand(UUID seatGradeId) {
        return new UpdateSeatGradeNameCommand(
                seatGradeId,
                gradeName
        );
    }
}