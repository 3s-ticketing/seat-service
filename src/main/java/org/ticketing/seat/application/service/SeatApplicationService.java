package org.ticketing.seat.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.seat.application.dto.command.*;
import org.ticketing.seat.application.dto.query.GetSeatsQuery;
import org.ticketing.seat.application.dto.result.*;
import org.ticketing.seat.domain.exception.SeatGradeNotFoundException;
import org.ticketing.seat.domain.exception.StadiumNotFoundException;
import org.ticketing.seat.domain.model.entity.Seat;
import org.ticketing.seat.domain.model.entity.SeatGrade;
import org.ticketing.seat.domain.model.vo.SeatLocation;
import org.ticketing.seat.domain.repository.SeatGradeRepository;
import org.ticketing.seat.domain.repository.SeatRepository;
import org.ticketing.seat.domain.service.StadiumProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeatApplicationService {

    private final SeatRepository seatRepository;
    private final SeatGradeRepository seatGradeRepository;
    private final StadiumProvider stadiumProvider;

    @Transactional
    public void createSeats(CreateSeatsCommand command) {
        if (!stadiumProvider.existsById(command.stadiumId())) {
            throw new StadiumNotFoundException(command.stadiumId());
        }

        List<Seat> seats = command.seats().stream()
                .map(item -> {
                    SeatGrade seatGrade = seatGradeRepository.findById(item.seatGradeId())
                            .orElseThrow(() -> new SeatGradeNotFoundException(item.seatGradeId()));

                    return Seat.create(
                            seatGrade,
                            command.stadiumId(),
                            new SeatLocation(item.column(), item.seatNumber())
                    );
                })
                .toList();

        seatRepository.saveAll(seats);
    }

    @Transactional
    public void bulkCreateSeats(CreateSeatsBulkCommand command) {
        if (!stadiumProvider.existsById(command.stadiumId())) {
            throw new StadiumNotFoundException(command.stadiumId());
        }

        SeatGrade seatGrade = seatGradeRepository.findById(command.seatGradeId())
                .orElseThrow(() -> new SeatGradeNotFoundException(command.seatGradeId()));

        List<Seat> seats = new ArrayList<>();
        for (String column : command.columns()) {
            for (int number = command.startNumber(); number <= command.endNumber(); number++) {
                seats.add(Seat.create(
                        seatGrade,
                        command.stadiumId(),
                        new SeatLocation(column, number)
                ));
            }
        }

        seatRepository.saveAll(seats);
    }

    public GetSeatsResult getSeats(GetSeatsQuery query) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<SeatResult> getSeatsByStadium(UUID stadiumId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public SeatResult getSeat(UUID seatId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Transactional
    public void updateSeatGrade(UpdateSeatGradeCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Transactional
    public void deleteSeat(DeleteSeatCommand command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}