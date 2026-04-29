package org.ticketing.seat.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.ticketing.seat.domain.model.entity.Seat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeatRepository {

    Optional<Seat> findById(UUID id);

    Seat save(Seat seat);

    void saveAll(List<Seat> seats);
}
