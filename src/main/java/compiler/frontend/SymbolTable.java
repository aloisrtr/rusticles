package compiler.frontend;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.List;

public class SymbolTable {
	private HashMap<String, SymbolTableEntry> table;
	private List<SymbolTable> children;
	
	public SymbolTable() {
		//constructor
	}
	
	public SymbolTable initializeScope(ParserRuleContext ctx) {

		return null;
	}
	
	public void finalizeScope() {
	}
	
	public SymbolTableEntry insert(String name) {
		this.table.put(name, new SymbolTableEntry());
		return this.table.get(name);
	}
	
	public SymbolTableEntry lookup(String name) {
		return this.table.get(name);
	}
}
