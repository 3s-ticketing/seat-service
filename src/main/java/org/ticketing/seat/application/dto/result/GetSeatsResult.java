package org.ticketing.seat.application.dto.result;

import org.springframework.data.domain.Page;
import org.ticketing.seat.domain.model.entity.Seat;

import java.util.List;

public record GetSeatsResult(
        List<SeatResult> seats,
        int page,
        int size,
        long totalElements,
        int totalPages
) {
    public static GetSeatsResult from(Page<Seat> seatPage) {
        List<SeatResult> seats = seatPage.getContent().stream()
                .map(SeatResult::from)
                .toList();

        return new GetSeatsResult(
                seats,
                seatPage.getNumber(),
                seatPage.getSize(),
                seatPage.getTotalElements(),
                seatPage.getTotalPages()
        );
    }
}