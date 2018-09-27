all help:
	@echo ""
	@echo "Compilation:"
	@echo ""
	@echo "make compile        - Compile the IDL and all Java source code files"
	@echo ""
	@echo "Invocation:"
	@echo ""
	@echo "make start          - Start the server"
	@echo "make stop           - Stop the server"
	@echo "make status         - Get the current status of the server"
	@echo ""
	@echo "Cleanup:"
	@echo ""
	@echo "make clean          - delete temporary files and cleanup directory"
	@echo ""

compile:
	[ -d classes ] || mkdir classes
	[ -d idl ] || mkdir idl
	idlj -fall -td idl -verbose adventure.idl
	javac -cp classes -d classes -g idl/adventure/*.java
	javac -cp classes -d classes -g *.java

start:
	./RoomServer start

stop:
	./RoomServer stop

status:
	./RoomServer status

clean:
	rm -rf classes idl *~
