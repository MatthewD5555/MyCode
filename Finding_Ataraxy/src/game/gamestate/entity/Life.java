package game.gamestate.entity;

public class Life {
	// from 0 to defined max health
	int _health;
	// max health the player can have
	int _maxHealth;
	
	public Life(int startHealth)
	{
		_maxHealth = startHealth;
		_health = startHealth;
	}
	public Life(int startHealth, int maxHealth)
	{
		_maxHealth = maxHealth;
		_health = startHealth;
	}
	
	public void removeHealth(int damage)
	{
		_health -= damage;
	}
	public int getHealth()
	{
		return _health;
	}
	public int getMaxHealth()
	{
		return _maxHealth;
	}
	public boolean isAlive()
	{
		return (_health > 0);
	}
}
