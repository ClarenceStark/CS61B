import javax.naming.spi.StateFactory;

public class NBody{
	public static double readRadius(String txt_path){
		In in = new In(txt_path);
		int firstItem = in.readInt();
		double radius = in.readDouble();
		return radius;		
	}
	public static Planet[] readPlanets(String txt_path){
		In in = new In(txt_path);
		int firstItem = in.readInt();
		double radius = in.readDouble();
		Planet[] p = new Planet[5];
		double[] D = new double[5];
		for (int i = 0; i < 5; i++){

			for (int j = 0; j < 5; j ++){
				D[j] = in.readDouble();
			}
			String nameOfPlanet = in.readString();
				Planet planet = new Planet(D[0], D[1], D[2], D[3], D[4], nameOfPlanet);
				p[i] = planet;
		}
		return p;
	}
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = NBody.readRadius(filename);
		Planet[] p = NBody.readPlanets(filename);
		StdDraw.setScale(-3e+12, 3e+12);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		StdDraw.show();
		for (int i = 0; i < p.length; i++){
			p[i].draw();
		}
		StdDraw.pause(1);
		double t = 0;
		StdDraw.enableDoubleBuffering();
		while (t != T){
			double[] xForces = new double[5];
			double[] yForces = new double[5];
			for (int i = 0; i < p.length; i++){
				xForces[i] = p[i].calcNetForceExertedByX(p);
				yForces[i] = p[i].calcNetForceExertedByY(p);
			}
			for (int i = 0; i < p.length; i++){
				p[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (int i = 0; i < p.length; i++){
				p[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(1);
			t += dt;
		}
		StdOut.printf("%d\n", p.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < p.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					p[i].xxPos, p[i].yyPos, p[i].xxVel,
					p[i].yyVel, p[i].mass, p[i].imgFileName);
		}
	}
}
