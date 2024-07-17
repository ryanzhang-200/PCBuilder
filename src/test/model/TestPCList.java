package model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPCList {
    
    private PCLists testPCList;
    private List<PC> testPCs;
    private PC testSelectedComputer;

    private PC computer1;
    private PC computer2;
    //private PC computer3;

    @BeforeEach
    void runBefore() {
        testPCList = new PCLists();
        testPCs = new ArrayList<>();
        testSelectedComputer = computer1;

        computer1 = new PC("pc1");
        computer2 = new PC("pc2");
    }

    @Test
    void testConstructor() {
        assertTrue(testPCs.isEmpty());
        assertNull(testSelectedComputer);
    }

    @Test
    void testSetSelectedComputerToNull() {
        testPCList.setSelectedComputerToNull();
        assertEquals(testPCList.getSelectedComputer(), null);
    }
    
    @Test
    void testSelectPC() {
        assertEquals(null, testSelectedComputer);
        testPCList.addPC(computer1);
        testPCList.addPC(computer2);
        testPCList.selectPC("pc1");
        testSelectedComputer = testPCList.getSelectedComputer();
        assertEquals(computer1.getName(), testSelectedComputer.getName());
        testPCList.selectPC("what");
        assertEquals(computer1.getName(), testSelectedComputer.getName());
    }

    @Test
    void testAddPC() {
        assertTrue(testPCList.addPC(computer1));
        testPCs.add(computer1);
        PC addingPC = testPCs.get(0);
        assertEquals(computer1.getName(), addingPC.getName());
        assertFalse(testPCList.addPC(computer1));
        assertFalse(testPCList.addPC(computer1));
        assertFalse(testPCList.addPC(computer1));
        assertTrue(testPCList.addPC(computer2));
    }

    @Test
    void testRemovePC() {
        assertFalse(testPCList.removePC("pc1"));
        testPCList.addPC(computer1);
        assertTrue(testPCList.removePC("pc1"));
        assertEquals(testPCs, testPCList.returnComputers());
        testPCList.addPC(computer1);
        testPCs.add(computer1);
        assertFalse(testPCList.removePC("pc2"));

    }

    @Test
    void testCopyPC() {
        assertFalse(testPCList.copyPC());
        assertEquals(testPCs, testPCList.returnComputers());
        testPCList.addPC(computer1);
        assertFalse(testPCList.copyPC());
        testPCList.addPC(computer1);
        testPCList.selectPC("pc1");
        assertTrue(testPCList.copyPC());
        testPCs.add(computer1);
        PC computer1copy = new PC("pc1copy");
        testPCs.add(computer1copy);
        List<PC> testingPClist = new ArrayList<>();
        assertEquals(testPCs.get(0).getName(), testPCList.returnComputers().get(0).getName());
        assertEquals(testPCs.get(1).getName(), testPCList.returnComputers().get(1).getName());
    }
}
