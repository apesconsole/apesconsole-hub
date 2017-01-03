package com.apesconsole.repo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.apesconsole.entity.SensorData;
import com.apesconsole.repo.SensorLog;

@Repository
public class SensorLogImpl implements SensorLog {

	private JdbcTemplate template;
	private RowMapper<SensorData> rowMapper = new LogRowMapper();
	private static final String INSERT = "insert into sensor_data(id, message, log_time) values(?, ?, sysdate)";
	private static final String SEARCH = "select * from sensor_data";
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_MESSAGE = "message";
	private static final String COLUMN_TIME = "log_time";
	
	private Integer count = 0;
	
	@Autowired
	public SensorLogImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void logSensorData(SensorData data) {
		data.setId(++count);
		template.update(INSERT, new Object[]{
			data.getId(),
			data.getMessage()
		});

	}

	@Override
	public List<SensorData> loadSensorData() {
		return template.query(SEARCH, rowMapper);
	}
	
	private class LogRowMapper implements RowMapper<SensorData> {
		public SensorData mapRow(ResultSet rs, int i) throws SQLException {
			SensorData log = new SensorData();
			log.setId(rs.getInt(COLUMN_ID));
			log.setMessage(rs.getString(COLUMN_MESSAGE));
			log.setLog_time(rs.getString(COLUMN_TIME));
			return log;
		}
	}

}
