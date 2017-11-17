package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

@SuppressWarnings({ "serial", "deprecation" })
public class AcceptButtonPanel extends JPanel{
	private final JButton acceptButton;
	
	public AcceptButtonPanel() {
		acceptButton = new JButton("OK");
		UISettingsHelper.setDimension(100, 20).setJButtonSize(acceptButton);
		
		buildButtonPanel();
	}
	
	public Component buildButtonPanel() {
		FormLayout layout = new FormLayout("c:p:g", "t:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		builder.add(acceptButton, cc.xy(1, 1));
		
		return add(builder.getPanel());
	}

	public JButton getAcceptButton() {
		return acceptButton;
	}
	
}
