package framework.ui;

import javafx.scene.Node;

public interface IGUIFactory {

	public abstract Node getHeaderPane();

	public abstract Node getRightPane();

	public abstract Node getContentPane();

}