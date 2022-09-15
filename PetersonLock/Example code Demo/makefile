JFLAGS = -g
JC = javac
JVM= java
RM = del
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java
# Leave every thing above this alone

#Replace al the files below this with your files in the classes = 
CLASSES = \
        Main.java \
        MyThread.java \
        PertersonLock.java \
        Scrumboard.java

#leave everything below this alone
MAIN = Main
default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:
        $(RM) *.class