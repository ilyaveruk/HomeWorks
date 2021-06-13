package mines;





import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;



public class Controller {
	private int height,width,numMines,lvlcount=1;
	private Mines mines;
	

    @FXML
    private Label level;

    @FXML
    private Label extraBombs;

    @FXML
    private Label msg;
    @FXML
    private Button reset;

    @FXML
    private TextArea textWidth;

    @FXML
    private TextArea textHeight;

    @FXML
    private TextArea textMines;
    
    
    @FXML
    private StackPane stackpane1;
    
    @FXML
    void resetGame(ActionEvent event) {
    	
    	height = Integer.parseInt(textHeight.getText()); width =Integer.parseInt(textWidth.getText());
        numMines = Integer.parseInt(textMines.getText());
        msg.setText("Good Luck");
        switch(lvlcount) {
        case 1:
        	{
        	numMines = numMines + 2;
        	extraBombs.setText("2 extra bombs");
        	level.setText("level 1");
        	break;
        	}
        case 2:
        	{
        	numMines = numMines + 3;
        	extraBombs.setText("3 extra bombs");
        	level.setText("level 2");
        	break;
        	}
        case 3:
        	{
        	numMines = numMines + 4;
        	extraBombs.setText("4 extra bombs");
        	level.setText("level 3");
        	break;
        	}
        	default:
        		break;
        }
        mines = new Mines(height,width,numMines);
        
        
        
        
        
        GridPane grid =new GridPane();
        grid.setMinWidth(stackpane1.getWidth());
        grid.setMinHeight(stackpane1.getHeight());
        Button[][] buttons = new Button[height][width];
        
        
    	for(int i =0; i<height; i++)
        	for(int j=0; j<width; j++)
        	{
        		Button button = new Button(mines.get(i, j));
        		buttons[i][j] = button;
        		buttons[i][j].setMinWidth(stackpane1.getWidth()/width);
        		buttons[i][j].setMinHeight(stackpane1.getHeight()/height);
        		grid.add(button, i, j); 
        	}
    	
    	stackpane1.getChildren().add(grid);
    	
     	for(int i =0; i<height; i++)
        	for(int j=0; j<width; j++)
        	{
        		final int ii=i,jj=j;
        		final Button button = buttons[i][j];
        		button.setOnMouseClicked(new EventHandler<MouseEvent>(){
        			
                    @Override
                    public void handle(MouseEvent e){
                    	if(e.getButton() == MouseButton.PRIMARY) {
                    	
                    	if(button.getText().compareTo(".")!=0)//the button is already open
                    		return;
                    	
                    	if(mines.open(ii, jj) == false)//button is a bomb
                    	{
                    		
                    		
                    		button.setText(mines.get(ii,jj));
                    		mines.setShowAll(true);
                    		
                    		for(int k=0 ; k<height ; k++)
                    			for(int l=0; l<width ; l++)
                    				
                    				if(mines.get(k, l).compareTo(".")!=0)
                    					buttons[k][l].setText(mines.get(k, l));
                    		msg.setText("You Lose");
                    	}
                    	
                    	else// button isn't a bomb 
                    	{
                    		for(int k=0 ; k<height ; k++)
                    			for(int l=0; l<width ; l++)
                    				if(mines.get(k, l).compareTo(".")!=0)
                    					buttons[k][l].setText(mines.get(k, l));
                    		if(mines.isDone() == true)
                    		{
                    			lvlcount++;
                    			if(lvlcount>3)
                    			{
                    				msg.setText("You Won");
                    				lvlcount = 1;
                    			}
                    			mines.setShowAll(true);
                    			for(int k=0 ; k<height ; k++)
                        			for(int l=0; l<width ; l++)
                        				buttons[k][l].setText(mines.get(k, l));
                    			//win
                    		}
                    	}
                    	}
                    	else if (e.getButton() == MouseButton.SECONDARY)
                    	{
                    		mines.toggleFlag(ii, jj);
                    		button.setText(mines.get(ii,jj));
                    	}
                     }
                    });
        	}
    	
   
    }
    

}
