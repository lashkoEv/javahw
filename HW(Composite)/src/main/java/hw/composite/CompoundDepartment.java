package hw.composite;

import java.util.ArrayList;

public class CompoundDepartment extends Unit {
    public CompoundDepartment(String name) {
        super(name);
        units = new ArrayList<>();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tReport for compound department ").append(getName());
        for (Unit u : units) {
            sb.append("\n\t\t").append(u.report());
        }
        return sb.toString();
    }
}
