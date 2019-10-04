public class School {
    int students;
    boolean hasCats;
    boolean areNerds;
    double squareFeet;
    String name;
    public School() {
        students = 2739;
        hasCats = false;
        areNerds = true;
        squareFeet = 127.001;
        name = "nerd schol";
    }

    public School(int _students, boolean _hasCats, boolean _areNerds, double _squareFeet, String _name) {
        students = _students;
        hasCats = _hasCats;
        areNerds = _areNerds;
        squareFeet = _squareFeet;
        name = _name;
    }
}