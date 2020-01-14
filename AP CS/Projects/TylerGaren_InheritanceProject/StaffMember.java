public abstract class StaffMember {
    protected String name;
    protected String address;
    protected String phone;
    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public String toString() {
        String out = "";
        out += "Name: ";
        out += this.name;
        out += "\nAddress: ";
        out += this.address;
        out += "\nPhone: ";
        out += this.phone;
        return out;
    }
    public abstract double pay();
}