package org.ticketing.seat.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.seat.application.dto.command.*;
import org.ticketing.seat.application.dto.query.GetSeatsQuery;
import org.ticketing.seat.application.dto.result.*;
import org.ticketing.seat.domain.model.entity.Seat;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeatApplicationService {

    // TODO: repository 주입
    // private final SeatRepository seatRepository;
    // private final SeatGradeRepository seatGradeRepository;

    /**
     * 좌석 생성
     */
    @Transactional
    public void createSeats(CreateSeatsCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 자동 생성
     */
    @Transactional
    public void bulkCreateSeats(CreateSeatsBulkCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 목록 조회
     */
    public GetSeatsResult getSeats(GetSeatsQuery query) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<SeatResult> getSeatsByStadium(UUID stadiumId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 단건 조회
     */
    public SeatResult getSeat(UUID seatId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 등급 변경
     */
    @Transactional
    public void updateSeatGrade(UpdateSeatGradeCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 삭제 (soft delete)
     */
    @Transactional
    public void deleteSeat(DeleteSeatCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 등급 생성
     */
    @Transactional
    public void createSeatGrade(CreateSeatGradeCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 등급명 수정
     */
    @Transactional
    public void updateSeatGradeName(UpdateSeatGradeNameCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 등급 삭제
     */
    @Transactional
    public void deleteSeatGrade(DeleteSeatGradeCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 경기장 좌석 등급 목록 조회
     */
    public GetSeatGradesResult getSeatGrades(UUID stadiumId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 좌석 등급 존재 여부 (internal API)
     */
    public boolean existsSeatGrade(UUID seatGradeId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}