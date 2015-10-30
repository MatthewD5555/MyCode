package game.input;

public class Input {
	public GameKey[] inputKeys = new GameKey[KeyType.values().length]; // five current types of input

	//add mouse later
	public Input()
	{
		//assignment of keys that matches the declaration of them in the emum
		inputKeys[KeyType.UpArrow.ordinal()] = new GameKey(KeyType.UpArrow);
		inputKeys[KeyType.DownArrow.ordinal()] = new GameKey(KeyType.DownArrow);
		inputKeys[KeyType.LeftArrow.ordinal()] = new GameKey(KeyType.LeftArrow);
		inputKeys[KeyType.RightArrow.ordinal()] = new GameKey(KeyType.RightArrow);
		inputKeys[KeyType.Enter.ordinal()] = new GameKey(KeyType.Enter);
		// add more keys
	}
}