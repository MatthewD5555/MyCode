package game.menustate;

import game.boot.Finding_Ataraxy;
import game.boot.State;
import game.input.KeyType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class MainMenu extends State{
	protected Finding_Ataraxy game;
	private byte _selectIndex = 0;
	private byte menuCount = 4;
	MenuElement[] _elements;
	MenuElement _background;
	String _backImage = "res/menu/background/back.png";
	String _dirImage = "res/menu/label";

	public MainMenu(Finding_Ataraxy mygame)
	{
		game = mygame;
		 _background = new MenuElement();
		 _elements = new MenuElement[menuCount];
	}

	public void createMenuLabels()
	{
//		for(int x = 0; x < menuCount; x++){
//			_elements[x] = new MenuElement();
//			_elements[x].initImages(_dirImage + x + "/", game.scene.getWidth() / 4 , game.scene.getWidth() / 10); // make size proportioned to game screen
//		}
		try{
		_elements[0] = new MenuElement();
		_elements[0].initImages(_dirImage + 0 + "/", (double) game.Screen_Width /10 , (double) game.Screen_Height /15);
		} catch (Exception ex)
		{
			System.out.print("Error: "+ ex);
		}
	}
	public void createBackground()
	{
		try{
			_background.setXAndY(0.0, 0.0);
			_background.initImage("res/menu/background/back.png", (double) game.Screen_Width, (double) game.Screen_Height);
		} catch (Exception ex)
		{
			System.out.print("Error: "+ ex);
		}
	}

	public void setMenuLabels()
	{
//		for(int x = 0; x < menuCount; x++){
//			_elements[x].setImage(10, game.Screen_Height /4 + (_elements[x].getHeight() + 5)* x , LabelOptions.Unfocused);
//		}
		try{
		_elements[0].setImage(10, game.Screen_Height /4 + (_elements[0].getHeight() + 5)* 0 , LabelOptions.Unfocused);
		} catch (Exception ex)
		{
			System.out.print("Error: "+ ex);
		}
	}
	public void setBackground()
	{
		try{
			_background.setImage(LabelOptions.Focused);
		} catch (Exception ex)
		{
			System.out.print("Error: "+ ex.getLocalizedMessage());
		}
	}

	@Override
	public void handle(long now) {
		if(checkNewPressed(KeyType.DownArrow, false))
		{
			setLastPress(KeyType.DownArrow);
			setLabelDownFocus();
			try {Thread.sleep(100);} catch (InterruptedException e){}
		}
		else if(checkNewPressed(KeyType.UpArrow, false))
		{
			setLastPress(KeyType.UpArrow);
			setLabelUpFocus();
			try {Thread.sleep(100);} catch (InterruptedException e){}
		}
		else if(checkNewPressed(KeyType.Enter, true))
		{
			setLastPress(KeyType.Enter);
			labelAction();
			game.stage.setTitle("Time: "+now+" sec") ;
			try {Thread.sleep(100);} catch (InterruptedException e){}
		}
	}
	@Override
	public void start() {
		super.start();
		createBackground();
		createMenuLabels();
		game.root = new Group();
		setBackground();
		setMenuLabels();
		addGroupNodes();
		game.scene = new Scene(game.root);
        game.scene.setFill(Color.BLACK);
	}
    public void addGroupNodes()
    {
    	game.root.getChildren().add(_background.getImageView());
//    	for(MenuElement label : _elements){
//    		game.root.getChildren().add(label.getImageView());
//    	}
    	game.root.getChildren().add(_elements[0].getImageView());
    }
	@Override
	public void stop() {
		super.stop();

	}
	public void setLabelDownFocus()
	{
		if(_selectIndex < menuCount - 1)
		{
			_selectIndex++;
		}
		else
		{
			_selectIndex = (byte) (0);
		}
		setLabelFocus();
	}
	public void setLabelUpFocus()
	{
		if(_selectIndex > 0)
		{
			_selectIndex--;
		}
		else
		{
			_selectIndex = (byte) (menuCount - 1);
		}
		setLabelFocus();
	}
	private void setLabelFocus()
	{
		for(int x = 0; x < _elements.length; x++)
		{
			if(x == _selectIndex)
			{
				_elements[x].setImage(LabelOptions.Focused);
			}
			else
			{
				_elements[x].setImage(LabelOptions.Unfocused);
			}
		}
	}

	public void labelAction()
	{
		_elements[_selectIndex].setImage(LabelOptions.Clicked);
		_elements[_selectIndex].getStateType();
	}

	public boolean checkNewPressed(KeyType keyType, boolean suppressRepeat)
	{
		if(suppressRepeat){
			return game.input.inputKeys[keyType.ordinal()].isPressed() &&
					game.input.inputKeys[keyType.ordinal()].pressCount() !=
					game.input.inputKeys[keyType.ordinal()].pressLastCount();
		}
		return game.input.inputKeys[keyType.ordinal()].isPressed();
	}
	public void setLastPress(KeyType keyType)
	{
		int last = game.input.inputKeys[keyType.ordinal()].pressCount();
		game.input.inputKeys[keyType.ordinal()].setLastPress(last);
	}

}
