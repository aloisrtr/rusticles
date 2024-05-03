package ir.terminator;

import ir.core.IRBlock;
import ir.core.IRValue;
import ir.core.IRVisitor;

import java.util.List;

public class IRCondBr extends IRTerminator {

    // IRCondBr
    // One or two successors, an operands to verify whether we take first succ (if true) or
    // second succ/continue (if false)

    public IRCondBr(IRValue cond, IRBlock ifTrue, IRBlock ifFalse) {
        super(List.of(ifTrue, ifFalse));
        this.addOperand(cond);
    }

    @Override
    public Object accept(IRVisitor v) {
        return v.visitCondBr(this);
    }
}
