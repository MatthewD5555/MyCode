package game.boot;

import game.input.Input;
import game.input.KeyType;
import game.menustate.MainMenu;
import game.menustate.StateType;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Finding_Ataraxy extends Application {
	public int Screen_Height; //in pixels
	public int Screen_Width; //in pixels
	State mainState; //main loop for menu execution
	public Group root; //scene type
	public Scene scene; //scene for adding elements on to the screen
	public Stage stage; //stage
	public Input input; //input object for key presses
	public StateType currentState = StateType.MainMenu;


	//takes pixels wide and pixels high
	@SuppressWarnings("unused")
	private void setScreen(int width, int height)
	{
		Screen_Height = height;
		Screen_Width = width;
	}

	//takes width and ensures that height is set, so that the Screen ratio is 16 by 9
	public void setScreenByWidth(int width)
	{
		Screen_Height = (int)(width * (9.0/16.0));
		Screen_Width = width;
	}

	//takes height and ensures that width is set, so that the Screen ratio is 16 by 9
	@SuppressWarnings("unused")
	private void setScreenByHeight(int height)
	{
		Screen_Height = height;
		Screen_Width = (int)(height * (16.0/9.0));
	}

	//start the splash menu by setting images and text
	@Override
	public void start(Stage thisStage) {

		//stores reference to inStage for later use
		stage = thisStage;
		//set screen size
		setScreenByWidth(1200);

		input = new Input();

        stateLoop();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void createKeyInputHandling()
    {
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					if(!input.inputKeys[KeyType.UpArrow.ordinal()].isPressed())
						input.inputKeys[KeyType.UpArrow.ordinal()].setPressed();
				break;
				case DOWN:
					if(!input.inputKeys[KeyType.DownArrow.ordinal()].isPressed())
						input.inputKeys[KeyType.DownArrow.ordinal()].setPressed();

				break;
				case LEFT:
					if(!input.inputKeys[KeyType.LeftArrow.ordinal()].isPressed())
						input.inputKeys[KeyType.LeftArrow.ordinal()].setPressed();
				break;
				case RIGHT:
					if(!input.inputKeys[KeyType.RightArrow.ordinal()].isPressed())
						input.inputKeys[KeyType.RightArrow.ordinal()].setPressed();
				break;
				case ENTER:
					if(!input.inputKeys[KeyType.Enter.ordinal()].isPressed())
						input.inputKeys[KeyType.Enter.ordinal()].setPressed();
				break;
				default:
					break;
				}

			}
		});
        scene.setOnKeyReleased(new EventHandler<KeyEvent>()
        {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					input.inputKeys[KeyType.UpArrow.ordinal()].setReleased();
					break;
				case DOWN:
					input.inputKeys[KeyType.DownArrow.ordinal()].setReleased();
					break;
				case LEFT:
					input.inputKeys[KeyType.LeftArrow.ordinal()].setReleased();
					break;
				case RIGHT:
					input.inputKeys[KeyType.RightArrow.ordinal()].setReleased();
					break;
				case ENTER:
					input.inputKeys[KeyType.Enter.ordinal()].setReleased();
					break;
				default:
					break;
				}

			}
		});
    }

    public void createMouseInputHandling()
    {
    	scene.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {


			}

    	});
    	scene.setOnMouseMoved(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent mouse) {
				stage.setTitle(mouse.getX() + " - "+ mouse.getY());
				Rectangle targetData = new Rectangle(100,100,100,100);
				if(targetData.contains(mouse.getX(), mouse.getY()))
				{
					stage.setTitle(mouse.getX() + " - "+ mouse.getY() + " Lol");
				}
			}

    	});
    	scene.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {


			}

    	});
    	scene.setOnMouseReleased(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {


			}

    	});
    	scene.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {


			}

    	});
    	scene.setOnMouseDragOver(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {


			}

    	});
    	scene.setOnMouseDragReleased(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {


			}

    	});
    }
    private void stateLoop()
    {
    	switch(currentState)
    	{
		case MainMenu:
			//adds a new menu and initializes its components
			mainState = new MainMenu(this);
			mainState.start();
			break;
		default:
			break;
    	}
    	//set Stage attributes
        stage.setTitle("Finding Ataraxy");
        stage.setWidth(Screen_Width);
        stage.setHeight(Screen_Height);
        stage.setScene(scene);
        //stage.getStyle();
        stage.sizeToScene();
        stage.show();
        createKeyInputHandling();
        createMouseInputHandling();
    }

}
