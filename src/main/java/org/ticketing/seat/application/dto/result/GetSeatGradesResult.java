package org.ticketing.seat.application.dto.result;

import java.util.List;

public record GetSeatGradesResult(
        List<SeatGradeResult> seatGrades
) {
}