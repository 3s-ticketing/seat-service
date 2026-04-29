package org.ticketing.seat.application.dto.result;

import org.ticketing.seat.domain.model.entity.SeatGrade;

import java.util.List;

public record GetSeatGradesResult(
        List<SeatGradeResult> seatGrades
) {
    public static GetSeatGradesResult from(List<SeatGrade> seatGrades) {
        return new GetSeatGradesResult(
                seatGrades.stream()
                        .map(SeatGradeResult::from)
                        .toList()
        );
    }
}