public class Cobra {
    // double length = 11.5;
    // String hue = "black";
    // boolean legs = false;
    // int ageInYears = 21;
    double length;
    String hue;
    boolean legs;
    int ageInYears;
    public Cobra () {
        length = 11.5;
        hue = "black";
        legs = false;
        ageInYears = 21;
    }

    public Cobra(double _length, String _hue, boolean _legs, int _ageInYears) {
        length = _length;
        hue = _hue;
        legs = _legs;
        ageInYears = _ageInYears;
    }

    public int celebrateBirthday() {
        return ageInYears++;
    }
    public void puberty() {
        System.out.println("The cobra grew legs.");
        length += 1.4;
        legs = !legs;
    }
}