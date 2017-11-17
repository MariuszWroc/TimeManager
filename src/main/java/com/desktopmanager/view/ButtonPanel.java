package com.desktopmanager.view;

import java.awt.Component;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author Mariusz Czarny
 *
 */
@SuppressWarnings({ "deprecation", "serial" })
public final class ButtonPanel extends JPanel {
	private final JTextField nameField;
	private final JTextField dateField;
	private final JButton addButton;
	private final JButton updateButton;
	private final JButton removeButton;

	public ButtonPanel() {
		addButton = new JButton("Add");
		UISettingsHelper.setDimension(100, 20).setJButtonSize(addButton);
		removeButton = new JButton("Remove");
		UISettingsHelper.setDimension(100, 20).setJButtonSize(removeButton);
		updateButton = new JButton("Update");
		UISettingsHelper.setDimension(100, 20).setJButtonSize(updateButton);
		nameField = new JTextField();
		UISettingsHelper.setDimension(200, 20).setTextFieldSize(nameField);
		nameField.setToolTipText("Zdarzenie");
		dateField = new JTextField();
		dateField.setText(LocalDateTime.now().toString());
		dateField.setEnabled(false);
		UISettingsHelper.setDimension(200, 20).setTextFieldSize(dateField);
		dateField.setToolTipText("Czas");
		buildPanel();
	}

	public Component buildPanel() {
		FormLayout layout = new FormLayout("l:p:g, 10dlu, c:p:g", "t:p:g, 5dlu, t:p:g, 5dlu, t:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		builder.add(nameField, cc.xy(1, 1));
		builder.add(dateField, cc.xy(1, 3));
		builder.add(addButton, cc.xy(3, 1));
		builder.add(updateButton, cc.xy(3, 3));
		builder.add(removeButton, cc.xy(3, 5));

		return add(builder.getPanel());
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getDateField() {
		return dateField;
	}

}
