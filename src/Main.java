public class Main {
    public static void main(String[] args) {

        Box box = new Box(156546.54);

        checkPrint (box.addPyramid(4.54, 5.84));
        checkPrint(box.addBall(54.25));
        checkPrint(box.addCylinder(48.84, 89.65));
    }
    private static void checkPrint(boolean check)
    {
        if (check)
            System.out.println("Shape added successfully");
        else
            System.out.println("There is no more place in the box");
    }
}