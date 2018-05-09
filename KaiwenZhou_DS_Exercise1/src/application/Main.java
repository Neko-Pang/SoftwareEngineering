package application;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import FileHandle.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;

import javafx.scene.control.*;

/*
 * @author KaiwenZhou
 * the main class for UI and controller
 */
public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			final FileProcess processingFile = new FileProcess();
			Button openFile = new Button("Open File");
			TextField fileName = new TextField("File name");
			fileName.setVisible(false);
			VBox firstRow = new VBox(50, openFile, fileName);

			TextArea fileContent = new TextArea("File content...");

			Button size = new Button("Size");
			Button lastChange = new Button("Last change");
			Button lineAmount = new Button("Line amount");
			VBox buttonColumn = new VBox(20, size, lastChange, lineAmount);
			HBox secondRow = new HBox(20, fileContent, buttonColumn);
			secondRow.setVisible(false);

			Button discardAndClose = new Button("Discard and close");
			Button save = new Button("Save");
			HBox thirdRow = new HBox(80, discardAndClose, save);
			thirdRow.setVisible(false);

			VBox total = new VBox(firstRow, secondRow, thirdRow);
			// Pane root = new Pane(firstRow, secondRow, thirdRow);
			Scene scene = new Scene(total, 600, 400);
			openFile.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Open .txt File", "*.txt");
					FileChooser fileChooser = new FileChooser();
					fileChooser.getExtensionFilters().add(filter);
					fileChooser.setTitle("Choose .txt file");
					processingFile.setFile(fileChooser.showOpenDialog(primaryStage));
					if (processingFile.hasFile())
					{
						fileName.setVisible(true);
						secondRow.setVisible(true);
						thirdRow.setVisible(true);
						fileName.setText("File name:    " + processingFile.getName());
						try
						{
							fileContent.setText(processingFile.getContent());
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					// System.out.println(fileChooser.getTitle());
				}
			});

			size.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent evnet)
				{
					Label txtSize = new Label();
					txtSize.setText("    " + Double.toString(processingFile.getSize()) + "KB");
					Scene sizeScene = new Scene(txtSize, 400, 300);
					Stage sizeStage = new Stage();
					sizeStage.setScene(sizeScene);
					sizeStage.show();
				}
			});

			lastChange.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					Label lastChangeDate = new Label();
					lastChangeDate.setText("	" + processingFile.getLastChange().toString());
					Scene changeScene = new Scene(lastChangeDate, 400, 300);
					Stage lastChangeStage = new Stage();
					lastChangeStage.setScene(changeScene);
					lastChangeStage.show();
				}
			});
			lineAmount.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					Label lineNumber = new Label();
					try
					{
						lineNumber.setText("This file contains:    " + Integer.toString(processingFile.getLine()) + " lines.");
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Scene lineScene = new Scene(lineNumber, 400, 300);
					Stage lineNumberStage = new Stage();
					lineNumberStage.setScene(lineScene);
					lineNumberStage.show();
				}
			});
			save.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					try
					{
						processingFile.writeContent(fileContent.getText());
						Label saveSuccess = new Label();
						saveSuccess.setText("    Saved successfully!");
						Scene lineScene = new Scene(saveSuccess, 400, 300);
						Stage saveStage = new Stage();
						saveStage.setScene(lineScene);
						saveStage.show();
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					;

				}
			});

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			discardAndClose.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					primaryStage.close();
				}
			});
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException
	{
		launch(args);

	}
}
