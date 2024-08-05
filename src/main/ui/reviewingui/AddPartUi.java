package ui.reviewingui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import exceptions.PartAlreadyThereException;
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
import model.PCLists;

public class AddPartUi extends JInternalFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    private static final String FILE_DESCRIPTOR = "...file";
    private static final String SCREEN_DESCRIPTOR = "...screen";
    private JComboBox<String> printCombo;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private String part;
    private PC pc;

    /**
	 * Constructor sets up button panel and window for adding part to the selected pc
     * gives the options to add part, remove part, return costs and change name
     * @param pc   the pc
	 * @param parent  the parent component
	 */
    public AddPartUi(PC pc, Component parent) {
        super(pc.getName(), true, true, true, false);
        this.pc = pc;

        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame(pc.getName(), false, false, false, false);
        controlPanel.setLayout(new BorderLayout());
		
        setContentPane(desktop);
        setTitle("Adding Parts");
        setSize(WIDTH, HEIGHT);
		
        addButtonPanel();
		
        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);
		
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setLocation(100, 100);
        setVisible(true);
    }

    /**
	 * Helper to add control buttons to add parts.
	 */
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(10,1));
        buttonPanel.add(new JButton(new CaseAction()));
        buttonPanel.add(new JButton(new CoolerAction()));
        buttonPanel.add(new JButton(new CpuAction()));
        buttonPanel.add(new JButton(new GpuAction()));
        buttonPanel.add(new JButton(new MonitorAction()));
        buttonPanel.add(new JButton(new MotherboardAction()));
        buttonPanel.add(new JButton(new OperatingSystemAction()));
        buttonPanel.add(new JButton(new PowerSupplyAction()));
        buttonPanel.add(new JButton(new RamAction()));
        buttonPanel.add(new JButton(new StorageAction()));
        buttonPanel.add(createPrintCombo());
		
        controlPanel.add(buttonPanel, BorderLayout.WEST);
    }

    private JComboBox<String> createPrintCombo() {
        printCombo = new JComboBox<String>();
        printCombo.addItem(FILE_DESCRIPTOR);
        printCombo.addItem(SCREEN_DESCRIPTOR);
        return printCombo;
    }

     /**
	 * adds case, allows user to select model
     * if there is a case, throws PartAlreadyThereException
	 */
    private class CaseAction extends AbstractAction {

        CaseAction() {
            super("Case");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                     "Select Case",
                        "Enter Case Name",
                            JOptionPane.QUESTION_MESSAGE);
            try {
                if (pc.addCase(new Case(part))) {
                    pc.addCase(new Case(part));
                } else {
                    throw new PartAlreadyThereException();
                }
            } catch (PartAlreadyThereException e) {
                //Catch
            }
            
        }
    }

    /**
	 * adds cooler, allows user to select model
     * if there is a cooler, throws PartAlreadyThereException
	 */
    private class CoolerAction extends AbstractAction {

        CoolerAction() {
            super("Cooler");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                    "Select Cooler",
                    "Enter Cooler Name",
                            JOptionPane.QUESTION_MESSAGE);
            try {
                if (pc.addCooler(new Cooler(part))) {
                    pc.addCooler(new Cooler(part));
                } else {
                    throw new PartAlreadyThereException();
                }
            } catch (PartAlreadyThereException e) {
                //Catch
            }
        }
    }

    /**
	 * adds CPU, allows user to select model
     * if there is a CPU, throws PartAlreadyThereException
	 */
    private class CpuAction extends AbstractAction {

        CpuAction() {
            super("CPU");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                    "Select Cpu",
                      "Enter Cpu Name",
                       JOptionPane.QUESTION_MESSAGE);
            try {
                if (pc.addCPU(new CPU(part))) {
                    pc.addCPU(new CPU(part));
                } else {
                    throw new PartAlreadyThereException();
                }
            } catch (PartAlreadyThereException e) {
                     //Catch
            }
        }
    }

    /**
	 * adds GPU, allows user to select model
     * if GPU is maxed out, throws PartAlreadyThereException
	 */
    private class GpuAction extends AbstractAction {

        GpuAction() {
            super("GPU");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                    "Select Case",
                    "Enter Case Name",
                        JOptionPane.QUESTION_MESSAGE);
            try {
                if (pc.addPartsGPU(new GPU(part))) {
                    pc.addPartsGPU(new GPU(part));
                } else {
                    throw new PartAlreadyThereException();
                }      
            } catch (PartAlreadyThereException e) {
                //Catch
            }     
        }
    }

    /**
	 * adds monitor, allows user to select model
	 */
    private class MonitorAction extends AbstractAction {

        MonitorAction() {
            super("Monitor");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                      "Select Monitor",
                      "Enter Monitor Name",
                           JOptionPane.QUESTION_MESSAGE);
            pc.addMonitor(new Monitor(part));  
        }
    }

    /**
	 * adds motherboard, allows user to select model
     * if there is a motherboard, throws PartAlreadyThereException
	 */
    private class MotherboardAction extends AbstractAction {

        MotherboardAction() {
            super("Motherboard");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                         "Select Motherboard",
                     "Enter Motherboard Name",
                        JOptionPane.QUESTION_MESSAGE);
            try {
                if (pc.addMotherboard(new Motherboard(part))) {
                    pc.addMotherboard(new Motherboard(part));
                } else {
                    throw new PartAlreadyThereException();
                }   
            } catch (PartAlreadyThereException e) {
                //Catch
            } 
        }
    }

    /**
	 * adds operating system, allows user to select system
     * if there is a operating system, throws PartAlreadyThereException
	 */
    private class OperatingSystemAction extends AbstractAction {

        OperatingSystemAction() {
            super("Operating System");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                       "Select OperatingSystem",
                         "Enter OperatingSystem Name",
                          JOptionPane.QUESTION_MESSAGE);
            try {
                if (pc.addOperatingSystem(new OperatingSystem(part))) {
                    pc.addOperatingSystem(new OperatingSystem(part));
                } else {
                    throw new PartAlreadyThereException();
                }    
            } catch (PartAlreadyThereException e) {
                //Catch
            }
        }
    }

    /**
	 * adds power supply, allows user to select model
     * if there is a power supply, throws PartAlreadyThereException
	 */
    private class PowerSupplyAction extends AbstractAction {

        PowerSupplyAction() {
            super("Power Supply");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                      "Select Power Supply",
                         "Enter Power Supply Name",
                       JOptionPane.QUESTION_MESSAGE);
            try {
                if (pc.addPowerSupply(new PowerSupply(part))) {
                    pc.addPowerSupply(new PowerSupply(part));
                } else {
                    throw new PartAlreadyThereException();
                }    
            } catch (PartAlreadyThereException e) {
                //Catch
            }
        }
    }

    /**
	 * adds RAM, allows user to select model
     * if RAM is maxed out, throws PartAlreadyThereException
	 */
    private class RamAction extends AbstractAction {

        RamAction() {
            super("RAM");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                    "Select RAM",
                      "Enter RAM Name",
                           JOptionPane.QUESTION_MESSAGE);
            try {
                if (pc.addPartsRAM(new RAM(part))) {
                    pc.addPartsRAM(new RAM(part));
                } else {
                    throw new PartAlreadyThereException();
                }    
            } catch (PartAlreadyThereException e) {
                //Catch
            }
        }
    }

    /**
	 * adds storage, allows user to select model
	 */
    private class StorageAction extends AbstractAction {

        StorageAction() {
            super("Storage");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                     "Select Storage",
                       "Enter Storage Name",
                               JOptionPane.QUESTION_MESSAGE);
            pc.addStorage(new Storage(part));
        }
    }

    /**
	 * Helper to centre main application window on desktop
	 */
    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

	/**
	 * Represents action to be taken when user clicks desktop
	 * to switch focus. (Needed for key handling.)
	 */
    private class DesktopFocusAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            AddPartUi.this.requestFocusInWindow();
        }
    }
}
