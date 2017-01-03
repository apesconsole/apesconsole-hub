package com.apesconsole.repo;

import java.util.List;

import com.apesconsole.entity.SensorData;

public interface SensorLog {
	public void logSensorData(final SensorData data);
	
	public List<SensorData> loadSensorData();
}
