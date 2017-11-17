package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JPanel;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

@SuppressWarnings({"serial", "deprecation"})
public class UserPanel extends JPanel {
	private final UserFormPanel userFormPanel;
	private final AcceptButtonPanel acceptButtonPanel;

	public UserPanel() {
		userFormPanel = new UserFormPanel();
		acceptButtonPanel = new AcceptButtonPanel();
		buildPanel();
	}
	
	
	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g, c:p:g", "p:g, 6dlu, t:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		builder.add(userFormPanel, cc.xy(2, 1));
		builder.add(acceptButtonPanel, cc.xy(2, 3));
		
		return add(builder.getPanel());
	}

	public UserFormPanel getUserFormPanel() {
		return userFormPanel;
	}

	public AcceptButtonPanel getAcceptButtonPanel() {
		return acceptButtonPanel;
	}
	
}
