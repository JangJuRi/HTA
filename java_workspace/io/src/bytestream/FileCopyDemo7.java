package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo7 {

	public static void main(String[] args) throws IOException{
	
		URL url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTr8ZiY6KNYSaEMeYcZKewkDzeXv1Fml6YCtbNhAEAifTrEJzXN&usqp=CAU");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("c:/files/강아지.jpg");
		
		IOUtils.copy(is, fos);
	}
}
