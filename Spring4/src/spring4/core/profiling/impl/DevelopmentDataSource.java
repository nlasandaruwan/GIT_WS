package spring4.core.profiling.impl;

import spring4.core.profiling.intf.DataSource;

public class DevelopmentDataSource implements DataSource {

	@Override
	public void connect() {
		System.out
				.println("Connecting to DevelopmentDataSource ............!!! ");

	}

}
