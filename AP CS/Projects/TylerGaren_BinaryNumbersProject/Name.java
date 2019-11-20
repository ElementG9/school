public class Name {
    String fname = "";
    String mname = "";
    String lname = "";
    public Name(String first, String middle, String last) {
        fname = first;
        mname = middle;
        lname = last;
    }

    public String getFirst() {
        return fname;
    }

    public String getMiddle() {
        return mname;
    }

    public String getLast() {
        return lname;
    }

    public String firstMiddleLast() {
        return getFirst() + " " + getMiddle() + " " + getLast();
    }

    public String lastFirstMiddle() {
        return getLast() + ", " + getFirst() + " " + getMiddle();
    }

    public boolean equals(String other) {
        return firstMiddleLast().equalsIgnoreCase(other);
    }

    public String initials() {
        String initials = "";
        initials += getFirst().substring(0,1);
        initials += getMiddle().substring(0,1);
        initials += getLast().substring(0,1);
        return initials.toUpperCase();
    }
    public int length() {
        return firstMiddleLast().length() - 2;
    }
}