package org.ticketing.seat.infrastructure.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketing.seat.domain.model.entity.Seat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaSeatRepository extends JpaRepository<Seat, UUID> {

    Optional<Seat> findByIdAndDeletedAtIsNull(UUID id);

    @EntityGraph(attributePaths = "seatGrade")
    Page<Seat> findByStadiumIdAndDeletedAtIsNull(UUID stadiumId, Pageable pageable);

    long countBySeatGradeIdAndDeletedAtIsNull(UUID seatGradeId);
}
