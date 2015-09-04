package testProject;

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

		Process proc = rt.exec("cmd.exe /C dir " + dir);
	}
}