package org.bihe.main;

import java.util.HashMap;

import org.bihe.util.FileIO;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		HashMap<String, Integer> test = new HashMap<String, Integer>();
		test.put("Arash", 5);
		test.put("Zamani", 6);
		test.put("Farahani", 8);

		// test the FileIO methods
		boolean result = FileIO.writeObjectToFile(test, "test.obj");
		if (result)
			System.out
					.println("object has been written in the file successfully");
		else
			System.err
					.println("a problem has been occured in writting object to file");

		Thread.sleep(2000);

		Object dataResult = FileIO.readObjectFromFile("test.obj");
		if (dataResult == null) {
			System.err
					.println("a problem has been occured in reading object from file");
		} else {
			HashMap<String, Integer> loadedData = (HashMap<String, Integer>) dataResult;
			for (String key : loadedData.keySet()) {
				Integer value = loadedData.get(key);
				System.out.println("key: "+key+" # value: "+value);
			}
		}

	}

}
