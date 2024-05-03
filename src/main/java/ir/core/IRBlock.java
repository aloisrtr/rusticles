package ir.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import compiler.frontend.SymbolTable;
import ir.terminator.IRTerminator;

public class IRBlock implements IRVisitableObject {
    private final List<IROperation> operations; /*
     * !< List of operations inside the block. Last one should be a IRTerminator
     */
    private final List<IRBlock> predecessors; /*
     * !< List of predecessors in the control flow graph. Built automatically when
     * calling addTerminator() on a block
     */

	  private HashMap<String, IRPhiOperation> incompletePhi = new HashMap<>();
    private boolean isSealed = false;
    
    public final IRFunction containingFunction;

    public IRBlock(IRFunction f) {
        operations = new ArrayList<>();
        predecessors = new ArrayList<>();
        containingFunction = f;
    }

    public IRTerminator getTerminator() {
        if (operations.size() > 0 && operations.getLast() instanceof IRTerminator) {
            return (IRTerminator) operations.getLast();
        } else {
            return null;
        }
    }

    public void addTerminator(IRTerminator t) {
        // We add predecessor to each successor
        for (IRBlock successor : t.getSuccessors())
            successor.predecessors.add(this);
        // We insert the terminator operation
        addOperation(t);
    }

    public void addOperation(IROperation op) {
        op.setContainingBlock(this);
        this.operations.add(op);
    }

    public List<IRBlock> getSuccessors() {
        return getTerminator().getSuccessors();
    }

    public List<IRBlock> getPredecessors() {
        return predecessors;
    }

    public void addPredecessor(IRBlock block) {
        this.predecessors.add(block);
    }

    public List<IROperation> getOperations() {
        return operations;
    }
    
    public int getBlockIndexInContainingFunc() {
    	return this.containingFunction.getBlocks().indexOf(this);
    }

    public void addIncompletePhi(String name, IRPhiOperation phi) {
        this.incompletePhi.put(name, phi);
        this.addOperation(phi);
    }
    public void seal(SymbolTable table) {
        // If already sealed, do nothing
        if (this.isSealed) {
            return;
        }

        // Seal all incomplete phi operations in the block
        for (Entry<String, IRPhiOperation> entry : this.incompletePhi.entrySet()) {
            String variable = entry.getKey();
            IRPhiOperation phi = entry.getValue();
            for (IRBlock predecessor : this.getPredecessors()) {
                phi.addOperand(table.lookup(variable, predecessor));
            }
        }
        this.isSealed = true;
    }
    public boolean isSealed() {
        return this.isSealed;
    }
    
    @Override
    public Object accept(IRVisitor v) {
        return v.visitBlock(this);
    }

}
