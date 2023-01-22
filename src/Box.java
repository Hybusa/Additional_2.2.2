import java.util.ArrayList;

public class Box implements BallAddable, CylinderAddable, PyramidAddable {

    ArrayList<Double> stored = new ArrayList<>();
    private double volumeLeft;

    Box(double volume) {
        this.volumeLeft = volume;
    }

    @Override
    public boolean addBall(double radius) {
        if (listSum(stored) + ballVolume(radius) > this.volumeLeft)
            return false;
        else {
            stored.add(ballVolume(radius));
            this.volumeLeft -= ballVolume(radius);
            return true;
        }
    }

    @Override
    public boolean addCylinder(double radius, double height) {
        if (listSum(stored) + cylinderVolume(radius, height) > this.volumeLeft)
            return false;
        else {
            stored.add(cylinderVolume(radius, height));
            this.volumeLeft -= cylinderVolume(radius, height);
            return true;
        }
    }

    @Override
    public boolean addPyramid(double s, double h) {
        if (listSum(stored) + pyramidVolume(s, h) > this.volumeLeft)
            return false;
        else {
            stored.add(pyramidVolume(s, h));
            this.volumeLeft -= pyramidVolume(s, h);
            return true;
        }
    }

    private static double listSum(ArrayList<Double> arrayList) {
        double sum = 0;
        for (double i : arrayList) {
            sum += i;
        }
        return sum;
    }

    private static double ballVolume(double radius) {
        return Math.PI * 4 * Math.pow(radius, 3) / 3;
    }

    private static double cylinderVolume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    private static double pyramidVolume(double s, double h) {
        return (s * h / 3);
    }
}
