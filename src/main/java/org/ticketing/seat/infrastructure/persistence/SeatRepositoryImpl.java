package org.ticketing.seat.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ticketing.seat.domain.model.entity.Seat;
import org.ticketing.seat.domain.repository.SeatRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl implements SeatRepository {

    private final JpaSeatRepository jpaSeatRepository;

    @Override
    public Seat save(Seat seat) {
        return jpaSeatRepository.save(seat);
    }

    @Override
    public void saveAll(List<Seat> seats) {
        jpaSeatRepository.saveAll(seats);
    }
}
