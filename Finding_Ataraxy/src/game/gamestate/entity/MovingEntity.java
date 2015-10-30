package game.gamestate.entity;

public class MovingEntity extends Entity{

	//name of MovingEntity
	String _name;
	//life of MovingEntity
	Life _life;
	//direction the character is facing or was moving
	protected FacingDirection _facingDirection;
	//current type of movement the character is performing
	protected MovingType _movingType;

	protected double vX, vY, offsetX, offsetY;

	public MovingEntity(String name, Life life, EntityBox entityBox)
	{
		_name = name;
		_life = life;
		_entityBox = entityBox;
		_facingDirection = FacingDirection.South;
		_movingType = MovingType.Idle;
	}

	protected void setFacingDirection(FacingDirection facingDirection)
	{
		_facingDirection = facingDirection;
	}
	protected void setMovingType(MovingType movingType)
	{
		_movingType = movingType;
	}
	protected FacingDirection getFacingDirection()
	{
		return _facingDirection;
	}
	protected MovingType getMovingDirection()
	{
		return _movingType;

	}
	public int getHealth()
	{
		return _life.getHealth();
	}
	public int getMaxHealth()
	{
		return _life.getMaxHealth();
	}
	public void remmoveHealth(int damage)
	{
		_life.removeHealth(damage);
	}

	@Override
	public void update() {

	}

	@Override
	public boolean collide(Entity entity) {
		return false;
	}
}
