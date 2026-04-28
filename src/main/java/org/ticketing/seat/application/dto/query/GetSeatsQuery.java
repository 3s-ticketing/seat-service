package org.ticketing.seat.application.dto.query;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public record GetSeatsQuery(
        UUID stadiumId,
        UUID seatGradeId,
        String column,
        Pageable pageable
) {
}