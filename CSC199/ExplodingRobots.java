import java.awt.*;

class ExplodingRobots {
	public static void main(String... args) {
		System.out.println(canExplode(1, 0, 2, 0, "UL"));
	}
	
	public static String canExplode(int x1, int y1, int x2, int y2, String instructions) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		
		
		
		for(int i = 0; i < instructions.length(); i++) {
			// Get trans
			char trans = instructions.charAt(i);
			int x = 0, y = 0;
			switch(trans) {
				case 'U': y++; break;
				case 'D': y--; break;
				case 'R': x++; break;
				case 'L': x--; break;
			}
			
			// Translate each possible outcome
			/*
			switch(out) {
				case 1: // r1
					p1.translate(x, y);
					break;
				case 2: //r2
					p2.translate(x, y);
					break;
				case 3: // r12
					p1.translate(x, y);
					p2.translate(x, y);
				// r0
			}
			*/
			//r1 = new Point();
			//r2 = new Point();
			
			// Which of four is shortest?
			closest(r1, r2, r3, r4);
		}
		// No crashes. It's safe
		return "Safe";
	}
}

//return "Explotion";
//return "Safe";