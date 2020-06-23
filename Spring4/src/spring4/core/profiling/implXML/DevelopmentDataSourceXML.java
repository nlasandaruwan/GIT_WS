package spring4.core.profiling.implXML;

import spring4.core.profiling.intf.DataSource;

public class DevelopmentDataSourceXML implements DataSource {

	@Override
	public void connect() {
		System.out
				.println("Connecting to DevelopmentDataSourceXML ............!!! ");

	}

}
