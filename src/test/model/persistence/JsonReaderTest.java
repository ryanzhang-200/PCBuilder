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
import persistence.JsonReader;
import persistence.JsonWriter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            PCLists pcList = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPCList.json");
        try {
            PCLists pcList = reader.read();
            assertEquals(0, pcList.returnComputers().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPCList.json");
        try {
            PCLists pcList = reader.read();
            List<PC> thingies = pcList.returnComputers();
            assertEquals(2, thingies.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}