package org.ticketing.seat.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.ticketing.seat.domain.model.entity.Seat;
import org.ticketing.seat.domain.repository.SeatRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl implements SeatRepository {

    private final JpaSeatRepository jpaSeatRepository;

    @Override
    public Optional<Seat> findById(UUID id) {
        return jpaSeatRepository.findByIdAndDeletedAtIsNull(id);
    }

    @Override
    public Seat save(Seat seat) {
        return jpaSeatRepository.save(seat);
    }

    @Override
    public void saveAll(List<Seat> seats) {
        jpaSeatRepository.saveAll(seats);
    }

    @Override
    public Page<Seat> findByStadiumId(UUID stadiumId, Pageable pageable) {
        return jpaSeatRepository.findByStadiumIdAndDeletedAtIsNull(stadiumId, pageable);
    }
}
