package org.ticketing.seat.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ticketing.seat.domain.model.entity.SeatGrade;
import org.ticketing.seat.domain.repository.SeatGradeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SeatGradeRepositoryImpl implements SeatGradeRepository {

    private final JpaSeatGradeRepository jpaSeatGradeRepository;

    @Override
    public Optional<SeatGrade> findById(UUID id) {
        return jpaSeatGradeRepository.findById(id);
    }

    @Override
    public SeatGrade save(SeatGrade seatGrade) {
        return jpaSeatGradeRepository.save(seatGrade);
    }

    @Override
    public boolean existsById(UUID id) {
        return jpaSeatGradeRepository.existsByIdAndDeletedAtIsNull(id);
    }

    @Override
    public List<SeatGrade> findByStadiumIdOrderByNameAsc(UUID stadiumId) {
        return jpaSeatGradeRepository.findByStadiumIdAndDeletedAtIsNullOrderByGradeNameAsc(stadiumId);
    }
}
