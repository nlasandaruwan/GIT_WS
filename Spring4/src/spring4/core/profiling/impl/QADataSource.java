package spring4.core.profiling.impl;

import spring4.core.profiling.intf.DataSource;

public class QADataSource implements DataSource{

	@Override
	public void connect() {
		System.out.println( "Connecting to QADataSource ............!!! " );
		
	}

}
