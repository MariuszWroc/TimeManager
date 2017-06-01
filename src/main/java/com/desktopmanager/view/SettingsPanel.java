package com.desktopmanager.view;

import java.awt.Component;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author czarnym
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public final class SettingsPanel extends JPanel{
	private final JFileChooser fileChooser = new JFileChooser();
	
	public SettingsPanel() {
	}

	public Component buildPanel() {
		FormLayout layout = new FormLayout("c:p:g, 3dlu, c:p:g", "p:g, t:p:g");
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		builder.add(fileChooser, cc.xy(1, 1));
		builder.add(fileChooser, cc.xy(3, 1));
		builder.add(fileChooser, cc.xy(1, 2));
		
		return add(builder.getPanel());
	}
}
