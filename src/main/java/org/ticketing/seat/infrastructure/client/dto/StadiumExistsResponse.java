package org.ticketing.seat.infrastructure.client.dto;

public record StadiumExistsResponse (
    boolean success,
    String message,
    Boolean data,
    String traceId
) {
}
