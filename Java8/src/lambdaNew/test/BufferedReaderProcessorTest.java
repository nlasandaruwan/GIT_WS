package lambdaNew.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lambdaNew.impl.BufferedReaderProcessorImpl;

public class BufferedReaderProcessorTest {

	public static void main(String[] args) {
		
		BufferedReaderProcessorImpl bufferedReaderProcessorImpl = new BufferedReaderProcessorImpl();
		
		try {
			
			File file = new File("A:\\Java Books\\test.txt");
			
			String line = bufferedReaderProcessorImpl.processFile(file,(BufferedReader br)-> {
				
				StringBuffer buffer = new StringBuffer();
				while(br.read() !=-1){
					buffer.append(br.readLine()+"\n");			
					
				}
				return buffer.toString() ;});
			
			
			System.out.println(line);
			
			
			String line2 = bufferedReaderProcessorImpl.processFile(file,bufferedReaderProcessorImpl::processFile);
			
			System.out.println(line2);
			
			List<String> list = new ArrayList<String>();
			
			Predicate<String> p = s -> list.add(s); 
			
			Consumer<String> b = s -> list.add(s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
