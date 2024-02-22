package compiler.frontend;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Optional;
import java.util.Vector;

// typedef VariableId = String;

public class SymbolTable {
	HashMap<VariableId, VariableInfo> symbols;
	Vector<SymbolTable> children;
	public SymbolTable() {
		children = new Vector<SymbolTable>();
		symbols = new HashMap<VariableId, VariableInfo>();
	}

	public SymbolTable initializeScope(ParserRuleContext ctx) {
		return new SymbolTable();
	}

	/// Visit BLOCK
	/// symbol_table = initialize(ctx);
	/// Remplit en parcourant les fils du block... (args : mut symbol_table)
	/// finalize(symbol_table);
	public void finalizeScope(SymbolTable symbolTable) {
		children.add(symbolTable);
	}

	public void insert(String name) {
		symbols.put(new VariableId(name), new VariableInfo());
	}

	public Optional<VariableInfo> lookup(String name) {
		VariableId id = new VariableId(name);
		if (symbols.containsKey(id)) {
			return Optional.of(symbols.get(id));
		}
		return Optional.empty();
	}
}