package org.ticketing.seat.application.dto.result;

import java.util.List;

public record GetSeatsResult(
        List<SeatResult> seats,
        int page,
        int size,
        long totalElements,
        int totalPages
) {
}