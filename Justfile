build:
	gradle :generateGrammarSource
	gradle :compileJava
	gradle :processResources
	gradle :classes
	gradle java :main.compiler.Compiler

compile source: build
	
