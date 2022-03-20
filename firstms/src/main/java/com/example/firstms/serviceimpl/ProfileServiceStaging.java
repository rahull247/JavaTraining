package com.example.firstms.serviceimpl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.firstms.service.ProfileService;

@Component
@Profile("staging")
public class ProfileServiceStaging implements ProfileService {

	@Override
	public String getData() {
		
		return "Staging Profile";
	}

}
