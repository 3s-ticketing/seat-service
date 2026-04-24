package org.ticketing.seat.presentation.controller.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ticketing.seat.application.service.SeatApplicationService;
import org.ticketing.seat.presentation.dto.response.SeatGradeResponseDto;
import org.ticketing.seat.presentation.dto.response.SeatResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal")
public class SeatInternalController {

    private final SeatApplicationService seatService;

    @GetMapping("/seats/{stadiumId}")
    public List<SeatResponseDto> getSeatsByStadium(
            @PathVariable UUID stadiumId
    ) {
        return seatService.getSeatsByStadium(stadiumId)
                .stream()
                .map(SeatResponseDto::from)
                .toList();
    }

    @GetMapping("/seat-grades/{stadiumId}")
    public List<SeatGradeResponseDto> getSeatGradesByStadium(
            @PathVariable UUID stadiumId
    ) {
        return seatService.getSeatGrades(stadiumId)
                .seatGrades()
                .stream()
                .map(SeatGradeResponseDto::from)
                .toList();
    }

    @GetMapping("/seat-grades/{seatGradeId}/exists")
    public boolean existsSeatGrade(@PathVariable UUID seatGradeId) {
        return seatService.existsSeatGrade(seatGradeId);
    }
}