package hw.composite;

public class SimpleDepartment extends Unit {

    public SimpleDepartment(String name) {
        super(name);
    }

    @Override
    public String report() {
        return "\tReport for simple department " + this.getName();
    }

    @Override
    public void add(Unit unit) {
        throw new RuntimeException("This is a simple department");
    }

    @Override
    public void remove(Unit unit) {
        throw new RuntimeException("This is a simple department");
    }
}