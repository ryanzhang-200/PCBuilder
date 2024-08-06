package ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import exceptions.NoPartException;
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
import model.PC;

public class PCui extends JInternalFrame {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 300;
    private static final int LOC = 100;
    private PC pc;
    private Graphics graphics;
    
    private JTextField displayPcName;
    private JTextField pcCase;
    private JTextField pcCooler;
    private JTextField pcCPU;
    private List<JTextField> pcGPU;
    private List<JTextField> pcMonitor;
    private JTextField pcMotherboard;
    private JTextField pcOperatingSystem;
    private JTextField pcPowerSupply;
    private List<JTextField> pcRam;
    private List<JTextField> pcStorage;
    private String pcName;
    private ImageIcon pcImage;
    private int pcNum = 1;
	
	/**
	 * Constructor sets up user interface for a given pc
	 * @param pc   the pc
	 * @param parent  the parent component
	 */
    public PCui(PC pc, Component parent) {
        super(pc.getName(), true, true, true, false);
        this.pc = pc;
        pcName = pc.getName();
        
        displayPcName = new JTextField("name:" + pcName);
        displayPcName.setEditable(false);
        displayPcName.setAlignmentX(CENTER_ALIGNMENT);
        writePartsNamesFirstHalf(pc);
        writePartsNamesSecondHalf(pc);
        writePartsNamesThirdHalf(pc);
        Container cp = getContentPane();  
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(displayPcName);
        printImage(cp);
        displayPartsNames(cp);
        setSize(WIDTH, HEIGHT);
        pcNum++;
        setPosition(parent);
        setVisible(true);
    }

    /**
     * Puts ImageIcon into the Frame and transforms it
     */
    protected void printImage(Container cp) {
        ImageIcon pcImage = new ImageIcon("images/PCImg.jpg"); 
        Image image = pcImage.getImage();
        Image newimg = image.getScaledInstance(60,  60, java.awt.Image.SCALE_SMOOTH); 
        pcImage = new ImageIcon(newimg); 
        cp.add(new JLabel(pcImage));
        setVisible(true);
    }

    /**
     * Creates an ImageIcon if the path is valid.
     */
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = PCui.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
	 * Stores the JTextFields to the individual part names
	 * @param pc   the pc
     * @param pc   the container
	 */
    public void writePartsNamesFirstHalf(PC pc) {
        try {
            writeCaseName(pc);
        } catch (NoPartException e) {
            pcCase = new JTextField("Case: BLANK");
        }
        try {
            writeCoolerName(pc);
        } catch (NoPartException e) {
            pcCooler = new JTextField("Cooler: BLANK");
        }
        try {
            writeCpuName(pc);
        } catch (NoPartException e) {
            pcCPU = new JTextField("CPU: BLANK");
        }
        try {
            writeGpuNames(pc);
        } catch (NoPartException e) {
            pcGPU = new ArrayList<>();
            pcGPU.add(new JTextField("GPU 1: BLANK"));
        }
    }

    /**
	 * Stores the JTextFields to the individual part names the brilliant sequal
	 * @param pc   the pc
     * @param pc   the container
	 */
    public void writePartsNamesSecondHalf(PC pc) {
        try {
            writeMonitorNames(pc);
        } catch (NoPartException e) {
            pcMonitor = new ArrayList<>();
            pcMonitor.add(new JTextField("Monitor 1: BLANK"));
        }

        try {
            writeMotherboardName(pc);
        } catch (NoPartException e) {
            pcMotherboard = new JTextField("Motherboard: BLANK");
        }

        try {
            writeOperatingSystemName(pc);
        } catch (NoPartException e) {
            pcOperatingSystem = new JTextField("Operating System: BLANK");
        }
    }

    /**
	 * Stores the JTextFields to the individual part names the shitty trilogy
	 * @param pc   the pc
     * @param pc   the container
	 */
    public void writePartsNamesThirdHalf(PC pc) {
        try {
            writePowerSupplyName(pc);
        } catch (NoPartException e) {
            pcPowerSupply = new JTextField("Power Supply: BLANK");
        }

        try {
            writeRamNames(pc);
        } catch (NoPartException e) {
            pcRam = new ArrayList<>();
            pcRam.add(new JTextField("RAM 1: BLANK"));
        }

        try {
            writeStorageNames(pc);
        } catch (NoPartException e) {
            pcStorage = new ArrayList<>();
            pcStorage.add(new JTextField("Storage 1: BLANK"));
        }
    }

     /**
	 * Stores the JTextFields for the Case model
	 * @param pc   the pc
	 */
    public void writeCaseName(PC pc) throws NoPartException {
        if (pc.getCase() == null) {
            throw new NoPartException();
        }
        pcCase = new JTextField("Case: " + pc.getCase().getModel());
        pcCase.setEditable(false);
        pcCase.setAlignmentX(CENTER_ALIGNMENT);
    }

    /**
	 * Stores the JTextFields for the Cooler model
	 * @param pc   the pc
	 */
    public void writeCoolerName(PC pc) throws NoPartException {
        if (pc.getCooler() == null) {
            throw new NoPartException();
        }
        pcCooler = new JTextField("Cooler: " + pc.getCooler().getModel());
        pcCooler.setEditable(false);
        pcCooler.setAlignmentX(CENTER_ALIGNMENT);
    }

    /**
	 * Stores the JTextFields for the CPU model
	 * @param pc   the pc
	 */
    public void writeCpuName(PC pc) throws NoPartException {
        if (pc.getCPU() == null) {
            throw new NoPartException();
        }
        pcCPU = new JTextField("CPU: " + pc.getCPU().getModel());
        pcCPU.setEditable(false);
        pcCPU.setAlignmentX(CENTER_ALIGNMENT);
    }

