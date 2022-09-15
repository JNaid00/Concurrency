JFLAGS = -g
JC = javac
JVM= java
RM = rm
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java
# Leave every thing above this alone

#Replace al the files below this with your files in the classes = 
CLASSES = \
        Main.java \
        Filter.java \
        Transport.java \
		Venue.java

#leave everything below this alone
MAIN = Main
default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:
        $(RM) *.class