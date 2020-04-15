package hw.composite;

import java.util.Iterator;
import java.util.List;

public abstract class Unit implements Iterable<Unit>, Iterator<Unit> {
    private String name;
    int position;
    protected List<Unit> units;

    public Unit(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public abstract String report();

    public void add(Unit unit) {
        if (units != null) {
            units.add(unit);
        }
    }

    public void remove(Unit unit) {
        units.remove(unit);
    }

    @Override
    public Iterator<Unit> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return !(position >= units.size() || units.get(position) == null);
    }

    @Override
    public Unit next() {
        return units.get(++position);
    }

}