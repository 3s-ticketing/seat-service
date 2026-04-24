package org.ticketing.seat.domain.model.entity;

import jakarta.persistence.*;
import jakarta.ws.rs.BadRequestException;
import lombok.*;
import org.ticketing.common.domain.BaseEntity;
import org.ticketing.seat.domain.exception.SeatAlreadyDeletedException;
import org.ticketing.seat.domain.model.vo.SeatLocation;

import java.util.UUID;

@Entity
@Table(name = "p_seat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_grade_id", nullable = false)
    private SeatGrade seatGrade;

    @Column(name = "stadium_id", nullable = false)
    private UUID stadiumId;

    @Embedded
    private SeatLocation location;

    @Builder(access = AccessLevel.PRIVATE)
    private Seat(SeatGrade seatGrade, UUID stadiumId, SeatLocation location) {
        validate(seatGrade, stadiumId, location);
        this.seatGrade = seatGrade;
        this.stadiumId = stadiumId;
        this.location = location;
    }

    public static Seat create(SeatGrade seatGrade, UUID stadiumId, SeatLocation location) {
        return Seat.builder()
                .seatGrade(seatGrade)
                .stadiumId(stadiumId)
                .location(location)
                .build();
    }

    public void updateSeatGrade(SeatGrade seatGrade) {
        if (seatGrade == null) {
            throw new BadRequestException("seatGrade is required");
        }
        this.seatGrade = seatGrade;
    }

    public void delete(String deletedBy) {
        ensureNotDeleted();
        super.delete(deletedBy);
    }

    private void validate(SeatGrade seatGrade, UUID stadiumId, SeatLocation location) {
        if (seatGrade == null) {
            throw new BadRequestException("seatGrade is required");
        }
        if (stadiumId == null) {
            throw new BadRequestException("stadiumId is required");
        }
        if (location == null) {
            throw new BadRequestException("seat location is required");
        }
    }

    private void ensureNotDeleted() {
        if (this.deletedAt != null) {
            throw new SeatAlreadyDeletedException(this.id);
        }
    }
}