package model.persistence;

import model.PC;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPC(String name, PC pc) {
        assertEquals(name, pc.getName());
    }
}