package compiler;

import static org.junit.jupiter.api.Assertions.*;

import compiler.frontend.IRBuilder;
import ir.core.IRTopLevel;
import ir.importExport.IRExport;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import compiler.Compiler;
import compiler.frontend.SimpleCPrinter;

import java.io.File;

class testIRImport {

	private void testIRImport(String path) {
		String contentInit = Compiler.readFile(path);

		System.out.println("----- " + "Content from - " + path + " -----");
		System.out.println("----- ----- -----");

		ParseTree tree = Compiler.parse(contentInit);

		SimpleCPrinter astPrinter = new SimpleCPrinter();
		String genContent = astPrinter.visit(tree);
		System.out.println("----- Content Parsed -----");
		System.out.println(genContent);
		System.out.println("----- -----");
		IRTopLevel top = IRBuilder.buildTopLevel(tree);
		System.out.println("----- IR Built -----");
		System.out.println(IRExport.printIR(top));
		System.out.println("----- -----");
	}
	@Test
	void testAllFilesIRImport() {
		String path = "src/test/resources";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				if (file.getPath().equals("src/test/resources/add.sc")) {
					testIRImport(file.getPath());
				}
			}
		}
	}
}