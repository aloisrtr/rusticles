package compiler.frontend;

import ir.core.IRValue;
import java.util.HashMap;
import java.util.Optional;
import java.util.Vector;
import java.util.Map.Entry;

public class SymbolTable {
	SymbolTable parent = null;
	HashMap<String, VariableInfo> symbols = new HashMap<>();
	Vector<SymbolTable> children = new Vector<>();

	/// Creates a new symbol table with no children.
	public SymbolTable() {}

	/// Initializes a new symbol table, with this one as parent.
	public SymbolTable initializeScope() {
		SymbolTable child = new SymbolTable();
		child.parent = this;
		return child;
	}

	/// Adds this symbol table to its parent's children list, then returns a reference to said parent.
	/// If this symbol table is the root, it returns null.
	public Optional<SymbolTable> finalizeScope() {
		if (this.parent != null) {
			this.parent.children.add(this);
		}
		return Optional.ofNullable(this.parent);
	}

	/// Inserts a new symbol in the table.
	public void insert(String name, IRValue value) {
		this.symbols.put(name, new VariableInfo(value));
	}

	/// Looks up the information of a symbol in the table.
	public Optional<VariableInfo> lookup(String name) {
		if (this.symbols.containsKey(name)) {
			return Optional.ofNullable(this.symbols.get(name));
		}
		if (this.parent != null) {
			return parent.lookup(name);
		}
		return Optional.empty();
	}

	/// Pretty printing of the symbol table in its current form
	public String toString() {
		if (this.parent == null) {
			return this.toStringInner(0);
		} else {
			return this.parent.toString();
		}
	}

	private String toStringInner(int depth) {
		StringBuilder result = new StringBuilder("-".repeat(depth) + ">\n");
		for (Entry<String, VariableInfo> entry : this.symbols.entrySet()) {
			result.append("+" + "-".repeat(depth) + " " + entry.getKey() + " = " + entry.getValue() + '\n');
		}
		for (SymbolTable child : this.children) {
			result.append(child.toStringInner(depth + 1));
		}
		return result.toString();
	}
}
