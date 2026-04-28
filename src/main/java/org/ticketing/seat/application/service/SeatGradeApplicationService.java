package org.ticketing.seat.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.seat.application.dto.command.CreateSeatGradeCommand;
import org.ticketing.seat.application.dto.command.DeleteSeatGradeCommand;
import org.ticketing.seat.application.dto.command.UpdateSeatGradeNameCommand;
import org.ticketing.seat.application.dto.result.GetSeatGradesResult;
import org.ticketing.seat.domain.repository.SeatGradeRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeatGradeApplicationService {

    // TODO: repository 주입
    // private final SeatGradeRepository seatGradeRepository;

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
