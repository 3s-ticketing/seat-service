package org.ticketing.seat.presentation.dto.request;

import org.ticketing.seat.application.dto.command.CreateSeatsCommand;

import java.util.List;
import java.util.UUID;

public record CreateSeatsRequestDto(
        UUID stadiumId,
        List<SeatCreateItem> seats
) {

    public CreateSeatsCommand toCommand() {
        return new CreateSeatsCommand(
                stadiumId,
                seats.stream()
                        .map(seat -> new CreateSeatsCommand.SeatItem(
                                seat.column(),
                                seat.seatNumber(),
                                seat.seatGradeId()
                        ))
                        .toList()
        );
    }

    public record SeatCreateItem(
            String column,
            Integer seatNumber,
            UUID seatGradeId
    ) {}
}