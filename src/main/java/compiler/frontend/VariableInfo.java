package compiler.frontend;

import ir.core.IRValue;

public class VariableInfo {
    IRValue value;
    public VariableInfo(IRValue value) {
        this.value = value;
    }

    public String toString() {
        return this.value.toString();
    }
}
