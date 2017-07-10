package com.desktopmanager.view;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ReportTableModel extends DefaultTableModel {
	
	public ReportTableModel() {
		String[] columnNames = { "Zdarzenie", "Start", "Koniec"};
		this.setColumnIdentifiers(columnNames);
	}

	@Override
    public boolean isCellEditable(int row, int column){  
        return false;  
    }

}
