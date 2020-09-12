import java.lang.Math;

public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV,
         			double yV, double m, String img) {
              	xxPos = xP;
              	yyPos = yP;
              	xxVel = xV;
              	yyVel = yV;
              	mass = m;
              	imgFileName = img;
  }

  public Planet(Planet p) {
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p) {
    double dist;
    dist = Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2));
    return dist;
  }

  public double calcForceExertedBy(Planet p) {
    double force;
    force = (6.67 * Math.pow(10,-11) * this.mass * p.mass) / Math.pow(this.calcDistance(p),2);
    return force;
  }

  public double calcForceExertedByX(Planet p) {
     double forcex;
     forcex = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
     return forcex;
  } 

  public double calcForceExertedByY(Planet p) {
     double forcey;
     forcey = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
     return forcey;
  }  

  public double calcNetForceExertedByX(Planet[] p) {
    double netforcex = 0;
    for(Planet pl : p) {
      if(this.equals(pl)) {
        continue;
      } else{
        netforcex += this.calcForceExertedByX(pl);
      }
    }
    return netforcex;
  }  

  public double calcNetForceExertedByY(Planet[] p) {
    double netforcey = 0;
    for(Planet pl : p) {
      if(this.equals(pl)){
        continue;
      } else{
        netforcey += this.calcForceExertedByY(pl);
      }
    }
    return netforcey;
  }

  public void update(double dt, double fX, double fY) {
    double aX = fX/this.mass;
    double aY = fY/this.mass;
    this.xxVel += aX * dt;
    this.yyVel += aY * dt;
    this.xxPos += this.xxVel * dt;
    this.yyPos += this.yyVel * dt;

  }  

  public void draw() {
    StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
  }
}



































