import java.io.*;
import java.util.*;

public class Test {
	public static void main(String javaNamesCauseRSI[]) throws IOException {
		DBM d = new DBM("/tmp/mydb");
		System.out.println(d);
		d.store("today", new Date());
		d.store("here", System.getProperty("user.dir"));
		DBM d2;
		try { d2 = new DBM("NoSuchDbAnyway"); 
			System.out.println("** ERROR ** failed to throw Exception");
		} catch (IllegalArgumentException e) {
			System.out.println("Correctly threw " + e);
		}
		d.close();
		d2 = new DBM("/tmp/mydb");
		System.out.println("d2 contains " + d2.fetch("here"));
		System.out.println("d2 contains " + d2.fetch("today"));
		d2.close();
	}
}
