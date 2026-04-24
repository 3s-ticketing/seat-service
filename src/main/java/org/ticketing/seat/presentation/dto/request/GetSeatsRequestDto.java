package org.ticketing.seat.presentation.dto.request;

import org.springframework.data.domain.Pageable;
import org.ticketing.seat.application.dto.query.GetSeatsQuery;

import java.util.UUID;

public record GetSeatsRequestDto(
        UUID stadiumId,
        UUID seatGradeId,
        String column
) {

    public GetSeatsQuery toQuery(Pageable pageable) {
        return new GetSeatsQuery(
                stadiumId,
                seatGradeId,
                column,
                pageable
        );
    }
}