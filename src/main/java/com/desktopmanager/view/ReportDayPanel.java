package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.desktopmanager.logic.TimeCounter;
import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author Mariusz Czarny
 *
 */
@SuppressWarnings({"deprecation", "serial"})
public class ReportDayPanel extends JPanel{
	private final JTextField reportDayLabel;
	
	public ReportDayPanel() {
		this.reportDayLabel = new JTextField();
		UISettingsHelper.setDimension(200, 20).setComponentSize(reportDayLabel);
		reportDayLabel.setText(TimeCounter.getActualDate());
		buildPanel();
	}

	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g, 2dlu, c:p:g", "p:g, 6dlu, t:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		builder.addLabel("Report for day: ", cc.xy(1, 1));
		builder.add(reportDayLabel , cc.xy(3, 1));
		
		return add(builder.getPanel());
	}

	public JTextField getReportDayLabel() {
		return reportDayLabel;
	}
	
}
