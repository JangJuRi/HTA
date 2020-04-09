package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo6 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("c:/files/HTA-master.zip");
		FileOutputStream fos = new FileOutputStream("c:/files/HTA-master-copy2.zip");
		
		IOUtils.copy(fis, fos);
	}
}
