package org.ticketing.seat.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.seat.application.dto.command.CreateSeatGradeCommand;
import org.ticketing.seat.application.dto.command.DeleteSeatGradeCommand;
import org.ticketing.seat.application.dto.command.UpdateSeatGradeNameCommand;
import org.ticketing.seat.application.dto.result.GetSeatGradesResult;
import org.ticketing.seat.application.dto.result.SeatGradeResult;
import org.ticketing.seat.domain.exception.SeatGradeNotFoundException;
import org.ticketing.seat.domain.exception.StadiumNotFoundException;
import org.ticketing.seat.domain.model.entity.SeatGrade;
import org.ticketing.seat.domain.repository.SeatGradeRepository;
import org.ticketing.seat.domain.service.StadiumProvider;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeatGradeApplicationService {

    private final SeatGradeRepository seatGradeRepository;
    private final StadiumProvider stadiumProvider;

    @Transactional
    public SeatGradeResult createSeatGrade(CreateSeatGradeCommand command) {
        if (!stadiumProvider.existsById(command.stadiumId())) {
            throw new StadiumNotFoundException(command.stadiumId());
        }

        SeatGrade seatGrade = SeatGrade.create(command.gradeName(), command.stadiumId());

        return SeatGradeResult.from(seatGradeRepository.save(seatGrade));
    }

    @Transactional
    public void updateSeatGradeName(UpdateSeatGradeNameCommand command) {
        SeatGrade seatGrade = seatGradeRepository.findById(command.seatGradeId())
                .orElseThrow(() -> new SeatGradeNotFoundException(command.seatGradeId()));

        seatGrade.updateName(command.gradeName());
    }

    @Transactional
    public void deleteSeatGrade(DeleteSeatGradeCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Transactional(readOnly = true)
    public GetSeatGradesResult getSeatGrades(UUID stadiumId) {
        if (!stadiumProvider.existsById(stadiumId)) {
            throw new StadiumNotFoundException(stadiumId);
        }

        List<SeatGrade> seatGrades = seatGradeRepository.findByStadiumIdOrderByNameAsc(stadiumId);

        return GetSeatGradesResult.from(seatGrades);
    }

    public boolean existsSeatGrade(UUID seatGradeId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
