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

//renders the applications main window frame

public class PCListUI extends JFrame {
    private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String FILE_DESCRIPTOR = "...file";
	private static final String SCREEN_DESCRIPTOR = "...screen";
    private PCLists pcLists;
    private JComboBox<String> printCombo;
	private JDesktopPane desktop;
	private JInternalFrame controlPanel;

    public PCListUI() {
		pcLists = new PCLists();
		
		desktop = new JDesktopPane();
		desktop.addMouseListener(new DesktopFocusAction());
		controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
		controlPanel.setLayout(new BorderLayout());
		
		setContentPane(desktop);
		setTitle("CPSC 210: Alarm System Simulator");
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
		buttonPanel.add(new JButton(new ViewPCAction()));
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

	private class AddPCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	private class SelectedPCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	private class ViewPCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	private class ReviewPCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	private class RemovePCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	private class CopyPCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	private class PurchasePCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	private class SavePCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
	}

	private class LoadPCAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
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
