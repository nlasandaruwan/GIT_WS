package lambdaNew.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lambdaNew.functionalInterfaces.BufferedReaderProcessor;

public class BufferedReaderProcessorImpl {

	public String processFile(File file, BufferedReaderProcessor bufferedReaderProcessor) throws FileNotFoundException, IOException{
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); 
				
			//FileInputStream fileInputStream = new FileInputStream("")
			
			){
			
			return bufferedReaderProcessor.process(bufferedReader);
		}
		
		
	}
	
	public String processFile(BufferedReader br) throws IOException{
		
		StringBuffer buffer = new StringBuffer();
		while(br.read() !=-1){
			buffer.append(br.readLine()+"\n");			
		}
		return buffer.toString() ;
		
	}
}

