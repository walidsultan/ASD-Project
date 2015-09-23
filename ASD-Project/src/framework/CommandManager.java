package framework;

import java.util.Stack;

public class CommandManager implements ICommandManager {

	private static CommandManager _CommandManager;

	private Stack<ICommand> _Commands;

	private CommandManager() {
		_Commands = new Stack<ICommand>();
	}

	public static CommandManager getInstance() {
		if (_CommandManager == null) {
			_CommandManager = new CommandManager();
		}
		return _CommandManager;
	}

	@Override
	public void submit(ICommand cmd) {
		_Commands.push(cmd);
		cmd.execute();
	}

}
