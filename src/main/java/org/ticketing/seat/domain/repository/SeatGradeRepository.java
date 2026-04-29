package org.ticketing.seat.domain.repository;

import org.ticketing.seat.domain.model.entity.SeatGrade;

import java.util.Optional;
import java.util.UUID;

public interface SeatGradeRepository {

    Optional<SeatGrade> findById(UUID id);

    SeatGrade save(SeatGrade seatGrade);

    boolean existsById(UUID id);
}
