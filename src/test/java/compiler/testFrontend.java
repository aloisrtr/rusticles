package compiler;


import static org.junit.jupiter.api.Assertions.*;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import compiler.Compiler;
import compiler.frontend.IRBuilder;
import compiler.frontend.SimpleCPrinter;
import ir.core.IRTopLevel;

import java.io.File;

class testFrontend {

	private void testFrontend(String path) {
		String contentInit = Compiler.readFile(path);
		ParseTree tree = Compiler.parse(contentInit);
		IRTopLevel top = Compiler.frontend(tree);
		assert(true);//Ok if no exception before
	}
	@Test
	void testAllFilesFrontend() {
		String path = "src/test/resources";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				testFrontend(file.getPath());
			}
		}
	}
}
