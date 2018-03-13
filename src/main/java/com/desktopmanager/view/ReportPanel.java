package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author Mariusz Czarny
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public final class ReportPanel extends JPanel {
	private final ReportDayPanel reportDayPanel;
	private final JTable reportTable;
	private final JScrollPane scrollpane;
	private final ReportTableModel tableModel = new ReportTableModel();

	public ReportPanel() {
		reportDayPanel = new ReportDayPanel();
		reportTable = new JTable();
		reportTable.setModel(tableModel);
		scrollpane = new JScrollPane(reportTable);
		reportTable.setFillsViewportHeight(true);
		buildPanel();
	}

	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g, c:p:g", "t:p:g, b:p:g, b:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();
		builder.add(reportDayPanel , cc.xy(2, 1));
		builder.add(reportTable.getTableHeader(), cc.xy(1, 3));
		builder.add(scrollpane, cc.xy(2, 3));

		return add(builder.getPanel());
	}

	public JTable getReportTable() {
		return reportTable;
	}

	public ReportTableModel getTableModel() {
		return tableModel;
	}

}
