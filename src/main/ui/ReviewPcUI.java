package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.rmi.Remote;
import java.awt.BorderLayout;
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
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import model.PCLists;

public class ReviewPcUI {
    private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;

    // /**
	//  * Helper to centre main application window on desktop
	//  */
    // private void centreOnScreen() {
    //     int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    //     int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    //     setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    // }

	// /**
	//  * Represents action to be taken when user clicks desktop
	//  * to switch focus. (Needed for key handling.)
	//  */
    // private class DesktopFocusAction extends MouseAdapter {
    //     @Override
    //     public void mouseClicked(MouseEvent e) {
    //         ReviewPcUI.this.requestFocusInWindow();
    //     }
    // }

    // public ReviewPcUI() {
		
    //     desktop = new JDesktopPane();
    //     desktop.addMouseListener(new DesktopFocusAction());
    //     controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
    //     controlPanel.setLayout(new BorderLayout());
		
    //     setContentPane(desktop);
    //     setTitle("CPSC 210: PCBuilder");
    //     setSize(WIDTH, HEIGHT);
		
    //     addButtonPanel();
		
    //     controlPanel.pack();
    //     controlPanel.setVisible(true);
    //     desktop.add(controlPanel);
		
    //     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //     centreOnScreen();
    //     setVisible(true);
    // }

    // /**
	//  * Helper to add control buttons to add parts.
	//  */
    // private void addButtonPanel() {
    //     JPanel buttonPanel = new JPanel();
    //     buttonPanel.setLayout(new GridLayout(10,1));
    //     buttonPanel.add(new JButton(new CaseAction));
    //     buttonPanel.add(new JButton(new CoolerAction));
    //     buttonPanel.add(new JButton(new CpuAction));
    //     buttonPanel.add(new JButton(new GpuAction));
    //     buttonPanel.add(new JButton(new MonitorAction));
    //     buttonPanel.add(new JButton(new MotherboardAction));
    //     buttonPanel.add(new JButton(new OperatingSystemAction));
    //     buttonPanel.add(new JButton(new PowerSupplyAction));
    //     buttonPanel.add(new JButton(new RamAction));
    //     buttonPanel.add(new JButton(new StorageAction));
    //     buttonPanel.add(createPrintCombo());
		
    //     controlPanel.add(buttonPanel, BorderLayout.WEST);
    // }
}
