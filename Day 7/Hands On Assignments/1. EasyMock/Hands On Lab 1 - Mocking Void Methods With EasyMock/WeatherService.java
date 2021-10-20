package com.testing.easymock;

public interface WeatherService {
	void populateTemperature(Location location) throws ServiceUnavailableException;
}