public class Planet {
	// G = 6.67 * 10 ^ (-11)
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private final static double G = 6.67 * Math.pow(10, -11);
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		double xDis = this.xxPos - p.xxPos;
		double yDis = this.yyPos - p.yyPos;
		double Distance = Math.pow((Math.pow(xDis, 2) + Math.pow(yDis, 2)), 0.5);
		return Distance;
	}	
	public double calcForceExertedBy(Planet p){
		if (this.calcDistance(p) == 0){
			return 0;
		}
		return (Planet.G * this.mass * p.mass) / Math.pow(this.calcDistance(p), 2);
	}
	public double calcForceExertedByX(Planet p){
		if (this.calcDistance(p) == 0){
			return 0;
		}
		return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
	}
	public double calcForceExertedByY(Planet p){
		if (this.calcDistance(p) == 0){
			return 0;
		}
                return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] p){
		double sum = 0;
		for (int i = 0; i < p.length; i++){
			if (calcDistance(p[i]) == 0){
				continue;
			}
			sum += calcForceExertedByX(p[i]);
		}
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] p){
                double sum = 0;
                for (int i = 0; i < p.length; i++){
			if (calcDistance(p[i]) == 0) {
				continue;
			}
                        sum += calcForceExertedByY(p[i]);
                }
                return sum;
        }
	public void update(double dt, double fx, double fy){
		double ax = fx / mass;
		double ay = fy / mass;
		this.xxVel = this.xxVel + ax * dt;
		this.yyVel = this.yyVel + ay * dt;
		this.xxPos = this.xxVel * dt + this.xxPos;
		this.yyPos = this.yyVel * dt + this.yyPos;
	}
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
		StdDraw.show();
	}
}

