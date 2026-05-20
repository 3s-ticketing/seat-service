package org.ticketing.seat.presentation.dto.response;

import org.ticketing.seat.application.dto.result.GetSeatGradesResult;

import java.util.List;

public record GetSeatGradesResponseDto(
        List<SeatGradeResponseDto> seatGrades
) {

    public static GetSeatGradesResponseDto from(GetSeatGradesResult result) {
        return new GetSeatGradesResponseDto(
                result.seatGrades().stream()
                        .map(SeatGradeResponseDto::from)
                        .toList()
        );
    }
}