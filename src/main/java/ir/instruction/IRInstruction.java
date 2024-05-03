package ir.instruction;

import ir.core.IROperation;
import ir.core.IRType;

public abstract class IRInstruction extends IROperation {

    protected IRInstruction() {
        super();
    }

    // Used to get the type of the result of a binary instruction
    protected IRType getBinaryOpResultType(IRType type1, IRType type2) {
        if (type1 == type2 || type2 == IRType.ANY) {
            return type1;
        } else if (type1 == IRType.ANY) {
            return type2;
        } else {
            throw new RuntimeException("Cannot operate on values of type " + type1 + " and " + type2 + " at the same time");
        }
    }
}
