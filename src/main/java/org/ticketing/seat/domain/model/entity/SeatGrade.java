package org.ticketing.seat.domain.model.entity;

import jakarta.persistence.*;
import jakarta.ws.rs.BadRequestException;
import lombok.*;
import org.ticketing.common.domain.BaseEntity;
import org.ticketing.seat.domain.exception.SeatAlreadyDeletedException;

import java.util.UUID;

@Entity
@Table(name = "p_seat_grade")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatGrade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "grade_name", nullable = false, length = 50)
    private String gradeName;

    @Column(name = "stadium_id", nullable = false)
    private UUID stadiumId;

    @Builder(access = AccessLevel.PRIVATE)
    private SeatGrade(String gradeName, UUID stadiumId) {
        validate(gradeName, stadiumId);
        this.gradeName = gradeName;
        this.stadiumId = stadiumId;
    }

    public static SeatGrade create(String gradeName, UUID stadiumId) {
        return SeatGrade.builder()
                .gradeName(gradeName)
                .stadiumId(stadiumId)
                .build();
    }

    public void updateName(String gradeName) {
        validateName(gradeName);
        this.gradeName = gradeName;
    }

    public void delete(String deletedBy) {
        ensureNotDeleted();
        super.delete(deletedBy);
    }

    private void validate(String gradeName, UUID stadiumId) {
        validateName(gradeName);

        if (stadiumId == null) {
            throw new BadRequestException("stadiumId is required");
        }
    }

    private void validateName(String gradeName) {
        if (gradeName == null || gradeName.isBlank()) {
            throw new BadRequestException("gradeName is required");
        }

        if (gradeName.length() > 50) {
            throw new BadRequestException("gradeName max length is 50");
        }
    }

    private void ensureNotDeleted() {
        if (this.deletedAt != null) {
            throw new SeatAlreadyDeletedException(this.id);
        }
    }
}