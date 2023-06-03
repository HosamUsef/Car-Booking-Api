package com.firstapi.Car;

import java.math.BigDecimal;

public record CarRegistrationRequest(
        String regNumber, BigDecimal rentalPricePerDay, Brand brand, boolean isElectric
) {
}
