package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.parts.CPU;
import model.parts.Case;
import model.parts.Cooler;
import model.parts.GPU;
import model.parts.Monitor;
import model.parts.Motherboard;
import model.parts.OperatingSystem;
import model.parts.PowerSupply;
import model.parts.RAM;
import model.parts.Storage;


public class TestPC {
    private PC testPC;
    private Case testBox;
    private Cooler testCooler;
    private CPU testProcessor;
    private List<GPU> testGraphicsCard;
    private List<Monitor> testMonitor;
    private Motherboard testMotherboard;
    private OperatingSystem testSystem;
    private PowerSupply testPwrSupply;
    private List<RAM> testMemory;
    private List<Storage> testStorage;

    private PC testPC1;
    private Case testBox1;
    private Cooler testCooler1;
    private CPU testProcessor1;
    private List<GPU> testGraphicsCard1;
    private List<Monitor> testMonitor1;
    private Motherboard testMotherboard1;
    private OperatingSystem testSystem1;
    private PowerSupply testPwrSupply1;
    private List<RAM> testMemory1;
    private List<Storage> testStorage1;


    @BeforeEach
    void runBefore() {
        testPC = new PC("pc1");
        testBox = new Case("case");
        testCooler = new Cooler("cooler");
        testProcessor = new CPU("intel i5");
        testGraphicsCard = new ArrayList<>();
        testMonitor = new ArrayList<>();
        testMotherboard = new Motherboard("mb");
        testSystem = new OperatingSystem("Windows 11");
        testPwrSupply = new PowerSupply("powersupply");
        testMemory = new ArrayList<>();
        testStorage = new ArrayList<>();

        testBox1 = new Case("case0");
        testCooler1 = new Cooler("cooler1");
        testProcessor1 = new CPU("ryzen 5");
        testGraphicsCard1 = new ArrayList<>();
        testMonitor1 = new ArrayList<>();
        testMotherboard1 = new Motherboard("mb0");
        testSystem1 = new OperatingSystem("Linux");
        testPwrSupply1 = new PowerSupply("powersupply0");
        testMemory1 = new ArrayList<>();
        testStorage1 = new ArrayList<>();
    }

    @Test 
    void testConstructor() {
        List[] list;
        assertEquals("pc1", testPC.getName());
        assertEquals(null, testPC.getCase());
        assertEquals(null, testPC.getCooler());
        assertEquals(null, testPC.getCPU());
        assertEquals(testGraphicsCard, testPC.getGPU());
        assertEquals(testMonitor, testPC.getMonitor());
        assertEquals(null, testPC.getMotherboard());
        assertEquals(null, testPC.getOperatingSystem());
        assertEquals(null, testPC.getPowerSupply());
        assertEquals(testMemory, testPC.getRAM());
        assertEquals(testStorage, testPC.getStorage());
    }

    @Test
    void testAddCase() {
        assertTrue(testPC.addCase(testBox));
        assertEquals(testPC.getCase(), testBox);
        assertFalse(testPC.addCase(testBox1));
    }

    @Test
    void testAddCooler() {
        assertTrue(testPC.addCooler(testCooler));
        assertEquals(testPC.getCooler(), testCooler);
        assertFalse(testPC.addCooler(testCooler1));
    }

    @Test
    void testAddCPU() {
        assertTrue(testPC.addCPU(testProcessor));
        assertEquals(testPC.getCPU(), testProcessor);
        assertFalse(testPC.addCPU(testProcessor1));
    }

    @Test
    void testAddMotherboard() {
        assertTrue(testPC.addMotherboard(testMotherboard));
        assertEquals(testPC.getMotherboard(), testMotherboard);
        assertFalse(testPC.addMotherboard(testMotherboard1));
    }

    @Test
    void testAddOperatingSystem() {
        assertTrue(testPC.addOperatingSystem(testSystem));
        assertEquals(testPC.getOperatingSystem(), testSystem);
        assertFalse(testPC.addOperatingSystem(testSystem1));
    }

    @Test
    void testAddPowerSupply() {
        assertTrue(testPC.addPowerSupply(testPwrSupply));
        assertEquals(testPC.getPowerSupply(), testPwrSupply);
        assertFalse(testPC.addPowerSupply(testPwrSupply1));
    }
        
    //originally same function, split it apart into two functions, test is same either way 
    @Test
    void testAddPartsLimitless() {
        Monitor desktop1 = new Monitor("m1");
        Monitor desktop2 = new Monitor("m2");
        testMonitor.add(desktop1);
        testPC.addMonitor(desktop1);
        assertEquals(testPC.getMonitor().get(0), testMonitor.get(0));
        testMonitor.add(desktop2);
        testPC.addMonitor(desktop2);
        assertEquals(testPC.getMonitor().get(1), testMonitor.get(1));

        Storage disk1 = new Storage("d1");
        Storage disk2 = new Storage("d2");
        testStorage.add(disk1);
        testPC.addStorage(disk1);
        assertEquals(testPC.getStorage().get(0), testStorage.get(0));
        testStorage.add(disk2);
        testPC.addStorage(disk2);
        assertEquals(testPC.getStorage().get(1), testStorage.get(1));

    }

