public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    /** Creating planet constructor and initialization */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /** calcDistance */
    public double calcDistance(Planet b){
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        double rsquare = dx*dx + dy*dy;
        return Math.sqrt(rsquare);
    }

    /** calcForceExertedBy */
    public double calcForceExertedBy(Planet b){
        double m1 = this.mass;
        double m2 = b.mass;
        double rsquare = this.calcDistance(b)*this.calcDistance(b);
        return (this.G*m1*m2)/rsquare;
    }

    /** calcForceExertedByX and calcForceExertedByY */
    public double calcForceExertedByX(Planet b){
        double F = this.calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        double r = this.calcDistance(b);
        return (F*dx)/r;
    }

    public double calcForceExertedByY(Planet b){
        double F = this.calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        double r = this.calcDistance(b);
        return (F*dy)/r;
    }

    /** calcNetForceExertedByX and calcNetForceExertedByY */
    public double calcNetForceExertedByX(Planet[] Planetlist){
        double Fnetx = 0;
        for (int i = 0; i < Planetlist.length; i++){
            if(Planetlist[i].equals(this)){
                continue;
            }
            Fnetx += this.calcForceExertedByX(Planetlist[i]);
        }
        return Fnetx;
    }
    public double calcNetForceExertedByY(Planet[] Planetlist){
        double Fnety = 0;
        for (int i = 0; i < Planetlist.length; i++){
            if(Planetlist[i].equals(this)){
                continue;
            }
            Fnety += this.calcForceExertedByX(Planetlist[i]);
        }
        return Fnety;
    }

    /** update */
    public void update(double time, double xforce, double yforce){
        double ax = xforce/this.mass;
        double ay = yforce/this.mass;
        this.xxVel += time*ax;
        this.yyVel += time*ay;
        this.xxPos += time*this.xxVel;
        this.yyPos += time*this.yyVel;
    }

    /** Drawing One Planet */
    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }
}
