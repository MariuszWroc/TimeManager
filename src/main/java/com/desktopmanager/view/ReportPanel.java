package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author Mariusz Czarny
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public final class ReportPanel extends JPanel {
	private JTable reportTable;
	private JScrollPane scrollpane;
	private DefaultTableModel tableModel = new DefaultTableModel();

	public ReportPanel() {
		reportTable = new JTable();
		String[] columnNames = { "Zdarzenie", "Start", "Koniec"};
		tableModel.setColumnIdentifiers(columnNames);
		reportTable.setModel(tableModel);
		scrollpane = new JScrollPane(reportTable);
		reportTable.setFillsViewportHeight(true);
		buildPanel();
	}

	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g", "t:p:g, b:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();
		builder.add(reportTable.getTableHeader(), cc.xy(1, 1));
		builder.add(scrollpane, cc.xy(1, 2));

		return add(builder.getPanel());
	}

	public JTable getReportTable() {
		return reportTable;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

}
