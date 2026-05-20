package org.ticketing.seat.presentation.dto.response;

import org.ticketing.seat.application.dto.result.GetSeatsResult;
import org.ticketing.seat.application.dto.result.SeatResult;

import java.util.List;

public record GetSeatsResponseDto(
        List<SeatResponseDto> seats,
        int page,
        int size,
        long totalElements,
        int totalPages
) {

    public static GetSeatsResponseDto from(GetSeatsResult result) {
        return new GetSeatsResponseDto(
                result.seats().stream()
                        .map(SeatResponseDto::from)
                        .toList(),
                result.page(),
                result.size(),
                result.totalElements(),
                result.totalPages()
        );
    }
}