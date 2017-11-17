package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author Mariusz Czarny
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public final class ReportPanel extends JPanel {
	private final JTable reportTable;
	private final JScrollPane scrollpane;
	private final ReportTableModel tableModel = new ReportTableModel();
	private final JTextField reportDayTextField;

	public ReportPanel() {
		reportTable = new JTable();
		reportTable.setModel(tableModel);
		scrollpane = new JScrollPane(reportTable);
		reportTable.setFillsViewportHeight(true);
		reportDayTextField = new JTextField();
		UISettingsHelper.setDimension(200, 20).setTextFieldSize(reportDayTextField);
		buildPanel();
	}

	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g, c:p:g", "t:p:g, b:p:g, b:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();
		builder.add(reportTable.getTableHeader(), cc.xy(1, 1));
		builder.add(scrollpane, cc.xy(1, 2));
		builder.addLabel("Report for day: ", cc.xy(1, 3));
		builder.add(reportDayTextField , cc.xy(2, 3));

		return add(builder.getPanel());
	}

	public JTable getReportTable() {
		return reportTable;
	}

	public ReportTableModel getTableModel() {
		return tableModel;
	}

}
