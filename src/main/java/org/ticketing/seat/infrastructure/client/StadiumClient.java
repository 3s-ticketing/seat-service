package org.ticketing.seat.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.ticketing.seat.infrastructure.client.dto.StadiumExistsResponse;

import java.util.UUID;

@FeignClient(name = "club-service", path = "/internal/stadiums")
public interface StadiumClient {

    @GetMapping("/{stadiumId}/exists")
    StadiumExistsResponse existsById(@PathVariable("stadiumId") UUID stadiumId);
}