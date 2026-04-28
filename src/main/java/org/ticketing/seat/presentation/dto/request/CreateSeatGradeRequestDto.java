package org.ticketing.seat.presentation.dto.request;

import org.ticketing.seat.application.dto.command.CreateSeatGradeCommand;

import java.util.UUID;

public record CreateSeatGradeRequestDto(
        UUID stadiumId,
        String gradeName
) {

    public CreateSeatGradeCommand toCommand() {
        return new CreateSeatGradeCommand(
                stadiumId,
                gradeName
        );
    }
}