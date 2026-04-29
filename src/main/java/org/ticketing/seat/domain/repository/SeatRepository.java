package org.ticketing.seat.domain.repository;

import org.ticketing.seat.domain.model.entity.Seat;

import java.util.List;

public interface SeatRepository {
    Seat save(Seat seat);
    void saveAll(List<Seat> seats);
}
