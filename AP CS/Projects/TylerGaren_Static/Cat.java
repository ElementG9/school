
public class Cat {
    int age;
    String name;
    public Cat (int _age, String _name) {
        age = _age;
        name = _name;
    }
    public void haveBirthday() {
        age++;
    }
    public String toString() {
        return name + " is a " + age + " year old cat.";
    }
}
