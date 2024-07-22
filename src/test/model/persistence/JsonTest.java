package model.persistence;

import model.PCLists;
import model.PC;
import model.parts.Case;
import model.parts.Cooler;
import model.parts.CPU;
import model.parts.GPU;
import model.parts.Monitor;
import model.parts.Motherboard;
import model.parts.OperatingSystem;
import model.parts.PowerSupply;
import model.parts.RAM;
import model.parts.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPC(String name, PC pc) {
        assertEquals(name, pc.getName());
    }
}