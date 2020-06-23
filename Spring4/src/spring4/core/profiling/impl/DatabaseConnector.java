package spring4.core.profiling.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring4.core.profiling.intf.DataSource;

@Component("dbconn")
public class DatabaseConnector {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
}
