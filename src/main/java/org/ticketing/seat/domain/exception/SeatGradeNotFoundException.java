package org.ticketing.seat.domain.exception;

import org.ticketing.common.exception.NotFoundException;

import java.util.UUID;

public class SeatGradeNotFoundException extends NotFoundException {

    public SeatGradeNotFoundException(UUID gradeId) {
        super("SeatGrade not found: " + gradeId);
    }
}