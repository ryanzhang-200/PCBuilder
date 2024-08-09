package exceptions;

import model.PC;

public class DuplicatePCException extends Exception {
    public DuplicatePCException(PC pc) {
        super("There is already a PC named: " + pc.getName());
    }
}
