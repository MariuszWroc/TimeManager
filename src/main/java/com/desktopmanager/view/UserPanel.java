package com.desktopmanager.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

@SuppressWarnings({"serial", "deprecation"})
public class UserPanel extends JPanel {
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;

	public UserPanel() {
		firstNameTextField = new JTextField();
		firstNameTextField.setPreferredSize(new Dimension(200, 20));
		lastNameTextField = new JTextField();
		lastNameTextField.setPreferredSize(new Dimension(200, 20));
		buildPanel();
	}
	
	
	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g, c:p:g", "p:g, 3dlu,t:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		builder.addLabel("first name", cc.xy(1, 1));
		builder.add(firstNameTextField, cc.xy(2, 1));
		builder.addLabel("last name", cc.xy(1, 3));
		builder.add(lastNameTextField, cc.xy(2, 3));
		
		return add(builder.getPanel());
	}
}
