package game.input;

public class GameKey{
	private KeyType _keyType;
	private boolean _isPressed;
	private int _pressCount = 0;
	private int _lastPress = -1;

	public GameKey(KeyType keyType)
	{
		this._keyType = keyType;
	}
	public KeyType getType()
	{
		return _keyType;
	}
	public boolean isPressed() {
		return _isPressed;
	}
	public void setPressed() {
		this._isPressed = true;
	}
	public void setReleased()
	{
		this._isPressed = false;
		this._pressCount++;
	}
	public int pressCount() {
		return _pressCount;
	}
	public int pressLastCount() {
		return _lastPress;
	}
	public void setLastPress(int _lastPress) {
		this._lastPress = _lastPress;
	}

}