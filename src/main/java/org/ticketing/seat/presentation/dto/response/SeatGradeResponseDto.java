package org.ticketing.seat.presentation.dto.response;

import org.ticketing.seat.application.dto.result.SeatGradeResult;

import java.util.UUID;

public record SeatGradeResponseDto(
        UUID seatGradeId,
        String gradeName
) {

    public static SeatGradeResponseDto from(SeatGradeResult result) {
        return new SeatGradeResponseDto(
                result.seatGradeId(),
                result.gradeName()
        );
    }
}