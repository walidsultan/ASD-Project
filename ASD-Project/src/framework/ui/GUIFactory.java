package framework.ui;

import javafx.scene.Node;

public class GUIFactory implements IGUIFactory {

	@Override
	public Node getHeaderPane() {
		return new HeaderPane();
	}

	@Override
	public Node getRightPane() {
		return new RightPane();
	}

	@Override
	public Node getContentPane() {
		return new ContentPane();
	}
}
