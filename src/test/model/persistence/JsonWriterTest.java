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

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            PCLists wr = new PCLists();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            PCLists pcList = new PCLists();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPCList.json");
            writer.open();
            writer.write(pcList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPCList.json");
            pcList = reader.read();
            assertEquals(0, pcList.returnComputers().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            PCLists pcList = new PCLists();
            pcList.addPC(new PC("pc1"));
            pcList.addPC(new PC("pc2"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPCList.json");
            writer.open();
            writer.write(pcList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPCList.json");
            pcList = reader.read();
            List<PC> pcs = pcList.returnComputers();
            assertEquals(2, pcs.size());
            checkPC("pc1", pcs.get(0));
            checkPC("pc2", pcs.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}