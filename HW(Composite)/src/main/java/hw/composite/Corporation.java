package hw.composite;

import java.util.ArrayList;

public class Corporation extends Unit {
    public Corporation(String name) {
        super(name);
        units = new ArrayList<>();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Report for corporation ").append(getName());
        for (Unit u : units) {
            sb.append("\n").append(u.report());
        }
        return sb.toString();
    }
}
