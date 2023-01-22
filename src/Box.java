import java.util.ArrayList;

public class Box implements BallAddable, CylinderAddable, PyramidAddable {

    ArrayList<Double> stored = new ArrayList<>();
    private double volumeLeft;

    Box(double volume) {
        this.volumeLeft = volume;
    }

    @Override
    public boolean addBall(double radius) {
        return addShapeChecker(listSum(stored) + ballVolume(radius),ballVolume(radius));
    }

    @Override
    public boolean addCylinder(double radius, double height) {
        return addShapeChecker(listSum(stored)
                + cylinderVolume(radius, height),cylinderVolume(radius, height));
    }

    @Override
    public boolean addPyramid(double s, double h) {
        return addShapeChecker(listSum(stored) + pyramidVolume(s, h),pyramidVolume(s, h));
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

    private boolean addShapeChecker(double sumArrayAndNewShape, double shapeVolume) {
        if (sumArrayAndNewShape > this.volumeLeft)
            return false;
        else {
            stored.add(shapeVolume);
            this.volumeLeft -= shapeVolume;
            return true;
        }
    }
}