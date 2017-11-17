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
	private final UserPanel userPanel = new UserPanel();
	private final JMenuItem loadItem = new JMenuItem("Load file");
	private final JMenuItem saveItem = new JMenuItem("Save file");
	private final JMenuItem settingsItem = new JMenuItem("Choose file");
	private final JMenuItem userItem = new JMenuItem("User profile");
	private final JMenuItem startItem = new JMenuItem("Start");
	private final JMenuItem stopItem = new JMenuItem("Stop");
	private final JMenuItem actualDayItem  = new JMenuItem("Actual day");
	private final JMenuItem actualMonthItem  = new JMenuItem("Actual month");

	public ApplicationFrame() {
		addMenuBar();
		
		getContentPane().add(mainPanel , BorderLayout.CENTER);
	}

	private void addMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu settingsMenu = setSettings();
		JMenu timerMenu = setTimer();
		JMenu calendarMenu = setCalendar();
		
		menuBar.add(settingsMenu);
		menuBar.add(timerMenu);
		menuBar.add(calendarMenu);
		
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
		settingsMenu.add(userItem);
		
		return settingsMenu;
	}
	
	private JMenu setCalendar() {
		JMenu calendarMenu = new JMenu("Calendar");

		calendarMenu.add(actualDayItem);
		calendarMenu.add(actualMonthItem);
		
		return calendarMenu;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	public UserPanel getUserPanel() {
		return userPanel;
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
	
	public JMenuItem getUserItem() {
		return userItem;
	}

	public JMenuItem getStartItem() {
		return startItem;
	}

	public JMenuItem getStopItem() {
		return stopItem;
	}

	public JMenuItem getActualDayItem() {
		return actualDayItem;
	}

	public JMenuItem getActualMonthItem() {
		return actualMonthItem;
	}

}
