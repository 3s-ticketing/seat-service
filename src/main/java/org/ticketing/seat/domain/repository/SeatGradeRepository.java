package org.ticketing.seat.domain.repository;

import org.ticketing.seat.domain.model.entity.SeatGrade;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface SeatGradeRepository {

    Optional<SeatGrade> findById(UUID id);

    SeatGrade save(SeatGrade seatGrade);

    boolean existsById(UUID id);

    List<SeatGrade> findByStadiumIdOrderByNameAsc(UUID stadiumId);

    List<SeatGrade> findAllActiveByIds(Set<UUID> gradeIds);
}
