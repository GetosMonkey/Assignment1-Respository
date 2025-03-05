JAVAC = javac
JAVA = java
SRC = Test.java
CLASS = Test.class

all: $(CLASS)

$(CLASS): $(SRC)
	$(JAVAC) $(SRC)

run: all
	$(JAVA) Test

clean:
	rm -f *.class