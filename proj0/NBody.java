import java.lang.Math;

public class NBody {
	public static String imgtodraw = "./images/starfield.jpg";

	public static double readRadius(String filename) {
		In in = new In(filename);
		int firstItemInFile = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int numofplnt = in.readInt();
		Planet[] pl = new Planet[numofplnt];
		double radius = in.readDouble();
		for(int i=0;i < numofplnt; i++) {
			double xp = in.readDouble();
			double yp = in.readDouble();
			double xv = in.readDouble();
			double yv = in.readDouble();
			double ms = in.readDouble();
			String img = in.readString();
			Planet plnt = new Planet(xp,yp,xv,yv,ms,img);
			pl[i] = plnt;
		}
		return pl;
	} 



	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = readRadius(filename);
		Planet[] pl = readPlanets(filename);
		StdDraw.enableDoubleBuffering();


		StdDraw.setScale(-radius, radius);
        // StdDraw.clear();

		// StdDraw.picture(0,0,imgtodraw);

		// for( Planet p : pl) {
		// 	p.draw();
		// }

		double Ts = 0;
		double[] xForce = new double[pl.length];
		double[] yForce = new double[pl.length];
		System.out.println(pl.length);
		while(Ts <= T) {

			for(int i =0; i<pl.length; i++) {
				xForce[i] = pl[i].calcNetForceExertedByX(pl);
				yForce[i] = pl[i].calcNetForceExertedByY(pl);
			}

			for(int i =0; i<pl.length;i++) {
				pl[i].update(dt, xForce[i], yForce[i]);
			}

			StdDraw.picture(0,0, NBody.imgtodraw);
			for(Planet p : pl) {
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);		
			Ts += dt;
		}
		StdOut.printf("%d\n", pl.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < pl.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            pl[i].xxPos, pl[i].yyPos, pl[i].xxVel,
            pl[i].yyVel, pl[i].mass, pl[i].imgFileName);   
	}


}
}
















