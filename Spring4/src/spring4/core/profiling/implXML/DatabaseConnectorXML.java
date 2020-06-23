package spring4.core.profiling.implXML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring4.core.profiling.intf.DataSource;

@Component("dbconnXML")
public class DatabaseConnectorXML {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
}
