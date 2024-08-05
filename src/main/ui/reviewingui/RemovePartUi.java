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
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import exceptions.NoPartException;
import model.PC;

public class RemovePartUi extends JInternalFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private PC pc;

    /**
	 * Constructor sets up button panel and window for removing parts from the selected pc
     * gives the options to add part, remove part, return costs and change name
     * @param pc   the pc
	 * @param parent  the parent component
	 */
    public RemovePartUi(PC pc, Component parent) {
        super(pc.getName(), true, true, true, false);
        this.pc = pc;

        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame(pc.getName(), false, false, false, false);
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
		
        controlPanel.add(buttonPanel, BorderLayout.WEST);
    }

    /**
	 * removes case, allows user to select model
     * if there is no case, throws NoPartException
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

    /**
	 * removes cooler, allows user to select model
     * if there is no cooler, throws NoPartException
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

    /**
	 * removes cpu, allows user to select model
     * if there is no cpu, throws NoPartException
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

    /**
	 * removes gpu, allows user to select model
     * if there are no gpu, throws NoPartException
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

    /**
	 * removes monitor, allows user to select model
     * if there are no monitor, throws NoPartException
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
            try {
                if (pc.removeMonitor(part)) {
                    pc.removeMonitor(part);
                } else {
                    throw new NoPartException();
                }   
            } catch (NoPartException e) {
                //Catch
            } 
        }
    }

    /**
	 * removes motherboard, allows user to select model
     * if there is no motherboard, throws NoPartException
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

    /**
	 * removes operatingsystem, allows user to select model
     * if there is no operatingsystem, throws NoPartException
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

    /**
	 * removes power supply, allows user to select model
     * if there is no supply, throws NoPartException
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

    /**
	 * removes RAM, allows user to select model
     * if there is no RAM, throws NoPartException
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

    /**
	 * removes storage, allows user to select model
     * if there is no storage, throws NoPartException
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
            try {
                if (pc.removeStorage(part)) {
                    pc.removeStorage(part);
                } else {
                    throw new NoPartException();
                }   
            } catch (NoPartException e) {
                //Catch
            } 
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
