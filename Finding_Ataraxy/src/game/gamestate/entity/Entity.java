package game.gamestate.entity;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Entity{

	EntityBox _entityBox;
	protected double _x;
	protected double _y;
	protected List<Image> _imageStates = new ArrayList<>();
	protected ImageView _entityFrame;

	public Entity()
	{

	}
	public abstract  void update();
	public abstract boolean collide(Entity entity);
}
