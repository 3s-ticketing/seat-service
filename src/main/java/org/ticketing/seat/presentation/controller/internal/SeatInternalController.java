package org.ticketing.seat.presentation.controller.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.ticketing.seat.application.service.SeatApplicationService;
import org.ticketing.seat.application.service.SeatGradeApplicationService;
import org.ticketing.seat.presentation.dto.response.GetSeatGradesResponseDto;
import org.ticketing.seat.presentation.dto.response.GetSeatsResponseDto;
import org.ticketing.seat.presentation.dto.response.SeatGradeResponseDto;
import org.ticketing.seat.presentation.dto.response.SeatResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal")
public class SeatInternalController {

    private final SeatApplicationService seatService;
    private final SeatGradeApplicationService seatGradeService;

    @GetMapping("/seats")
    public GetSeatsResponseDto getSeatsByStadium(
            @RequestParam UUID stadiumId,
            @PageableDefault(size = 10, sort = {"location.column", "location.seatNumber"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return GetSeatsResponseDto.from(seatService.getSeatsByStadium(stadiumId, pageable));
    }

    @GetMapping("/seat-grades/{stadiumId}")
    public GetSeatGradesResponseDto getSeatGradesByStadium(
            @PathVariable UUID stadiumId
    ) {
        return GetSeatGradesResponseDto.from(
                seatGradeService.getSeatGrades(stadiumId)
        );
    }

    @GetMapping("/seat-grades/{seatGradeId}/exists")
    public boolean existsSeatGrade(@PathVariable UUID seatGradeId) {
        return seatGradeService.existsSeatGrade(seatGradeId);
    }
}