package org.ticketing.seat.domain.model.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ticketing.common.exception.BadRequestException;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatLocation {

    @Column(name = "seat_column", nullable = false, length = 10)
    private String column;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    public SeatLocation(String column, Integer seatNumber) {
        validate(column, seatNumber);
        this.column = column;
        this.seatNumber = seatNumber;
    }

    private void validate(String column, Integer seatNumber) {
        if (column == null || column.isBlank()) {
            throw new BadRequestException("column is required");
        }

        if (column.length() > 10) {
            throw new BadRequestException("column max length is 10");
        }

        if (seatNumber == null || seatNumber <= 0) {
            throw new BadRequestException("seatNumber must be positive");
        }
    }

    public String label() {
        return column + "-" + seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeatLocation that)) return false;
        return Objects.equals(column, that.column)
                && Objects.equals(seatNumber, that.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, seatNumber);
    }
}