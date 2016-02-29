package src;
/****************************************************************************
 * Manager.java
 * Final Project: Study of the Collatz Conjecture
 * Author: Jeffrey Becker
 * Collaborations: Michael Miller, Sean, Alex, Jessica
 * Date: 12032014
 * 
 * 
 * Variable List:
 * 
 * BorderPane: is a BorderPane
 * Scene: is a Scene
 * HBox1: contains VBox1 and VBox2
 * HBox2: contains buttons
 * VBoxR: contains checkboxes, within the right pane
 * VBoxC: contains HBox1 and HBox2, within the center pane
 * VBox1: contains radio buttons
 * VBox2: contains text fields and labels
 * tfn0: input for initial integer
 * tfStart: input for beginning of integer range
 * tfEnd: input for end of integer range
 * tfIt: input for target iterations
 * tfMult: input for multiplication factor
 * tfDiv: input for division factor
 * taDescription: displays function description
 * taDisplay: displays calculation results
 * cbItDisplay: determine if iterations are displayed in GUI
 * cbReDisplay: determine if calculation final results are displayed in GUI
 * cbItOutput: determine if iterations are printed to file
 * cbReOutput: determine if calculation final results are printed to file
 * cbJump: determine if the grouping jumps are the only information displayed/printed to file (SearchCollatz only)
 * cbGraph: determine if graphical results are plotted
 * Vanillaout: output destination for Vanilla method
 * Maxout: output destination for class Max
 * Searchout: output destination for class Search
 * Sumout: output destination for class Sum
 * Trendout: output destination for class Trend
 * Pathout: output destination for class Path
 * in: file reader
 * thisline: string holder for file reading
 * ItDisplay: attached to cbItDisplay
 * ReDisplay: attached to cbReDisplay
 * ItOutput: attached to cbItOutput
 * ReOutput: attached to cbReOutput
 * jump: attached to cbJump
 * graph: attached to cbGraph
 * overwrite: attached to btOverwrite
 * 
 * 
 * Methods List:
 * 
 * main: Accepts nothing.  Returns nothing.  Launches the GUI.
 * 
 * start: Accepts a stage.  Returns nothing.  Runs the GUI and calls other preparatory and execution methods.
 *  
 * PrepareVanilla: Accepts nothing.  Returns nothing.  Prepares parameters for the execution of CallVanilla.
 *  
 * PreapreMax: Accepts nothing.  Returns nothing.  Prepares parameters for the execution of CallMax.
 * 
 * PrepareSearch: Accepts nothing.  Returns nothing.  Prepares parameters for the execution of CallSearch.
 * 
 * PrepareSum: Accepts nothing.  Returns nothing.  Prepares parameters for the execution of CallSum.
 * 
 * PrepareTrend: Accepts nothing.  Returns nothing.  Prepares parameters for the execution of CallTrend.
 * 
 * PreparePath: Accepts nothing.  Returns nothing.  Prepares parameters for the execution of CallPath.
 * 
 * Run: Accepts nothing.  Returns nothing.  Calls one of the executive methods based on a switch statement.
 * 
 * CallVanilla: Accepts nothing.  Returns nothing.  Takes in user inputs from text fields and checkboxes and runs method Main of class Collatz.
 * 
 * CallMax: Accepts nothing.  Returns nothing.  Takes in user inputs from text fields and checkboxes and runs method Main of class Max.
 * 
 * CallSearch: Accepts nothing.  Returns nothing.  Takes in user inputs from text fields and checkboxes and runs method Main of class Search.
 * 
 * CallSum: Accepts nothing.  Returns nothing.  Takes in user inputs from text fields and checkboxes and runs method Main of class Sum.
 * 
 * CallTrend: Accepts nothing.  Returns nothing.  Takes in user inputs from text fields and checkboxes and runs method Main of class Trend.
 * 
 * CallPath: Accepts nothing.  Returns nothing.  Takes in user inputs from text fields and checkboxes and runs method Main of class Path.
 ***************************************************************************/

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