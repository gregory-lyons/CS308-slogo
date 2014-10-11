package Commands;

public class ConstantCommand extends Command {
	
	public final Double myValue;

	public ConstantCommand(Command parent, Double value) {
		super(parent);
		myValue = value;
		// TODO Auto-generated constructor stub
	}

}
