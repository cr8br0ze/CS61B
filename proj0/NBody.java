public class NBody {
    /** ReadRadius */
    public static double readRadius(String text){
        In in = new In(text);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /** ReadPlanets */
    public static Planet[] readPlanets(String text){
        In in = new In(text);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] list = new Planet[number];
        for (int i = 0; i < number; i++){
            double xp = in.readDouble();
            double yp = in.readDouble();
            double xv = in.readDouble();
            double yv = in.readDouble();
            double mass = in.readDouble();
            String image = in.readString();
            list[i] = new Planet(xp, yp, xv, yv, mass, image);
        }
        return list;
    }

    public static void main(String[] args){

        /** Enable double buffering */
        StdDraw.enableDoubleBuffering();

        /** Collecting All Needed Input*/
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        In in = new In(filename);
        double radius = readRadius(filename);
        Planet[] planetlist = readPlanets(filename);
        /** Drawing the Background */
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0,"images/starfield.jpg");

        /** Drawing All of the Planets */
        for (Planet i : planetlist){
            i.draw();
        }

        /** create time loop */
        int number = in.readInt();
        /** Create a time variable and set it to 0 */
        double time = 0;

        while(time < T){

            /** Create an xForces array and yForces array */
            double[] xForces = new double[planetlist.length];
            double[] yForces = new double[planetlist.length];

            /** Calculate the net x and y forces for each planet, storing these in the xForces and yForces arrays respectively */
            for (int i = 0; i < planetlist.length; i++) {
                xForces[i] = planetlist[i].calcNetForceExertedByX(planetlist);
                yForces[i] = planetlist[i].calcNetForceExertedByY(planetlist);
            }

            /** Call update on each of the planets. This will update each planet’s position, velocity, and acceleration. */
            for (int i = 0; i <planetlist.length; i++ ) {
                planetlist[i].update(dt, xForces[i], yForces[i]);
            }

            /** Draw the background image */
            StdDraw.picture(0, 0,"images/starfield.jpg");

            /** Draw all of the planets */
            for (Planet i : planetlist){
                i.draw();
            }

            /** Show the offscreen buffer */
            StdDraw.show();

            /** Pause the animation for 10 milliseconds */
            StdDraw.pause(10);
            //clear
            /** Increase your time variable by dt */
            time += dt;
        }

        /** Printing the Universe */
        StdOut.printf("%d\n", planetlist.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planetlist.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planetlist[i].xxPos, planetlist[i].yyPos, planetlist[i].xxVel,
                    planetlist[i].yyVel, planetlist[i].mass, planetlist[i].imgFileName);
        }
    }
}
