package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JPanel;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author Mariusz Czarny
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public final class MainPanel extends JPanel {
	private final ReportPanel reportPanel;
	private final ButtonPanel buttonPanel;
	
	public MainPanel() {
		this.reportPanel = new ReportPanel();
		this.buttonPanel = new ButtonPanel();
		buildPanel();
	}

	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g, c:p:g", "p:g, 3dlu,t:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		builder.add(reportPanel, cc.xy(1, 1));
		builder.add(buttonPanel, cc.xy(1, 3));
		
		return add(builder.getPanel());
	}

	public ReportPanel getReportPanel() {
		return reportPanel;
	}

	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}

}
