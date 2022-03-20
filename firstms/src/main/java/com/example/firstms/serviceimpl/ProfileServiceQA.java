package com.example.firstms.serviceimpl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.firstms.service.ProfileService;

@Component
@Profile("qa")
public class ProfileServiceQA implements ProfileService {

	@Override
	public String getData() {
		
		return "Qa Profile running";
	}

}
