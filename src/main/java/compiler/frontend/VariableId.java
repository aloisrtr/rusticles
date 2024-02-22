package compiler.frontend;

public class VariableId {
    String name;

    public VariableId(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(VariableId other) {
        return name.equals(other.getName());
    }

    public String toString() {
        return name;
    }

    public int hashCode() {
        return name.hashCode();
    }
}
