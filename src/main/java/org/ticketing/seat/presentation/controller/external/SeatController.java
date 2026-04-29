package org.ticketing.seat.presentation.controller.external;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.ticketing.seat.application.dto.command.DeleteSeatCommand;
import org.ticketing.seat.application.dto.command.DeleteSeatGradeCommand;
import org.ticketing.seat.application.service.SeatApplicationService;
import org.ticketing.seat.presentation.dto.request.CreateSeatsBulkRequestDto;
import org.ticketing.seat.presentation.dto.request.CreateSeatsRequestDto;
import org.ticketing.seat.presentation.dto.request.UpdateSeatGradeRequestDto;
import org.ticketing.seat.presentation.dto.response.GetSeatsResponseDto;
import org.ticketing.seat.presentation.dto.response.SeatResponseDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatApplicationService seatService;

    /**
     * 좌석 생성
     */
    @PostMapping
    public void createSeats(
            @RequestBody CreateSeatsRequestDto request
    ) {
        seatService.createSeats(request.toCommand());
    }

    /**
     * 좌석 자동 생성 (bulk)
     */
    @PostMapping("/bulk")
    public void bulkCreateSeats(
            @RequestBody CreateSeatsBulkRequestDto request
    ) {
        seatService.bulkCreateSeats(request.toCommand());
    }

    /**
     * 경기장별 좌석 목록 조회
     */
    @GetMapping
    public GetSeatsResponseDto getSeatsByStadium(
            @RequestParam UUID stadiumId,
            @PageableDefault(size = 10, sort = {"location.column", "location.seatNumber"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return GetSeatsResponseDto.from(seatService.getSeatsByStadium(stadiumId, pageable));
    }

    /**
     * 좌석 단건 조회
     */
    @GetMapping("/{seatId}")
    public SeatResponseDto getSeat(
            @PathVariable UUID seatId
    ) {
        return SeatResponseDto.from(seatService.getSeat(seatId));
    }

    /**
     * 좌석 등급 변경
     */
    @PatchMapping("/{seatId}/grade")
    public void updateSeatGrade(
            @PathVariable UUID seatId,
            @RequestBody UpdateSeatGradeRequestDto request
    ) {
        seatService.updateSeatGrade(request.toCommand(seatId));
    }

    /**
     * 좌석 삭제
     */
    @DeleteMapping("/{seatId}")
    public void deleteSeat(
            @PathVariable UUID seatId
    ) {
        seatService.deleteSeat(new DeleteSeatCommand(seatId, "temp"));
    }
}