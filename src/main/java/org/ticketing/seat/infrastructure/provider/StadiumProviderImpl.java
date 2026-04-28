package org.ticketing.seat.infrastructure.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.ticketing.seat.domain.service.StadiumProvider;
import org.ticketing.seat.infrastructure.client.StadiumClient;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StadiumProviderImpl implements StadiumProvider {

    private final StadiumClient stadiumClient;

    @Override
    public boolean existsById(UUID stadiumId) {
        return stadiumClient.existsById(stadiumId);
    }
}
