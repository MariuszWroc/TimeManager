package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

@SuppressWarnings({ "serial", "deprecation" })
public class UserFormPanel extends JPanel{
	private static final String LAST_NAME_LABEL = "last name";
	private static final String FIRST_NAME_LABEL = "First name";
	private final JTextField firstNameTextField;
	private final JTextField lastNameTextField;
	
	public UserFormPanel() {
		firstNameTextField = new JTextField();
		UISettingsHelper.setDimension(200, 20).setTextFieldSize(firstNameTextField);
		lastNameTextField = new JTextField();
		UISettingsHelper.setDimension(200, 20).setTextFieldSize(lastNameTextField);
		buildPanel();
	}
	
	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g, 2dlu, c:p:g", "p:g, 6dlu, t:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		builder.addLabel(FIRST_NAME_LABEL, cc.xy(1, 1));
		builder.add(firstNameTextField, cc.xy(3, 1));
		builder.addLabel(LAST_NAME_LABEL, cc.xy(1, 3));
		builder.add(lastNameTextField, cc.xy(3, 3));
		
		return add(builder.getPanel());
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}
	
}
