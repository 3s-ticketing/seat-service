package org.ticketing.seat.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.seat.application.dto.command.*;
import org.ticketing.seat.application.dto.result.*;
import org.ticketing.seat.domain.exception.SeatGradeNotFoundException;
import org.ticketing.seat.domain.exception.SeatNotFoundException;
import org.ticketing.seat.domain.exception.StadiumNotFoundException;
import org.ticketing.seat.domain.model.entity.Seat;
import org.ticketing.seat.domain.model.entity.SeatGrade;
import org.ticketing.seat.domain.model.vo.SeatLocation;
import org.ticketing.seat.domain.repository.SeatGradeRepository;
import org.ticketing.seat.domain.repository.SeatRepository;
import org.ticketing.seat.domain.service.StadiumProvider;

import java.util.*;
import java.util.stream.Collectors;

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

        Set<UUID> gradeIds = command.seats().stream()
                .map(CreateSeatsCommand.SeatItem::seatGradeId)
                .collect(Collectors.toSet());

        List<SeatGrade> seatGrades = seatGradeRepository.findAllActiveByIds(gradeIds);

        Map<UUID, SeatGrade> seatGradeMap = seatGrades.stream()
                .collect(Collectors.toMap(SeatGrade::getId, sg -> sg));

        List<Seat> seats = command.seats().stream()
                .map(item -> {
                    SeatGrade seatGrade = seatGradeMap.get(item.seatGradeId());
                    if (seatGrade == null) {
                        throw new SeatGradeNotFoundException(item.seatGradeId());
                    }

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

    @Transactional(readOnly = true)
    public GetSeatsResult getSeatsByStadium(UUID stadiumId, Pageable pageable) {
        Page<Seat> seatPage = seatRepository.findByStadiumId(stadiumId, pageable);
        return GetSeatsResult.from(seatPage);
    }

    @Transactional(readOnly = true)
    public SeatResult getSeat(UUID seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException(seatId));

        return SeatResult.from(seat);
    }

    @Transactional
    public void updateSeatGrade(UpdateSeatGradeCommand command) {
        Seat seat = seatRepository.findById(command.seatId())
                .orElseThrow(() -> new SeatNotFoundException(command.seatId()));

        SeatGrade seatGrade = seatGradeRepository.findById(command.seatGradeId())
                .orElseThrow(() -> new SeatGradeNotFoundException(command.seatGradeId()));

        seat.updateSeatGrade(seatGrade);
    }

    @Transactional
    public void deleteSeat(DeleteSeatCommand command) {
        Seat seat = seatRepository.findById(command.seatId())
                .orElseThrow(() -> new SeatNotFoundException(command.seatId()));

        seat.delete(command.deletedBy().toString());
    }

    @Transactional(readOnly = true)
    public long countSeatsBySeatGradeId(UUID seatGradeId) {
        return seatRepository.countBySeatGradeId(seatGradeId);
    }
}