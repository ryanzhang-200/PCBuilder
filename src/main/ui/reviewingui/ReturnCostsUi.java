package ui.reviewingui;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import model.parts.GPU;
import model.parts.Monitor;
import model.parts.RAM;
import model.parts.Storage;
import model.PC;

public class ReturnCostsUi extends JInternalFrame {
    private PC pc;
    private String pcName;
    private JTextField displayPcName;

    /**
	 * EFFECTS: Constructor sets up button panel and window for showing the total cost
     * and the individual costs of the parts from the PC
     * @param pc   the pc
	 */
    public ReturnCostsUi(PC pc) {
        super(pc.getName(), true, true, true, false);
        this.pc = pc;
        pcName = pc.getName();
        displayPcName = new JTextField("name:" + pcName);
        displayPcName.setEditable(false);
        displayPcName.setAlignmentX(CENTER_ALIGNMENT);
        Container cp = getContentPane();  
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(displayPcName);
        displayPartsCosts(cp);
        // cp.add(pcCase);

        setSize(WIDTH, HEIGHT);
        setLocation(100, 100);
        setVisible(true);
    }

    public void displayPartsCosts(Container cp) {
        displayGpuCost(cp);
        displayMonitorCost(cp);
       
        displayRamCost(cp);
        displayStorageCost(cp);
        int total = pc.costSingles() + pc.costsMultiples();
        returnCostFirstHalf(cp);
        returnCostSecondHalf(cp);
        cp.add(new JTextField("Total Cost: " + total + "$"));
    }

    //EFFECTS: displays each GPU unit individually
    private void displayGpuCost(Container cp) {
        int counter = 1;
        for (GPU gpu : pc.getGPU()) {
            cp.add(new JTextField("GPU " + counter + ": " + gpu.getCost() + "$"));
            counter++;
        }
    }

    //EFFECTS: displays each Monitor unit individually
    private void displayMonitorCost(Container cp) {
        int counter = 1;
        for (Monitor monitor : pc.getMonitor()) {
            cp.add(new JTextField("Monitor " + counter + ": " + monitor.getCost() + "$"));
            counter++;
        }
    }

    //EFFECTS: displays each RAM unit individually
    private void displayRamCost(Container cp) {
        int counter = 1;
        for (RAM ram : pc.getRAM()) {
            cp.add(new JTextField("RAM " + counter + ": " + ram.getCost() + "$"));
            counter++;
        }
    }

    //EFFECTS: displays each storage unit individually
    private void displayStorageCost(Container cp) {
        int counter = 1;
        for (Storage storage : pc.getStorage()) {
            cp.add(new JTextField("Storage " + counter + ": " + storage.getCost() + "$"));
            counter++;
        }
    }

    //EFFECTS: displays one half of the cost of an individual computer
    public void returnCostFirstHalf(Container cp) {
        if (pc.getCase() != null) {
            cp.add(new JTextField("Case: " + pc.getCase().getCost() + "$"));
        }
        if (pc.getCooler() != null) {
            cp.add(new JTextField("Cooler: " + pc.getCooler().getCost() + "$"));
        }
        if (pc.getCPU() != null) {
            cp.add(new JTextField("CPU: " + pc.getCPU().getCost() + "$"));
        }
        displayGpuCost(cp);
        displayMonitorCost(cp);
        displayRamCost(cp);
        displayStorageCost(cp);
    }

    //EFFECTS: displays the other half of the cost of an individual computer
    public void returnCostSecondHalf(Container cp) {
        if (pc.getMotherboard() != null) {
            cp.add(new JTextField("Motherboard: " + pc.getMotherboard().getCost() + "$"));
        }
        if (pc.getOperatingSystem() != null) {
            cp.add(new JTextField("OperatingSystem: " + pc.getOperatingSystem().getCost() + "$"));
        }
        if (pc.getPowerSupply() != null) {
            cp.add(new JTextField("PowerSupply: " + pc.getPowerSupply().getCost() + "$"));
        }
    }
}