    @Test
    void testRemoveCase() {
        assertFalse(testPC.removeCase());
        testPC.setCase(testBox);
        assertTrue(testPC.removeCase());
    }

    @Test
    void testRemoveCooler() {
        assertFalse(testPC.removeCooler());
        testPC.setCooler(testCooler);
        assertTrue(testPC.removeCooler());
    }

    @Test
    void testRemoveCPU() {
        assertFalse(testPC.removeCPU());
        testPC.setCPU(testProcessor);
        assertTrue(testPC.removeCPU());
    }

    @Test
    void testRemoveGPU() {
        testPC.addMotherboard(testMotherboard);
        GPU gcard1 = new GPU("nvidia1000");
        assertFalse(testPC.removeGPU("nvidia1000"));
        testPC.addPartsGPU(gcard1);
        testPC.addPartsGPU(gcard1);
        assertTrue(testPC.removeGPU("nvidia1000"));
        assertFalse(testPC.removeGPU("what"));
    }

    @Test
    void testRemoveMonitor() {
        Monitor desktop1 = new Monitor("m1");
        assertFalse(testPC.removeMonitor("m1"));
        testPC.addMonitor(desktop1);
        testPC.addMonitor(desktop1);
        assertTrue(testPC.removeMonitor("m1"));
        assertFalse(testPC.removeMonitor("what"));
    }

    @Test
    void testRemoveMotherboard() {
        assertFalse(testPC.removeMotherboard());
        testPC.setMotherboard(testMotherboard);
        assertTrue(testPC.removeMotherboard());
    }

    @Test
    void testRemoveOperatingSystem() {
        assertFalse(testPC.removeOperatingSystem());
        testPC.setSystem(testSystem);
        assertTrue(testPC.removeOperatingSystem());
    }

    @Test
    void testRemovePowerSupply() {
        assertFalse(testPC.removePowerSupply());
        testPC.setPowerSupply(testPwrSupply);
        assertTrue(testPC.removePowerSupply());
    }

    @Test
    void testRemoveRAM() {
        testPC.addMotherboard(testMotherboard);
        RAM stick1 = new RAM("cosair 10");
        assertFalse(testPC.removeRAM("cosair 10"));
        testPC.addPartsRAM(stick1);
        testPC.addPartsRAM(stick1);
        assertTrue(testPC.removeRAM("cosair 10"));
        assertFalse(testPC.removeRAM("what"));

    }

    @Test
    void testRemoveStorage() {
        Storage disk1 = new Storage("d1");
        assertFalse(testPC.removeStorage("d1"));
        testPC.addStorage(disk1);
        testPC.addStorage(disk1);
        assertTrue(testPC.removeStorage("d1"));
        assertFalse(testPC.removeStorage("what"));
    }

    @Test
    void testAddPartsRAM() {
        RAM stick1 = new RAM("cosair 10");
        assertFalse(testPC.addPartsRAM(stick1));
        testPC.setMotherboard(testMotherboard);
        assertTrue(testPC.addPartsRAM(stick1));
        assertEquals(stick1, testPC.getRAM().get(0));
        testPC.addPartsRAM(stick1);
        assertFalse(testPC.addPartsRAM(stick1));
        assertEquals(2, testPC.getRAM().size());
    }

    @Test
    void testAddPartsGPU() {
        GPU gcard1 = new GPU("nvidia1000");
        assertFalse(testPC.addPartsGPU(gcard1));
        testPC.setMotherboard(testMotherboard);
        assertTrue(testPC.addPartsGPU(gcard1));
        assertEquals(gcard1, testPC.getGPU().get(0));
        testPC.addPartsGPU(gcard1);
        assertFalse(testPC.addPartsGPU(gcard1));
        assertEquals(2, testPC.getGPU().size());
    }

    @Test
    void testTotalCostsMultiples() {
        assertEquals(0, testPC.costsMultiples());
        Storage disk1 = new Storage("d1");
        Monitor desktop1 = new Monitor("m1");
        RAM stick1 = new RAM("cosair 10");
        GPU gcard1 = new GPU("nvidia1000");
        testPC.getGPU().add(gcard1);
        testPC.getMonitor().add(desktop1);
        testPC.getRAM().add(stick1);
        testPC.getStorage().add(disk1);
        assertEquals(550, testPC.costsMultiples());
    }

    @Test
    void testTotalCostsSingular() {
        assertEquals(testPC.costSingles(), 0);
        testPC.setCase(testBox);
        testPC.setCooler(testCooler);
        testPC.setCPU(testProcessor);
        testPC.setMotherboard(testMotherboard);
        testPC.setSystem(testSystem);
        testPC.setPowerSupply(testPwrSupply);

        assertEquals(testPC.costSingles(), 600);
        

    }

    @Test
    void testNamePC() {
        testPC.namePC("pc2");
        assertEquals("pc2", testPC.getName());
    }
}
