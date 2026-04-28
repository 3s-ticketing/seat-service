package org.ticketing.seat.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.ticketing.seat.domain.model.entity.Seat;

import java.util.UUID;

public interface JpaSeatRepository extends CrudRepository<Seat, UUID> {
}
