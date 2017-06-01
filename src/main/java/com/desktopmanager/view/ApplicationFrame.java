package com.desktopmanager.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * @author Mariusz Czarny
 *
 */
@SuppressWarnings("serial")
public class ApplicationFrame extends JFrame{
	private final MainPanel mainPanel = new MainPanel();
	private final JMenuItem loadItem = new JMenuItem("Load file");
	private final JMenuItem saveItem = new JMenuItem("Save file");
	private final JMenuItem settingsItem = new JMenuItem("Choose file");
	private final JMenuItem startItem = new JMenuItem("Start");
	private final JMenuItem stopItem = new JMenuItem("Stop");

	public ApplicationFrame() {
		addMenuBar(setSettings(), setTimer());
		
		getContentPane().add(mainPanel , BorderLayout.CENTER);
	}

	private void addMenuBar(JMenu settingsMenu, JMenu timerMenu) {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(settingsMenu);
		menuBar.add(timerMenu);
		this.setJMenuBar(menuBar);
	}

	private JMenu setTimer() {
		JMenu timerMenu = new JMenu("Timer");

		timerMenu.add(startItem);
		timerMenu.add(stopItem);
		return timerMenu;
	}

	private JMenu setSettings() {
		JMenu settingsMenu = new JMenu("Settings");

		settingsMenu.add(loadItem);
		settingsMenu.add(saveItem);
		settingsMenu.addSeparator();
		settingsMenu.add(settingsItem);
		
		return settingsMenu;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public JMenuItem getLoadItem() {
		return loadItem;
	}

	public JMenuItem getSaveItem() {
		return saveItem;
	}

	public JMenuItem getSettingsItem() {
		return settingsItem;
	}

	public JMenuItem getStartItem() {
		return startItem;
	}

	public JMenuItem getStopItem() {
		return stopItem;
	}
	
}
