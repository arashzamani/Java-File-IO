package org.bihe.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class load an object from input file and also write an object to the
 * file. It includes some methods to do it in easy way and you can use anywhere
 * 
 * @author Arash Zamani Farahani
 * @version 0.1.2 {@link http
 *          ://docs.oracle.com/javase/7/docs/api/java/io/FileOutputStream.html}
 *          Contact Me: arash.zamani@bihe.org - I'm Student at BIHE. for more
 *          information about BIHE you can chcek www.bihe.org
 *
 */
public class FileIO {
	/**
	 * this method write an object to the file. the file have to be serializable. otherwise,
	 * an exception will be happened.
	 * @param obj the object will be write to the file
	 * @param filePath the String of file path for writing in the file
	 * @return true if the object has been written successfully and false if an exception throws while writing the object in the file.
	 * @throws FileNotFoundException if the file was not found
	 * 
	 * 
	 */
	public static boolean writeObjectToFile(Object obj, String filePath) {
		// At the first step we define a boolean. It initialize with false
		// value.
		boolean result = false;
		FileOutputStream fos = null;
		try {
			// prepare file in an object of FileOutputStream
			fos = new FileOutputStream(filePath);
			// get the output stream file in an object
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to the file through ObjectOutputStream object
			oos.writeObject(obj);
			// it is necessary to call every time you used stream IO
			oos.flush();
			oos.close();
			result = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// ==================================================================
	// ==================================================================
	// ==================================================================
	/**
	 * This method read an object from the file. 
	 * @param filePath the String of file path for reading from the file
	 * @return null if an exception throws reading object from file or an object from Object class if everything is going ok.
	 */
	public static Object readObjectFromFile(String filePath) {
		Object result = null;
		FileInputStream fis = null;
		try {
			// load file via an object of FileInputStream
			fis = new FileInputStream(filePath);
			// get the input stream of file in an object
			ObjectInputStream ois = new ObjectInputStream(fis);
			// read object from the file
			result = ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
