package compiler.frontend;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Optional;
import java.util.Vector;

public class SymbolTable {
	Optional<SymbolTable> mother;
	HashMap<VariableId, VariableInfo> symbols;
	Vector<SymbolTable> children;
	public SymbolTable(Optional<SymbolTable> mother) {
		this.mother = mother;
		children = new Vector<SymbolTable>();
		symbols = new HashMap<VariableId, VariableInfo>();
	}

	public SymbolTable initializeScope(ParserRuleContext ctx) {
		return new SymbolTable(Optional.empty());
	}

	/// Visit BLOCK
	/// symbol_table = initialize(ctx);
	/// Remplit en parcourant les fils du block... (args : mut symbol_table)
	/// finalize(symbol_table);
	public void finalizeScope(SymbolTable children) {
		this.children.add(children);
	}

	public void insert(String name) {
		symbols.put(new VariableId(name), new VariableInfo());
	}

	public Optional<VariableInfo> lookup(VariableId name) {
		if (symbols.containsKey(name)) {
			return Optional.of(symbols.get(name));
		}
		if (mother.isPresent()) {
			return mother.get().lookup(name);
		}
		return Optional.empty();
	}
}