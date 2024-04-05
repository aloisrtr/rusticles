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
import java.util.Arrays;
import java.util.List;

class testIRImport {
	private void testIRImport(String path, Boolean verbose) {
		String contentInit = Compiler.readFile(path);
		if (verbose) {
			System.out.println("----- " + "Content from - " + path + " -----");
		}
		ParseTree tree = Compiler.parse(contentInit);
		SimpleCPrinter astPrinter = new SimpleCPrinter();
		String genContent = astPrinter.visit(tree);
		if (verbose) {
			System.out.println("----- Content Parsed -----");
			System.out.println(genContent);
		}

		IRTopLevel top = IRBuilder.buildTopLevel(tree);
		if (verbose) {
			System.out.println("----- IR Built -----");
			System.out.println(IRExport.printIR(top));
		}
	}
	@Test
	void testAllFilesIRImport() {
		Boolean verbose = true;
		String path = "src/test/resources";
		File folder = new File(path);
		File[] files = folder.listFiles();
		if (files == null) {
			return;
		}
		List<File> listOfFiles = Arrays.stream(files).sorted().toList();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				try {
					testIRImport(file.getPath(), verbose);
					if (verbose) {
						System.out.println("----- " + "IR Tested" + " -----");
					} else {
						System.out.println("- Ok in " + file.getPath() + "\n");
					}
				} catch (Exception e) {
					if (verbose) {
						System.out.println("#### " + "Error in - " + file.getPath() + " -----");
						e.printStackTrace();
						System.out.println("####");
					} else {
						System.out.println("- Error in " + file.getPath());
					}
				}
			}
		}
	}
}