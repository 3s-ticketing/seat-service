package org.ticketing.seat.infrastructure.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.ticketing.seat.domain.service.StadiumProvider;
import org.ticketing.seat.infrastructure.client.StadiumClient;
import org.ticketing.seat.infrastructure.client.dto.StadiumExistsResponse;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StadiumProviderImpl implements StadiumProvider {

    private final StadiumClient stadiumClient;

    @Override
    public boolean existsById(UUID stadiumId) {
        StadiumExistsResponse response = stadiumClient.existsById(stadiumId);

        return response != null && Boolean.FALSE.equals(response.data());
    }
}
