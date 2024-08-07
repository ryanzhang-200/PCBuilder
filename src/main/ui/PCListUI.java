package ui;

import model.PCLists;
import persistence.JsonReader;
import persistence.JsonWriter;
import model.Event;
import model.EventLog;
import model.PC;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import exceptions.DuplicatePCException;
import exceptions.LogException;
import exceptions.PartAlreadyThereException;

//renders the applications main window frame

public class PCListUI extends JFrame implements WindowListener {
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;
    private static final String FILE_DESCRIPTOR = "...file";
    private static final String SCREEN_DESCRIPTOR = "...screen";
    private PCLists pcLists;
    private JComboBox<String> printCombo;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/pclist.json";

    /**
	 * Constructor sets up button panel and window
	 */
    public PCListUI() {
        pcLists = new PCLists();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.toString() + "\n");
                } 
            }     
        });
		
        setPCListUi();
        setContentPane(desktop);
        setTitle("PCBuilder");
        setSize(WIDTH, HEIGHT);
		
        addButtonPanel();
		
        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);
		
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
        
    }

    public void setPCListUi() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
		
        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
        controlPanel.setLayout(new BorderLayout());
    }

	/**
	 * Helper to add control buttons.
	 */
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,2));
        buttonPanel.add(new JButton(new AddPCAction()));
        buttonPanel.add(new JButton(new SelectedPCAction()));
        buttonPanel.add(new JButton(new ReviewPCAction()));
        buttonPanel.add(new JButton(new ViewPCAction()));
        buttonPanel.add(new JButton(new RemovePCAction()));
        buttonPanel.add(new JButton(new CopyPCAction()));
        buttonPanel.add(new JButton(new PurchasePCAction()));
        buttonPanel.add(new JButton(new SavePCAction()));
        buttonPanel.add(new JButton(new LoadPCAction()));
        buttonPanel.add(new JButton(new PrintLogAction()));
        //buttonPanel.add(new JButton(new ExitApplicationAction()));
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
	 * Represents the action to be taken when the user wants to add a new
	 * PC to PCLists.
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
        }
    }

    /**
	 * Represents the action to be taken when the user wants to select a new
	 * PC
	 */
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

    /**
	 * Represents the action to be taken when the user wants to review 
	 * Selected PC.
	 */
    private class ReviewPCAction extends AbstractAction {

        ReviewPCAction() {
            super("Review PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            // desktop.add(new PCui(pcLists.getSelectedComputer(), PCListUI.this));
            try {
                desktop.add(new ReviewPCui(pcLists.getSelectedComputer(), PCListUI.this));
            } catch (PartAlreadyThereException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "System Error", 
						JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
	 * Represents the action to be taken when the user wants to view all pcs
	 * from PCLists.
	 */
    private class ViewPCAction extends AbstractAction {

        ViewPCAction() {
            super("View PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            for (PC pc : pcLists.returnComputers()) {
                desktop.add(new PCui(pc, PCListUI.this));
            }
        }
    }

    /**
	 * Represents the action to be taken when the user wants to remove a pc
	 * from pc lists.
	 */
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

    /**
	 * Represents the action to be taken when the user wants to copy a
	 * PC from a PC in PCLists.
	 */
    private class CopyPCAction extends AbstractAction {

        CopyPCAction() {
            super("Copy PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            pcLists.copyPC();
        }
    }

    /**
	 * Represents the action to be taken when the user wants to purchase a new
	 * PC to PCLists.
	 */
    private class PurchasePCAction extends AbstractAction {

        PurchasePCAction() {
            super("Purchase PC");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }

    /**
	 * Represents the action to be taken when the user wants save existing 
	 * PCs in PCLists.
	 */
    private class SavePCAction extends AbstractAction {

        SavePCAction() {
            super("Save PC");
        }

        @Override
        public void actionPerformed(ActionEvent evtv) {
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

    /**
	 * Represents the action to be taken when the user wants to load 
	 * an existing PCList
	 */
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

    private class PrintLogAction extends AbstractAction {
        PrintLogAction() {
            super("Print log to...");
        }
		
        @Override
		public void actionPerformed(ActionEvent evt) {
            String selected = (String) printCombo.getSelectedItem();
            LogPrinter lp;
            try {
                if (selected.equals(FILE_DESCRIPTOR)) {
                    lp = new FilePrinter();
                } else {
                    lp = new ScreenPrinter(PCListUI.this); 
                    desktop.add((ScreenPrinter) lp);
                }
				
                lp.printLog(EventLog.getInstance());
            } catch (LogException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "System Error",
						JOptionPane.ERROR_MESSAGE);
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

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'windowOpened'");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'windowClosed'");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'windowIconified'");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'windowDeiconified'");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'windowActivated'");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'windowDeactivated'");
    }
}