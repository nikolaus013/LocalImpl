package LocalStorageImpl.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
public static void main(String[] args) {
	
	
	
	BasicOps bs = new BasicOps();
	String putanja = "E:/skTEST";
	
	
	try {
		bs.createFile(putanja, "burek.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
