package com.wagner.stoom_test.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.wagner.stoom_test.services.AddressServices;

public class StoomTestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classesSet = new HashSet<Class<?>>();
		classesSet.add(AddressServices.class);
		return classesSet;
	}

}
