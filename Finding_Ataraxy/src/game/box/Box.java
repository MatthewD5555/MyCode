package game.box;

public class Box {

	private double _x, _y;
	private double _xMax, _yMax;
	private double _width, _height;

	public Box(double x, double y, double width, double height)
	{
		_x = x;
		_y = y;
		_width = width;
		_height = height;
		_xMax = x + width;
		_yMax = y + height;
	}
	public Box()
	{

	}

	public void _setAll(double x, double y, double width, double height)
	{
		_x = x;
		_y = y;
		_width = width;
		_height = height;
		_xMax = x + width;
		_yMax = y + height;
	}
	public void _setXAndY(double x, double y)
	{
		_x = x;
		_y = y;
		_xMax = x + _width;
		_yMax = y + _height;
	}
	public void _setWidthAndHeight(double width, double height)
	{
		_width = width;
		_height = height;
		_xMax = _x + _width;
		_yMax = _y + _height;
	}

	public boolean _isPointWithin(float x, float y)
	{
		return 	(_x < x && _xMax > x && _y < y && _yMax > y);
	}
	public boolean _hasIntersected(Box secondBox)
	{
		boolean x, y;
		if(_x > secondBox.getX())
		{
			x = (_x - secondBox.getX()) < secondBox.getWidth();
		}
		else
		{
			x = (secondBox.getX()- _x) < _width;
		}

		if(_y > secondBox.getY())
		{
			y = (_y - secondBox.getY()) < secondBox.getHeight();
		}
		else
		{
			y = (secondBox.getY()- _y) < _height;
		}

		return x && y;
	}
	public boolean _hasCollided(Box secondBox)
	{
		boolean x = false, y = false;
		if(_x == secondBox.getX() + secondBox.getWidth())
		{
			x = true;
			if(_y > secondBox.getY())
			{
				y = (_y - secondBox.getY()) < secondBox.getHeight();
			}
			else
			{
				y = (secondBox.getY()- _y) < _height;
			}
		}
		else if (_x + _width == secondBox.getX())
		{
			x = true;
			if(_y > secondBox.getY())
			{
				y = (_y - secondBox.getY()) < secondBox.getHeight();
			}
			else
			{
				y = (secondBox.getY()- _y) < _height;
			}
		}
		else if(_y == secondBox.getY() + secondBox.getHeight())
		{
			y = true;
			if(_x > secondBox.getX())
			{
				x = (_x - secondBox.getX()) < secondBox.getWidth();
			}
			else
			{
				x = (secondBox.getX()- _x) < _width;
			}
		}
		else if (_y + _height == secondBox.getY())
		{
			y = true;
			if(_x > secondBox.getX())
			{
				x = (_x - secondBox.getX()) < secondBox.getWidth();
			}
			else
			{
				x = (secondBox.getX()- _x) < _width;
			}
		}
		return x && y;
	}

	public double getX()
	{
		return _x;
	}
	public double getY()
	{
		return _y;
	}
	public double getWidth()
	{
		return _width;
	}
	public double getHeight()
	{
		return _height;
	}
	public double getXMax()
	{
		return _xMax;
	}
	public double getYMax()
	{
		return _yMax;
	}


}
