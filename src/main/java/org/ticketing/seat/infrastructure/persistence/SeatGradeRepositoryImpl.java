package org.ticketing.seat.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ticketing.seat.domain.repository.SeatGradeRepository;

@Repository
@RequiredArgsConstructor
public class SeatGradeRepositoryImpl implements SeatGradeRepository {

    private final JpaSeatGradeRepository jpaSeatGradeRepository;
}
