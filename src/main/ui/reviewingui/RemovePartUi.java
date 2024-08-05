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

import exceptions.NoPartException;
import model.PC;

public class RemovePartUi extends JInternalFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final String FILE_DESCRIPTOR = "...file";
    private static final String SCREEN_DESCRIPTOR = "...screen";
    private JComboBox<String> printCombo;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private PC pc;

    public RemovePartUi(PC pc, Component parent) {
        super(pc.getName(), true, true, true, false);
        this.pc = pc;

        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Control Panel", false, true, false, false);
        controlPanel.setLayout(new BorderLayout());
		
        setContentPane(desktop);
        setTitle("Removing Parts");
        setSize(WIDTH, HEIGHT);
		
        addButtonPanel();
		
        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);
		
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
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
                if (pc.removeCase()) {
                    pc.removeCase();
                } else {
                    throw new NoPartException();
                }
            } catch (NoPartException e) {
                //Catch
            }
            
        }
    }

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
                if (pc.removeCooler()) {
                    pc.removeCooler();
                } else {
                    throw new NoPartException();
                }
            } catch (NoPartException e) {
                //Catch
            }
        }
    }

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
                if (pc.removeCPU()) {
                    pc.removeCPU();
                } else {
                    throw new NoPartException();
                }
            } catch (NoPartException e) {
                //Catch
            }
        }
    }

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
                if (pc.removeGPU(part)) {
                    pc.removeGPU(part);
                } else {
                    throw new NoPartException();
                }      
            } catch (NoPartException e) {
                //Catch
            }     
        }
    }

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
            pc.removeMonitor(part);  
        }
    }

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
                if (pc.removeMotherboard()) {
                    pc.removeMotherboard();
                } else {
                    throw new NoPartException();
                }   
            } catch (NoPartException e) {
                //Catch
            } 
        }
    }

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
                if (pc.removeOperatingSystem()) {
                    pc.removeOperatingSystem();
                } else {
                    throw new NoPartException();
                }    
            } catch (NoPartException e) {
                //Catch
            }
        }
    }

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
                if (pc.removePowerSupply()) {
                    pc.removePowerSupply();
                } else {
                    throw new NoPartException();
                }    
            } catch (NoPartException e) {
                //Catch
            }
        }
    }

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
                if (pc.removeRAM(part)) {
                    pc.removeRAM(part);
                } else {
                    throw new NoPartException();
                }    
            } catch (NoPartException e) {
                //Catch
            }
        }
    }

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
            pc.removeStorage(part);
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
            RemovePartUi.this.requestFocusInWindow();
        }
    }

    /**
	 * Sets the position of this Reviewing PC UI relative to parent component
	 * @param parent  the parent component
	 */
    private void setPosition(Component parent) {
        setLocation(100, 100);
    }
}
