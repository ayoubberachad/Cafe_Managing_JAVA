package com.cafe.managing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;

public final class Download {
	public static void main(String args[]) throws IOException {
		try {
			java.lang.System.setProperty("https.protocols", "TLSv1.2");
			System.setProperty("jsse.enableSNIExtension", "false");

			String url = "https://www.tutorialspoint.com/html/html_tutorial.pdf";// the path of pdf file which we want
																					// to download..
			URLConnection connection = new URL(url).openConnection();
			connection.setConnectTimeout(60000);
			connection.setReadTimeout(60000);
			connection.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

			InputStream input = connection.getInputStream();

			File destination = new File("test.pdf");// this is the name of the file at local pc...it could be
													// anything....whatever you want..
			FileOutputStream output = new FileOutputStream(destination, false);

			byte[] buffer = new byte[2048];
			int read;
			System.out.println("Downloading.");
			while ((read = input.read(buffer)) > -1) {
				output.write(buffer, 0, read);
				System.out.print(".");
			}

			output.flush();
			output.close();
			input.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
