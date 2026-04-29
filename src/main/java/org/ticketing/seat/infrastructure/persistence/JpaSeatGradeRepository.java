package org.ticketing.seat.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketing.seat.domain.model.entity.SeatGrade;

import java.util.UUID;

public interface JpaSeatGradeRepository extends JpaRepository<SeatGrade, UUID> {

    boolean existsByIdAndDeletedAtIsNull(UUID id);
}
