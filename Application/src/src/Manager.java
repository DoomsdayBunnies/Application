package src;

import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Manager extends Application
{	
	Image Image=new Image("image1.jpg");
	ImageView ImageView=new ImageView(Image);
	
	BorderPane BorderPane;//create GUI elements
	Pane Pane;
	Scene Scene;
	HBox HBox1;
	HBox HBox2;
	VBox VBoxR;
	VBox VBoxC;
	VBox VBox1;
	VBox VBox2;
	HBox leftPane;
	VBox bottomPane;

	ToggleGroup ToggleGroup;

	TextField tfn0;
	TextField tfStart;
	TextField tfEnd;
	TextField tfIt;
	TextField tfMult;
	TextField tfDiv;

	TextArea taDescription;
	TextArea taDisplay;

	CheckBox cbItDisplay=new CheckBox("Display Iterations");
	CheckBox cbItOutput=new CheckBox("Output Iterations");
	CheckBox cbReDisplay=new CheckBox("Display Results");
	CheckBox cbReOutput=new CheckBox("Output Results");
	CheckBox cbJump=new CheckBox("Display jumps only");
	CheckBox cbGraph=new CheckBox("Plot graphical data");

	BufferedWriter Vanillaout;//create file output writers
	BufferedWriter Maxout;
	BufferedWriter Searchout;
	BufferedWriter Sumout;
	BufferedWriter Trendout;
	BufferedWriter Pathout;

	BufferedReader in;

	String thisline;



	int a=0;//switch statement variable

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
		
		RadioButton rbVanilla=new RadioButton("Vanilla");
		RadioButton rbMax=new RadioButton("Max");
		RadioButton rbSearch=new RadioButton("Search");
		RadioButton rbSum=new RadioButton("Sum");
		RadioButton rbTrend=new RadioButton("Trend");
		RadioButton rbPath=new RadioButton("Path");

		ToggleGroup=new ToggleGroup();
		rbVanilla.setToggleGroup(ToggleGroup);
		rbMax.setToggleGroup(ToggleGroup);
		rbSearch.setToggleGroup(ToggleGroup);
		rbSum.setToggleGroup(ToggleGroup);
		rbTrend.setToggleGroup(ToggleGroup);
		rbPath.setToggleGroup(ToggleGroup);


		tfn0=new TextField();
		tfStart=new TextField();
		tfEnd=new TextField();
		tfIt=new TextField();
		tfMult=new TextField();
		tfDiv=new TextField();

		tfMult.setText("3");
		tfDiv.setText("2");

		taDescription=new TextArea();
		taDescription.setEditable(false);
		taDisplay=new TextArea();
		taDisplay.setEditable(false);

		VBox1=new VBox();
		VBox2=new VBox();
		VBoxC=new VBox();
		VBoxR=new VBox();
		HBox1=new HBox();
		HBox2=new HBox();


		leftPane=new HBox();
		bottomPane=new VBox();
		

		BorderPane.setLeft(leftPane);
		BorderPane.setCenter(ImageView);
		BorderPane.setRight(VBoxR);
		BorderPane.setBottom(bottomPane);

		VBoxC.setMinWidth(800);

		Scene=new Scene(BorderPane);
		Stage.setScene(Scene);
		Stage.show();
	}//end of method start
}//end of class Manager
