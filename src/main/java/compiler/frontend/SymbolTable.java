package compiler.frontend;

import ir.core.IRBlock;
import ir.core.IRPhiOperation;
import ir.core.IRValue;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

// Handles the local value numbering for variables.
public class SymbolTable {
	HashMap<String, HashMap<IRBlock, IRValue>> symbols = new HashMap<>();

	/// Creates a new symbol table with no children.
	public SymbolTable() {
	}

	/// Inserts a new symbol in the table.
	public void insert(String name, IRBlock block, IRValue value) {
		if (this.symbols.get(name) == null) {
			this.symbols.put(name, new HashMap<>());
		}
		this.symbols.get(name).put(block, value);
	}

	/// Looks up the information of a symbol in the table.
	public IRValue lookup(String name, IRBlock block) {
		// Error on variable not defined previously
		if (this.symbols.get(name) == null) {
			throw new RuntimeException("Tried to lookup variable " + name + " which has never been defined previously");
		}

		IRValue result;
		if (this.symbols.get(name).get(block) != null) {
			// Found result in table
			result = this.symbols.get(name).get(block);
		} else if (!block.isSealed()) {
			// Incomplete CFG
			IRPhiOperation phi = new IRPhiOperation(block);
			block.addIncompletePhi(name, phi);
			result = phi.getResult();
		} else if (block.getPredecessors().size() == 1) {
			// Only one predecessor
			result = this.lookup(name, block.getPredecessors().getFirst());
		} else {
			// Break cycle with phi
			IRPhiOperation phi = new IRPhiOperation(block);
			this.insert(name, block, phi.getResult());

			// Add the operands to phi
			for (IRBlock predecessor : block.getPredecessors()) {
				IRValue pred_value = this.lookup(name, predecessor);
				phi.addOperand(pred_value);
			}
			// Try to remove anything trivial
			// this.simplifyPhi(phi, name);

			block.addOperation(phi);
			result = phi.getResult();
		}

		this.insert(name, block, result);
		return result;
	}
}
