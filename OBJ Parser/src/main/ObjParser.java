package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ObjParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			ObjParser.parse("D:/Code/Eclipse/Graphics/models/articunoB.obj");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String parse(String dir) throws FileNotFoundException {
		Float[][] verts = new Float[696][3];
		int i = 0;
		int a = 0;
		int facecounter = 1;
		StringTokenizer st;
		float scale = (float) 0.3;
		
		Scanner s = new Scanner(new FileReader(dir));
		while (s.hasNext()) {
			st = new StringTokenizer(s.nextLine(), " ");
			String str = st.nextToken();
			if (str.equals("v")) {
				verts[i][0] = Float.valueOf(st.nextToken())*scale;
				verts[i][1] = Float.valueOf(st.nextToken())*scale;
				verts[i][2] = Float.valueOf(st.nextToken())*scale;
				i++;

			} else if (str.equals("f")) {
				System.out.println("// " + facecounter + " ------");
				facecounter++;
				for (int j = 0; j < 3; j++) {
					try{
					a = (Integer.parseInt(st.nextToken()))-1;
					
					System.out.print("" + verts[a][0] + "f, ");
					System.out.print("" + verts[a][1] + "f, ");
					System.out.println("" + verts[a][2] + "f, ");
					}catch(Exception e){
						System.out.println(a);
					}
				}

			}

		}
		s.close();
		return dir;

	}

}
