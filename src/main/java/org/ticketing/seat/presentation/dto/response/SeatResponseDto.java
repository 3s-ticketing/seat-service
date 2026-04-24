package org.ticketing.seat.presentation.dto.response;

import org.ticketing.seat.application.dto.result.SeatResult;

import java.util.UUID;

public record SeatResponseDto(
        UUID seatId,
        UUID stadiumId,
        String column,
        Integer seatNumber,
        UUID seatGradeId,
        String gradeName
) {

    public static SeatResponseDto from(SeatResult result) {
        return new SeatResponseDto(
                result.seatId(),
                result.stadiumId(),
                result.column(),
                result.seatNumber(),
                result.seatGradeId(),
                result.gradeName()
        );
    }
}