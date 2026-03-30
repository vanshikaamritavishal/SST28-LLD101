# Elevator System - LLD

## Features
- External floor requests
- Internal destination requests
- Elevator dispatching
- Door open/close
- Emergency alarm
- Maintenance mode
- Weight limit modeling
- Elevator states: UP, DOWN, IDLE, UNDER_MAINTENANCE

## Concepts Covered
- OOP design
- Dispatcher pattern
- State handling
- Request processing
- Multi-elevator assignment

## Run
```bash
javac -d out src/enums/*.java src/models/*.java src/services/*.java src/utils/*.java src/Main.java
java -cp out Main
```
