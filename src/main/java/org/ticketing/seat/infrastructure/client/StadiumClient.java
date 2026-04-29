package org.ticketing.seat.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "club-service")
public interface StadiumClient {

    @GetMapping("/internal/stadiums/{stadiumId}/exists")
    boolean existsById(@PathVariable("stadiumId") UUID stadiumId);
}