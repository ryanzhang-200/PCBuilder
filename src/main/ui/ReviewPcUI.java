package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.rmi.Remote;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import exceptions.PartAlreadyThereException;
import model.PC;
import model.PCLists;
import model.parts.Case;
import ui.reviewingPcUi.AddPartUi;
import ui.reviewingPcUi.ChangeNameUi;
import ui.reviewingPcUi.RemovePartUi;
import ui.reviewingPcUi.ReturnCostsUi;

public class ReviewPCui extends JInternalFrame {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 400;
    private JInternalFrame controlPanel;
    private JDesktopPane desktop1;
    private String part;
    private PC pc;
    private JTextField displayPcName;
    private String pcName;
    private Component parent;

    /**
	 * Constructor sets up button panel and window for reviewing individual PCs
     * gives the options to add part, remove part, return costs and change name
     * @param pc   the pc
	 * @param parent  the parent component
	 */
    public ReviewPCui(PC pc, Component parent) throws PartAlreadyThereException {
        super(pc.getName(), true, true, true, false);
        this.pc = pc;
        this.parent = parent;

        desktop1 = new JDesktopPane();
        desktop1.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
        controlPanel.setLayout(new BorderLayout());
		
        setContentPane(desktop1);
        setTitle("Reviewing PC");
        setSize(WIDTH, HEIGHT);
		
        addButtonPanel();
		
        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop1.add(controlPanel);
		
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
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
            ReviewPCui.this.requestFocusInWindow();
        }
    }

    /**
	 * Helper to add control buttons to add parts.
	 */
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,1));
        buttonPanel.add(new JButton(new AddPartAction()));
        buttonPanel.add(new JButton(new RemovePartAction()));
        buttonPanel.add(new JButton(new ReturnCostsAction()));
        buttonPanel.add(new JButton(new ChangeNameAction()));
        controlPanel.add(buttonPanel, BorderLayout.WEST);
    }

    /**
	 * Represents the action to be taken when the user wants to add a new
	 * Part to PC. Allows which part to be selected
	 */
    private class AddPartAction extends AbstractAction {

        AddPartAction() {
            super("Add Part");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            desktop1.add(new AddPartUi(pc, parent));
        }
    }

    /**
	 * Represents the action to be taken when the user wants to remove a new
	 * Part to PC. Allows which part to be selected
	 */
    private class RemovePartAction extends AbstractAction {

        RemovePartAction() {
            super("Remove Part");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            desktop1.add(new RemovePartUi(pc, parent));
        }
    }

    /**
	 * Represents the action to be taken when the user wants to return costs
	 * of parts of pc
	 */
    private class ReturnCostsAction extends AbstractAction {

        ReturnCostsAction() {
            super("Return Costs");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    } 

    /**
	 * Represents the action to be taken when the user wants to change pc name
	 * 
	 */
    private class ChangeNameAction extends AbstractAction {

        ChangeNameAction() {
            super("Change Name");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            String part = JOptionPane.showInputDialog(null,
                     "Rename PC",
                        "Enter Name",
                            JOptionPane.QUESTION_MESSAGE);
            pc.namePC(part);
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
