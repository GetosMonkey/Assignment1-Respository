
JAVAC = javac
JAVA = java

SRC_DIR = src
BIN_DIR = bin
DOC_DIR = doc

SRC_FILES = $(wildcard $(SRC_DIR)/*.java)

CLASS_FILES = $(patsubst $(SRC_DIR)/%.java, $(BIN_DIR)/%.class, $(SRC_FILES))

# default
all: $(CLASS_FILES)

# Compilation
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(BIN_DIR)
	cd $(SRC_DIR) && $(JAVAC) -d ../$(BIN_DIR) $(notdir $<)

# Generate Javadoc
javadoc:
	@mkdir -p $(DOC_DIR)
	javadoc -d $(DOC_DIR) -sourcepath $(SRC_DIR) $(SRC_FILES)

# Run GenericsKbBSTApp
run-bst: all
	$(JAVA) -cp $(BIN_DIR) GenericsKbBSTApp

# Run GenericsKbArrayApp
run-array: all
	$(JAVA) -cp $(BIN_DIR) GenericsKbArrayApp

# Clean rule
clean:
	rm -rf $(BIN_DIR)/* $(DOC_DIR)/*
