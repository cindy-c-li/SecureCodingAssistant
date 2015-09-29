package testProject;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Throwable {
		// Test IDS00J
		Connection connection = DriverManager.getConnection("testing");
		Statement stmt = connection.createStatement();
		PreparedStatement pStmt = connection.prepareStatement(null);
		pStmt.setString(1, "");
		
		ResultSet rs = pStmt.executeQuery("testing");


		// Test IDS01J
		String s = "\uFE64" + "script" + "\uFE65";

		// Normalize (comment out to generate warning)
		s = Normalizer.normalize(s, Form.NFKC);		
	
		// Validate
		Pattern pattern = Pattern.compile("[<>]");
		Matcher matcher = pattern.matcher(s);
		
		
		

		// Test IDS07J
		String dir = System.getProperty("dir");
		Runtime rt = Runtime.getRuntime();

		// Comment out to remove warning
		Process proc = rt.exec("cmd.exe /C dir " + dir);
		

		
		

		// Test IDS11J
		String s2 = "<scr!ipt>";
		s2 = Normalizer.normalize(s2, Form.NFKC);

		// Delete non-character code points  (move to end to generate warning)
		s2 = s2.replaceAll("[\\p{Cn}]","");
		
		// Look for script tag
		pattern = Pattern.compile("<script>");
		matcher = pattern.matcher(s2);
		if (matcher.find())
			throw new IllegalArgumentException("Invalid Input");
		

		

		
		// Test STR00J
		final int MAX_SIZE = 1024;
		@SuppressWarnings("resource")
		Socket socket = new Socket();
		InputStream in = socket.getInputStream();
		byte[] data = new byte[MAX_SIZE + 1];
		int offset = 0; 
		int bytesRead = 0;
		String str = new String();
		while ((bytesRead = in.read(data, offset, data.length - offset)) != -1) {
			offset += bytesRead;
			str += new String(data, offset, data.length - offset, "UTF-8");
			if (offset >= data.length) {
				throw new IOException("Too much input");
			}
		}
		in.close();
	}
}
