import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//

public class Manager extends Application
{	
	Image Image=new Image("image1.jpg");
	ImageView ImageView=new ImageView(Image);
	
	BorderPane BorderPane;//create GUI elements
	Pane Pane;
	Scene Scene;
	HBox leftPane;
	VBox bottomPane;

	public static void main(String args[])
	{
		Manager.launch(args);
	}//end of main method


	@Override
	public void start(Stage Stage)
	{
		ImageView.setFitWidth(800);
		ImageView.setPreserveRatio(true);
		
		BorderPane=new BorderPane();//GUI assembly
		
		Pane=new Pane();
		
		BorderPane.setCenter(ImageView);
		BorderPane.setBottom(ImageView);

		Scene=new Scene(BorderPane);
		Stage.setScene(Scene);
		Stage.show();
	}//end of method start
}//end of class Manager