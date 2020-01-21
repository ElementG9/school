public class Tester {
    public static void main(String[] args) {
        Intern         a = new         Intern("HP",          "Rainbow Road",                         "(666)420-6969"                    );
        Employee       s = new       Employee("definitely",  "1 Infinite Loop Cupertino, CA, 95014", "(167)353-2934", "420-69-6969", 2  );
        HourlyEmployee d = new HourlyEmployee("means",       "Google Dr",                            "(213)867-5309", "420-69-6969", 420);
        Executive      f = new      Executive("Huge Pricks", "Anime Blvd",                           "(123)456-7890", "420-69-6969", 666);
        StaffMember[] membs = new StaffMember[4];
        membs[0] = a;
        membs[1] = s;
        membs[2] = d;
        membs[3] = f;
        for(StaffMember gamer : membs) {
            if (gamer instanceof HourlyEmployee)
                ((HourlyEmployee) gamer).addHours(69);
            if (gamer instanceof Executive)
                ((Executive)gamer).awardBonus(420.0);
            gamer.pay();
        }
    }
}