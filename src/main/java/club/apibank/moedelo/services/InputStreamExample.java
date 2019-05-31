package club.apibank.moedelo.services;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamExample {

	private static final String FILE_PATH = "p.jpg";

	public byte[] get() {


		InputStream fileInputStream = null;
		byte[] resultBytes = new byte[20971520];

		try {

			if (filecheck()) {
				System.out.println("File exists !!!");
			}

			fileInputStream = new FileInputStream(FILE_PATH);

			// int bytesread = fileInputStream.read(bytes, 0, 15);
			// System.out.println("Bytes read :" + bytesread);
			// System.out.println(Arrays.toString(bytes));


		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				resultBytes = IOUtils.toByteArray(fileInputStream);
				fileInputStream.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return resultBytes;


	}

	private boolean filecheck() {
		File file = new File(FILE_PATH);
		Boolean result = false;


		try {
			System.out.println(file.getCanonicalPath() + " существует файл? " + file.exists());
			result = file.exists();
		} catch (IOException e) {
			e.printStackTrace();
		}


		return result;
	}


}
