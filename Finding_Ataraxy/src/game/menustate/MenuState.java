package game.menustate;

import game.boot.Finding_Ataraxy;
import game.boot.State;
import game.input.KeyType;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MenuState extends State{
	protected Finding_Ataraxy game;
	Image menuBack; //the image shown in background of game menu
	ImageView menuBackView; //the image control for the background of game menu
	private byte menuCount = 4; //the number of elements in the menu
	private byte imageCount = 10; //the number of images in the menu
	ImageView[] menuImageViews = new ImageView[menuCount]; //array of image views for menu
	Image[] menuImages =  new Image[imageCount]; //array of images for image views in the menu
	boolean continueGame; // boolean of displaying new game or continue as top element
	private byte selectIndex = 0; //current option that the player is focused on

	public MenuState(Finding_Ataraxy mygame)
	{
		game = mygame;
		//get background image
        menuBack = new Image("res/menu/splashTitleLowerHD.png",game.Screen_Width, game.Screen_Height, true, false, true);
        menuBackView = new ImageView();

        //fit the imageView to Screen size
        menuBackView.setFitWidth(game.Screen_Width);
        menuBackView.setFitHeight(game.Screen_Height);

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
	public void start()
	{
		super.start();
		//add image to imageView
        menuBackView.setImage(menuBack);

		//create menu
        createMenuImages();

        //creates group for later use when adding components/nodes
        game.root = new Group();

        //add components/nodes
        addGroupNodes();

        //creates scene and fills unused space with Black
        game.scene = new Scene(game.root);
        game.scene.setFill(Color.BLACK);
	}
	@Override
	public void stop()
	{
		super.stop();
	}
	public void createMenuImages()
    {
		//gets and sets all images to an index of an arrayList
    	for(int x = 0; x < imageCount; x++){
    		menuImages[x] = new Image("res/menu/ele"+ x +".png",210, 50, true, false, true);
    	}
    	//adds images to their appropriate ImageView
    	for(int x = 0; x < menuCount; x++){
    		menuImageViews[x] = new ImageView();
    		menuImageViews[x].setX(30); // set a position of x relative to the left side of window
    		menuImageViews[x].setFitWidth(210); // ***abstract or dynamically assign the width of image
            menuImageViews[x].setFitHeight(50); // ***abstract or dynamically assign the height of image
    		switch(x)
    		{
    			case 0:
    				//positioning and functionality of new game/continue menu images.
    				//menuImageViews[x].setY(game.Screen_Height / 2 - (100));
    				if (continueGame)
    				{
    					menuImageViews[0].setImage(menuImages[1]);
    				}
    				else
    				{
    					menuImageViews[0].setImage(menuImages[9]);
    				}
    				menuImageViews[x].setY(game.Screen_Height /3 + (menuImageViews[x].getFitHeight() + 5)* x);
    				/*menuImageViews[x].setOnMouseClicked(new EventHandler<MouseEvent>()
    				{

						@Override
						public void handle(MouseEvent event) {
							continueGame = !continueGame;
							if(continueGame){
    							menuImageViews[0].setImage(menuImages[1]);
    						}
    						else
    						{
    							menuImageViews[0].setImage(menuImages[9]);
    						}

						}
					});
    				menuImageViews[x].setOnMouseEntered(new EventHandler<MouseEvent>()
    				{
    					@Override
    					public void handle(MouseEvent event) {
    						setUnFocusAll();
    						if(continueGame){
    							menuImageViews[0].setImage(menuImages[1]);
    						}
    						else
    						{
    							menuImageViews[0].setImage(menuImages[9]);
    						}
    						selectIndex = 0;
    					}

    				});*/
    				break;
    			case 1:
    				//positioning and functionality of load game images.
    				menuImageViews[x].setImage(menuImages[2]);
    				//menuImageViews[x].setY(game.Screen_Height / 2 - (50));
    				menuImageViews[x].setY(game.Screen_Height /3 + (menuImageViews[x].getFitHeight() + 5)* x);
    				//menuTexts[x].setOnMouseClicked();
    				/*menuImageViews[x].setOnMouseEntered(new EventHandler<MouseEvent>()
    				{

    					@Override
    					public void handle(MouseEvent event) {
    						setUnFocusAll();
    						menuImageViews[1].setImage(menuImages[3]);
    						selectIndex = 1;
    					}

    				});*/
    				break;
    			case 2:
    				//positioning and functionality of options menu images.
    				menuImageViews[x].setImage(menuImages[4]);
    				//menuImageViews[x].setY(game.Screen_Height / 2 + (0));
    				menuImageViews[x].setY(game.Screen_Height /3 + (menuImageViews[x].getFitHeight() + 5)* x);
    				//menuTexts[x].setOnMouseClicked();
    				/*menuImageViews[x].setOnMouseEntered(new EventHandler<MouseEvent>()
    				{
    					@Override
    					public void handle(MouseEvent event) {
    						setUnFocusAll();
    						menuImageViews[2].setImage(menuImages[5]);
    						selectIndex = 2;
    					}

    				});*/
    				break;
    			case 3:
    				//positioning and functionality of exit menu images.
    				menuImageViews[x].setImage(menuImages[6]);
    				//menuImageViews[x].setY(game.Screen_Height / 2 + (50));
    				menuImageViews[x].setY(game.Screen_Height /3 + (menuImageViews[x].getFitHeight() + 5)* x);
    				//menuTexts[x].setOnMouseClicked();
    				/*menuImageViews[x].setOnMouseEntered(new EventHandler<MouseEvent>()
    				{
    					@Override
    					public void handle(MouseEvent event) {
    						setUnFocusAll();
    						menuImageViews[3].setImage(menuImages[7]);
    						selectIndex = 3;
    					}

    				});*/
    		}
    	}
    }
    public void addGroupNodes()
    {
    	//adding background imageView
    	game.root.getChildren().add(menuBackView);
    	//adding menuElement images
    	for(ImageView label: menuImageViews){
    		game.root.getChildren().add(label);
    	}
    }
    public void setLabelDownFocus()
    {
    	if(selectIndex < menuCount - 1)
    	{
    		setUnFocusAll();
    		selectIndex++;
    		setLabelFocus();
    	}
    }
    public void setLabelUpFocus()
    {
	    if(selectIndex > 0){
	    	setUnFocusAll();
			selectIndex--;
			setLabelFocus();
		}
    }
    private void setLabelFocus()
    {
    	switch(selectIndex)
    	{
    	case 0:
    		if(continueGame){
				menuImageViews[0].setImage(menuImages[1]);
			}
			else
			{
				menuImageViews[0].setImage(menuImages[9]);
			}
    		break;
    	case 1:
    		menuImageViews[1].setImage(menuImages[3]);
    		break;
    	case 2:
    		menuImageViews[2].setImage(menuImages[5]);
    		break;
    	case 3:
    		menuImageViews[3].setImage(menuImages[7]);
    		break;
    	}
    }

    private void setUnFocusAll()
    {
    	if(continueGame){
			menuImageViews[0].setImage(menuImages[0]);
		}
		else
		{
			menuImageViews[0].setImage(menuImages[8]);
		}
    	menuImageViews[1].setImage(menuImages[2]);
    	menuImageViews[2].setImage(menuImages[4]);
    	menuImageViews[3].setImage(menuImages[6]);
    }

    public void labelAction()
    {
    	switch(selectIndex)
    	{
    	case 0:
    		continueGame = !continueGame;
    		if(continueGame){
				menuImageViews[0].setImage(menuImages[1]); //continue game
			}
			else
			{
				menuImageViews[0].setImage(menuImages[9]); //new game
			}
    		break;
    	case 1:
    		// load gamescreen
    		break;
    	case 2:
    		//options + credits + legal
    		break;
    	case 3:
    		//exit
    		break;
    	}
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
