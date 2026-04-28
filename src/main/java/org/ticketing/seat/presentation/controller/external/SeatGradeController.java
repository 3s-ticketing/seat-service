package org.ticketing.seat.presentation.controller.external;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ticketing.seat.application.dto.command.DeleteSeatGradeCommand;
import org.ticketing.seat.application.service.SeatApplicationService;
import org.ticketing.seat.application.service.SeatGradeApplicationService;
import org.ticketing.seat.presentation.dto.request.CreateSeatGradeRequestDto;
import org.ticketing.seat.presentation.dto.request.UpdateSeatGradeNameRequestDto;
import org.ticketing.seat.presentation.dto.response.GetSeatGradesResponseDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seat-grades")
public class SeatGradeController {

    private final SeatGradeApplicationService seatGradeService;

    /**
     * 좌석 등급 생성
     */
    @PostMapping
    public void createSeatGrade(
            @RequestBody CreateSeatGradeRequestDto request
    ) {
        seatGradeService.createSeatGrade(request.toCommand());
    }

    /**
     * 좌석 등급명 수정
     */
    @PatchMapping("/{seatGradeId}")
    public void updateSeatGradeName(
            @PathVariable UUID seatGradeId,
            @RequestBody UpdateSeatGradeNameRequestDto request
    ) {
        seatGradeService.updateSeatGradeName(request.toCommand(seatGradeId));
    }

    /**
     * 좌석 등급 삭제
     */
    @DeleteMapping("/{seatGradeId}")
    public void deleteSeatGrade(
            @PathVariable UUID seatGradeId
    ) {
        seatGradeService.deleteSeatGrade(new DeleteSeatGradeCommand(seatGradeId, "temp"));
    }

    /**
     * 경기장 좌석 등급 목록 조회
     */
    @GetMapping("/{stadiumId}")
    public GetSeatGradesResponseDto getSeatGrades(
            @PathVariable UUID stadiumId
    ) {
        return GetSeatGradesResponseDto.from(
                seatGradeService.getSeatGrades(stadiumId)
        );
    }
}
