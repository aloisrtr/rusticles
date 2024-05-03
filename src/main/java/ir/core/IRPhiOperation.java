package ir.core;

public class IRPhiOperation extends IROperation {
    public IRPhiOperation(IRType type) {
        super();
        this.addResult(type);
    }
    public IRPhiOperation(IRBlock containingBlock) {
        super();
        this.addResult(IRType.ANY);
        this.setContainingBlock(containingBlock);
    }

    @Override
    public Object accept(IRVisitor v) {
        return v.visitPhiOperation(this);
    }
    
    @Override
    public void addOperand(IRValue v) {
        if (super.getResult().type == IRType.ANY) {
            super.addResult(v.type);
        } else if (v.type == IRType.ANY) {
            v.type = super.getResult().type;
        }
        if (super.getResult().type != v.type) {
            throw new RuntimeException("Tried assigning a value of an incorrect type to a variable: expected " + super.getResult().type + " but got " + v.type);
        }
        super.addOperand(v);
    }
}
