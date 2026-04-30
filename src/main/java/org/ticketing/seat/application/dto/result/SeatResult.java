package org.ticketing.seat.application.dto.result;

import org.ticketing.seat.domain.model.entity.Seat;

import java.util.UUID;

public record SeatResult(
        UUID seatId,
        UUID stadiumId,
        String column,
        Integer seatNumber,
        UUID seatGradeId,
        String gradeName
) {
    public static SeatResult from(Seat seat) {
        return new SeatResult(
                seat.getId(),
                seat.getStadiumId(),
                seat.getLocation().getColumn(),
                seat.getLocation().getSeatNumber(),
                seat.getSeatGrade().getId(),
                seat.getSeatGrade().getGradeName()
        );
    }
}
