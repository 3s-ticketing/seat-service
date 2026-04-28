package org.ticketing.seat.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ticketing.seat.domain.repository.SeatRepository;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl implements SeatRepository {

    private final JpaSeatRepository jpaSeatRepository;

}
