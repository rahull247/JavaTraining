package com.example.firstms.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class MyCustomActuatorEndpoint {
	private String ready = "NOT_READY";

	@ReadOperation // GET
	public String getReadiness() {
		System.out.println("**** getReadiness");
		return ready;
	}

	@WriteOperation // POST
	public String post() {
		System.out.println("**** postReadiness");
		return "Post Ready";
	}

	@EventListener(ApplicationReadyEvent.class)
	public void setReady() {
		System.out.println("**** setReady");
		ready = "READY";
	}
}
