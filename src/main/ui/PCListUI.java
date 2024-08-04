package ui;

import model.PCLists;
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
import persistence.JsonReader;
import persistence.JsonWriter;
import model.PC;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.rmi.Remote;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import exceptions.DuplicatePCException;

//renders the applications main window frame

public class PCListUI extends JFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 750;
    private static final String FILE_DESCRIPTOR = "...file";
    private static final String SCREEN_DESCRIPTOR = "...screen";
    private PCLists pcLists;
    private PCui input;
    private JComboBox<String> printCombo;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/pclist.json";

    public PCListUI() {
        pcLists = new PCLists();
		
        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
        controlPanel.setLayout(new BorderLayout());
		
        setContentPane(desktop);
        setTitle("CPSC 210: PCBuilder");
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
	 * Helper to add control buttons.
	 */
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,2));
        buttonPanel.add(new JButton(new AddPCAction()));
        buttonPanel.add(new JButton(new SelectedPCAction()));
        buttonPanel.add(new JButton(new ReviewPCAction()));
        buttonPanel.add(new JButton(new RemovePCAction()));
        buttonPanel.add(new JButton(new CopyPCAction()));
        buttonPanel.add(new JButton(new PurchasePCAction()));
        buttonPanel.add(new JButton(new SavePCAction()));
        buttonPanel.add(new JButton(new LoadPCAction()));
        buttonPanel.add(createPrintCombo());
		
        controlPanel.add(buttonPanel, BorderLayout.WEST);
    }

	/**
	 * Helper to create print options combo box
	 * @return  the combo box
	 */
    private JComboBox<String> createPrintCombo() {
        printCombo = new JComboBox<String>();
        printCombo.addItem(FILE_DESCRIPTOR);
        printCombo.addItem(SCREEN_DESCRIPTOR);
        return printCombo;
    }

	/**
	 * Helper to add Input window to main application window
	 */

    private class AddPCAction extends AbstractAction {

        AddPCAction() {
            super("Add PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String pcName = JOptionPane.showInputDialog(null,
                    "PC name?",
                    "Enter PC Name",
                    JOptionPane.QUESTION_MESSAGE);
			
				
            PC pc = new PC(pcName);
            pcLists.addPC(pc);
            desktop.add(new PCui(pc, PCListUI.this));
        }
    }

    private class SelectedPCAction extends AbstractAction {

        SelectedPCAction() {
            super("Select PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String pcName = JOptionPane.showInputDialog(null,
                    "Select PC",
                    "Enter PC Name",
                    JOptionPane.QUESTION_MESSAGE);
			
				
            pcLists.selectPC(pcName);
        }
    }

    private class ReviewPCAction extends AbstractAction {

        ReviewPCAction() {
            super("Review PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }

    private class RemovePCAction extends AbstractAction {

        RemovePCAction() {
            super("Remove PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String pcName = JOptionPane.showInputDialog(null,
                    "Remove PC",
                    "Enter PC Name",
                    JOptionPane.QUESTION_MESSAGE);

            pcLists.removePC(pcName);
        }
    }

    private class CopyPCAction extends AbstractAction {

        CopyPCAction() {
            super("Copy PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            pcLists.copyPC();
        }
    }

    private class PurchasePCAction extends AbstractAction {

        PurchasePCAction() {
            super("Purchase PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
        }
    }

    private class SavePCAction extends AbstractAction {

        SavePCAction() {
            super("Save PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                jsonWriter.open();
                jsonWriter.write(pcLists);
                jsonWriter.close();
                System.out.println("Saved list of PCs to " + JSON_STORE);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }
        }
    }

    private class LoadPCAction extends AbstractAction {

        LoadPCAction() {
            super("Load PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                pcLists = jsonReader.read();
                for (PC pc : pcLists.returnComputers()) {
                    desktop.add(new PCui(pc, PCListUI.this));
                }
            } catch (IOException e) {
                System.out.println("Unable to read from file: " + JSON_STORE);
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
            PCListUI.this.requestFocusInWindow();
        }
    }

	// starts the application
    public static void main(String[] args) {
        new PCListUI();
    }
}