    /**
	 * Stores the JTextFields for the GPU models
	 * @param pc   the pc
	 */
    public void writeGpuNames(PC pc) throws NoPartException {
        if (pc.getGPU().isEmpty()) {
            throw new NoPartException();
        }
        List<GPU> gpus = pc.getGPU();
        int counter = 1;
        JTextField textGPU;
        for (GPU gpu : gpus) {
            textGPU = new JTextField("GPU" + counter + ": " + gpu.getModel());
            textGPU.setEditable(false);
            textGPU.setAlignmentX(CENTER_ALIGNMENT);
            pcGPU.add(textGPU);
            counter++;
        }
    }

    /**
	 * Stores the JTextFields for the Monitor models
	 * @param pc   the pc
	 */
    public void writeMonitorNames(PC pc) throws NoPartException {
        if (pc.getMonitor().isEmpty()) {
            throw new NoPartException();
        }
        List<Monitor> monitors = pc.getMonitor();
        int counter = 1;
        JTextField textMonitor;
        for (Monitor monitor : monitors) {
            textMonitor = new JTextField("GPU" + counter + ": " + monitor.getModel());
            textMonitor.setEditable(false);
            textMonitor.setAlignmentX(CENTER_ALIGNMENT);
            pcMonitor.add(textMonitor);
            counter++;
        }
    }

    /**
	 * Stores the JTextFields for the Motherboard model
	 * @param pc   the pc
	 */
    public void writeMotherboardName(PC pc) throws NoPartException {
        if (pc.getMotherboard() == null) {
            throw new NoPartException();
        }
        pcMotherboard = new JTextField("Motherboard: " + pc.getMotherboard().getModel());
        pcMotherboard.setEditable(false);
        pcMotherboard.setAlignmentX(CENTER_ALIGNMENT);
    }

    /**
	 * Stores the JTextFields for the Operating System model
	 * @param pc   the pc
	 */
    public void writeOperatingSystemName(PC pc) throws NoPartException {
        if (pc.getOperatingSystem() == null) {
            throw new NoPartException();
        }
        pcOperatingSystem = new JTextField("Operating System: " + pc.getOperatingSystem().getSystemName());
        pcOperatingSystem.setEditable(false);
        pcOperatingSystem.setAlignmentX(CENTER_ALIGNMENT);
    }

    /**
	 * Stores the JTextFields for the Power Supply model
	 * @param pc   the pc
	 */
    public void writePowerSupplyName(PC pc) throws NoPartException {
        if (pc.getPowerSupply() == null) {
            throw new NoPartException();
        }
        pcPowerSupply = new JTextField("Power Supply: " + pc.getPowerSupply().getModel());
        pcPowerSupply.setEditable(false);
        pcPowerSupply.setAlignmentX(CENTER_ALIGNMENT);
    }

    /**
	 * Stores the JTextFields for the RAM models
	 * @param pc   the pc
	 */
    public void writeRamNames(PC pc) throws NoPartException {
        if (pc.getRAM().isEmpty()) {
            throw new NoPartException();
        }
        List<RAM> rams = pc.getRAM();
        int counter = 1;
        JTextField textRam;
        for (RAM ram : rams) {
            textRam = new JTextField("RAM" + counter + ": " + ram.getModel());
            textRam.setEditable(false);
            textRam.setAlignmentX(CENTER_ALIGNMENT);
            pcRam.add(textRam);
            counter++;
        }
    }

    /**
	 * Stores the JTextFields for the Storage models
	 * @param pc   the pc
	 */
    public void writeStorageNames(PC pc) throws NoPartException {
        if (pc.getStorage().isEmpty()) {
            throw new NoPartException();
        }
        List<Storage> storages = pc.getStorage();
        int counter = 1;
        JTextField textStorage;
        for (Storage storage : storages) {
            textStorage = new JTextField("GPU" + counter + ": " + storage.getModel());
            textStorage.setEditable(false);
            textStorage.setAlignmentX(CENTER_ALIGNMENT);
            pcStorage.add(textStorage);
            counter++;
        }
    }

    /**
	 * Displays the individual part names
	 * @param pc   the pc
     * @param pc   the container
	 */
    public void displayPartsNames(Container cp) {
        cp.add(pcCase);
        cp.add(pcCooler);
        cp.add(pcCPU);
        displayGpuNames(cp);
        displayMonitorNames(cp);
        cp.add(pcMotherboard);
        cp.add(pcOperatingSystem);
        cp.add(pcPowerSupply);
        displayRamNames(cp);
        displayStorageNames(cp);
    }

    /**
	 * Display all the GPU models
	 * @param pc   the pc
	 */
    public void displayGpuNames(Container cp) {
        for (JTextField text : pcGPU) {
            cp.add(text);
        } 
    }
	
    /**
	 * Display all the Monitor models
	 * @param pc   the pc
	 */
    public void displayMonitorNames(Container cp) {
        for (JTextField text : pcMonitor) {
            cp.add(text);
        } 
    }

    /**
	 *  Display all the Ram models
	 * @param pc   the pc
	 */
    public void displayRamNames(Container cp) {
        for (JTextField text : pcRam) {
            cp.add(text);
        } 
    }

    /**
	 *  Display all the Storage models
	 * @param pc   the pc
	 */
    public void displayStorageNames(Container cp) {
        for (JTextField text : pcStorage) {
            cp.add(text);
        } 
    }

    /**
	 * Sets the position of this PC UI relative to parent component
	 * @param parent  the parent component
	 */
    private void setPosition(Component parent) {
        setLocation(LOC * pcNum, parent.getHeight() / 2 + LOC * pcNum / 5);
    }
}
