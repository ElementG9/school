public class TriangleTest {
    int passes = 0;
    int fails = 0;
    int total = 0;
    public void runTests() {
        System.out.println("** test **");
        test("triangleInstantiation", triangleInstantiationTest());
        System.out.println("** end test **");
    }
    public void test(String testName, boolean testResult) {
        System.out.println(testName + " : " + (testResult ? "PASS" : "FAIL"));
    }
    private boolean triangleInstantiationTest() {
        boolean success = true;
        try {
            Triangle t = new Triangle(new Point(0.5,1), new Point(1,0), new Point(0,0));
            if (t.getPointA().getX() != 0.5) success = false;
            if (t.getPointA().getY() != 1) success = false;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            success = false;
        }
        return success;
    }
}