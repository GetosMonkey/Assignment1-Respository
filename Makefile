
JAVAC = javac
JAVA = java

SRC_DIR = src
BIN_DIR = bin


SRC_FILES = $(wildcard $(SRC_DIR)/*.java)

CLASS_FILES = $(patsubst $(SRC_DIR)/%.java, $(BIN_DIR)/%.class, $(SRC_FILES))

# default
all: $(CLASS_FILES)

# Compilation
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) -d $(BIN_DIR) $<

# Run GenericsKbBSTApp
run-bst: all
	$(JAVA) -cp $(BIN_DIR) GenericsKbBSTApp

# Run GenericsKbArrayApp
run-array: all
	$(JAVA) -cp $(BIN_DIR) GenericsKbArrayApp

# Clean rule
clean:
	rm -rf $(BIN_DIR)/*