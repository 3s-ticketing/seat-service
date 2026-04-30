package org.ticketing.seat.application.dto.result;

import org.ticketing.seat.domain.model.entity.SeatGrade;

import java.util.UUID;

public record SeatGradeResult(
        UUID seatGradeId,
        String gradeName
) {
    public static SeatGradeResult from(SeatGrade seatGrade) {
        return new SeatGradeResult(
                seatGrade.getId(),
                seatGrade.getGradeName()
        );
    }
}