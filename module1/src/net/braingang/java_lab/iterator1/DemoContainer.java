package net.braingang.java_lab.iterator1;

public class DemoContainer implements Comparable<DemoContainer> {
    private String name;

    public DemoContainer(String arg) {
        name = arg;
    }

    @Override
    public  String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return 31 + ((name == null) ? 0: name.hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (this == object) return true;
        if (getClass() != object.getClass()) return false;

        DemoContainer other = (DemoContainer) object;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(DemoContainer other) {
        if (other == null) {
            throw new NullPointerException("null other");
        }

        return name.compareTo(other.name);
    }
}