package com.example.firstms.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyActuatorHealthIndicator implements HealthIndicator{

	@Override
	public Health health() {
		System.out.println("**** Health Indicator ****");
        // call other microservice and get its health
        // Database health check
        Health.down();
        return Health.up()
                .withDetail("orderms", "available")
                .withDetail("paymentms", "available")
                .build();
	}

}
