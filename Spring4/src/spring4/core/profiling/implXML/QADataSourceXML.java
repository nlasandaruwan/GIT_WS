package spring4.core.profiling.implXML;

import spring4.core.profiling.intf.DataSource;

public class QADataSourceXML implements DataSource{

	@Override
	public void connect() {
		System.out.println( "Connecting to QADataSourceXML ............!!! " );
		
	}

}
