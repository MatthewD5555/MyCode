package game.menustate;

import game.box.Box;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuElement {
	protected ImageView _elementView;
	protected Image[] _elementImages;
	protected StateType _stateType;
	protected Box _box;

	public MenuElement()
	{
		_elementView = new ImageView();
		_elementImages = new Image[3];
		_stateType = StateType.Exit;
		_box = new Box();
	}
	public void initImages(String imageDir, double width, double height)
	{
		_elementImages = new Image[3];
		_elementImages[LabelOptions.Focused.ordinal()] = new Image(imageDir+"Focused.png",width, height, true, false, true);
		_elementImages[LabelOptions.Unfocused.ordinal()] = new Image(imageDir+"Unfocused.png",width, height, true, false, true);
		_elementImages[LabelOptions.Clicked.ordinal()] = new Image(imageDir+"Clicked.png",width, height, true, false, true);
		setWidthAndHeight(width,height);
	}
	public void initImage(String imagefile, double width, double height)
	{
		_elementImages = new Image[1];
		_elementImages[LabelOptions.Focused.ordinal()] = new Image(imagefile ,width, height, true, false, true);
		setWidthAndHeight(width,height);
	}
	public void setImage(double x, double y, LabelOptions labelOptions)
	{
		_elementView.setImage(_elementImages[labelOptions.ordinal()]);
		_elementView.setX(x);
		_elementView.setY(y);
	}
	public void setImage(LabelOptions labelOptions)
	{
		_elementView.setImage(_elementImages[labelOptions.ordinal()]);
	}
	public void setWidthAndHeight(double width, double height)
	{
		_box._setWidthAndHeight(width, height);
		_elementView.setFitWidth(width);
		_elementView.setFitHeight(height);
	}
	public void setXAndY(double x, double y)
	{
		_box._setXAndY(x, y);
		_elementView.setX(x);
		_elementView.setY(y);
	}
	public StateType getStateType() {
		return _stateType;
	}
	public void setStateType(StateType _stateType) {
		this._stateType = _stateType;
	}
	public ImageView getImageView()
	{
		return _elementView;
	}
	public double getX()
	{
		return _box.getX();
	}
	public double getY()
	{
		return _box.getY();
	}
	public double getWidth()
	{
		return _box.getWidth();
	}
	public double getHeight()
	{
		return _box.getHeight();
	}
	public double getXMax()
	{
		return _box.getXMax();
	}
	public double getYMax()
	{
		return _box.getYMax();
	}
}
