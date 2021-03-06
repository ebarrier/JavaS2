/*
MIT License
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
 */

package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.javafx.scene.traversal.Direction;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import parts.Apple;
import parts.Block;
import parts.Snake;

public class MainGame extends Application {

	public Snake snake = new Snake();
	private Apple apple = new Apple();
	public static final int width = 600;
	public static final int height = 600;
	private static int score;
	private Text tEat = new Text();
	private Stage window;
	private Pane gamePane;
	private Scene scene1, scene2, loseScene, winScene;
	private Timeline timeline;
	private boolean isPaused;
	private int speed = 100;
	
	private static final Logger logstartup = LogManager.getLogger("startup");
	private static final Logger loguseraction = LogManager.getLogger("user-actions");

	// Launches the game
	@Override
	public void start(Stage primaryStage) {
		logstartup.debug("Game initialization");
		scene1();
		scene2();
		loseScene();
		winScene();

		// Stage set up
		window = primaryStage;
//		window.setWidth(1000);
//		window.setHeight(1000);
		window.setTitle("Snake"); // sets the title of the window
		window.setScene(scene1);
		window.setResizable(false); // the window's size cannot be changed
		window.setOnCloseRequest(event -> exitGame()); // closing the
														// window stops
														// the game
		window.show(); // displays the elements of the game
		logstartup.debug("Stage loaded");
		keyListener();

	}

	// Design of the title
	public Node title() {
		InnerShadow is = new InnerShadow();
		is.setOffsetX(4.0f);
		is.setOffsetY(4.0f);

		Text title = new Text("SNAKE");
		title.setEffect(is);
		title.setFill(Color.GREENYELLOW);
		title.setFont(Font.font(null, FontWeight.BOLD, 100));
		return title;
	}

	// Design of message when lose
	public Node losemsg() {
		Text lose = new Text("GAME OVER!");
		lose.setFont(Font.font(null, FontWeight.BOLD, 80));
		lose.setFill(Color.ORANGE);

		Blend blend = new Blend();
		blend.setMode(BlendMode.MULTIPLY);

		DropShadow ds = new DropShadow();
		ds.setColor(Color.RED);
		ds.setOffsetX(5);
		ds.setOffsetY(5);
		ds.setRadius(5);
		ds.setSpread(0.2);
		blend.setTopInput(ds);

		InnerShadow is = new InnerShadow();
		is.setColor(Color.ORANGE);
		is.setRadius(9);
		is.setChoke(0.8);
		blend.setBottomInput(is);

		lose.setEffect(blend);
		return lose;
	}

	// Design of message when win
	public Node winmsg() {
		Text win = new Text("YOU WIN!");
		win.setFont(Font.font(null, FontWeight.BOLD, 80));
		win.setFill(Color.DEEPSKYBLUE);

		Blend blend = new Blend();
		blend.setMode(BlendMode.MULTIPLY);

		DropShadow ds = new DropShadow();
		ds.setColor(Color.GOLD);
		ds.setOffsetX(0);
		ds.setOffsetY(0);
		ds.setRadius(10);
		ds.setSpread(0.5);
		blend.setTopInput(ds);

		InnerShadow is = new InnerShadow();
		is.setColor(Color.ORANGE);
		is.setRadius(9);
		is.setChoke(0.5);
		blend.setBottomInput(is);

		win.setEffect(blend);
		return win;
	}

	// Set up of the scene1
	public Scene scene1() {
		Label lbl1scene1 = new Label("Welcome to the Snake Game by Etienne Barrier!");
		lbl1scene1.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
		lbl1scene1.setTextFill(Color.STEELBLUE);
		lbl1scene1.setWrapText(true);
		lbl1scene1.setStyle("-fx-text-alignment: CENTER"); // CSS styling

		Label lbl2scene1 = new Label("Click to start the game");
		lbl2scene1.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
		lbl2scene1.setTextFill(Color.DEEPPINK);

		Image imgStart = new Image("start.png");
		ImageView v1 = new ImageView(imgStart);
		v1.setFitWidth(200);
		v1.setPreserveRatio(true);

		Button btnStart = new Button("", v1);
		logstartup.debug("Start button loaded");
		btnStart.setOnAction(e -> {
			runGame();
		});

		VBox vbox1 = new VBox(title(), lbl1scene1, lbl2scene1, btnStart);
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setSpacing(10);

		scene1 = new Scene(vbox1, width, height);
		logstartup.debug("Start scene loaded");
		return scene1;
	}

	// Set up of the scene2 (game itself)
	public Scene scene2() {
		tEat.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 40));
		tEat.setY(height / 2);
		tEat.setX(width / 2 - 40);
		tEat.setFill(Color.CHARTREUSE);
		tEat.setOpacity(0);

		gamePane = new Pane(snake, apple, tEat);
		scene2 = new Scene(gamePane, width, height);
		logstartup.debug("Game scene loaded");
		return scene2;
	}

	// Set up of the scene3 (when lose)
	public Scene loseScene() {
		Label lb2scene3 = new Label("Epic fail! Try again if you dare...");
		lb2scene3.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
		Button btnTryAgain = new Button("Try again");
		btnTryAgain.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
		btnTryAgain.setOnAction(e -> {
			timeline.stop();
			resetGame();
			runGame();
		});
		Button btnQuit = new Button("Quit");
		btnQuit.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
		btnQuit.setOnAction(e -> exitGame());
		HBox hbox32 = new HBox(btnTryAgain, btnQuit);
		hbox32.setAlignment(Pos.CENTER);
		hbox32.setSpacing(10);
		VBox vbox3 = new VBox(title(), losemsg(), lb2scene3, hbox32);
		vbox3.setAlignment(Pos.CENTER);
		vbox3.setSpacing(10);
		loseScene = new Scene(vbox3, width, height);
		return loseScene;
	}

	// Set up of the scene3 (when win)
	public Scene winScene() {
		Label lblscene4 = new Label("Congratulations!");
		lblscene4.setFont(Font.font("Calibri", FontWeight.BOLD, 40));
		lblscene4.setTextFill(Color.RED);
		Button btnTryAgain = new Button("Play again");
		btnTryAgain.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
		btnTryAgain.setOnAction(e -> {
			timeline.stop();
			resetGame();
			runGame();
		});
		Button btnQuit = new Button("Quit");
		btnQuit.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
		btnQuit.setOnAction(e -> exitGame());
		HBox hbox4 = new HBox(btnTryAgain, btnQuit);
		hbox4.setAlignment(Pos.CENTER);
		hbox4.setSpacing(10);
		VBox vbox4 = new VBox(title(), winmsg(), lblscene4, hbox4);
		vbox4.setAlignment(Pos.CENTER);
		vbox4.setSpacing(10);
		winScene = new Scene(vbox4, width, height);
		return winScene;
	}

	// arrow keys pressed are recorded in the list of direction orders
	public void keyListener() {
		window.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
			switch (event.getCode()) {
			case LEFT:
				snake.directionOrders(Direction.LEFT);
				loguseraction.info("LEFT");
				break;
			case RIGHT:
				snake.directionOrders(Direction.RIGHT);
				loguseraction.info("RIGHT");
				break;
			case UP:
				snake.directionOrders(Direction.UP);
				loguseraction.info("UP");
				break;
			case DOWN:
				snake.directionOrders(Direction.DOWN);
				loguseraction.info("DOWN");
				break;
			case ESCAPE:
				exitGame();
			case SPACE:
				pause();
			default:
				break;
			}
		});

	}

	// Reset game
	public void resetGame() {
		loguseraction.info("Game reset");
		score = 0;
		window.setTitle("Snake " + score);
		gamePane.getChildren().removeAll(snake, apple, tEat);
		apple = new Apple();
		snake = new Snake();
		gamePane.getChildren().addAll(snake, apple, tEat);
	}

	// Run game
	public void runGame() {
		logstartup.debug("Game started!");
		loguseraction.info("Game started!");
		window.setScene(scene2);

		// create a timer
		timeline = new Timeline(new KeyFrame(Duration.millis(speed), ev -> {
			snake.move(); // at each frequency, the snake moves

			// when the snake eats an apple, it grows by one block, apple is
			// deleted and another one is created.
			if (snake.collides(apple)) {
				score++;
				window.setTitle("Snake " + score);
				tEat.setText("" + score);
				fader(tEat); // tEat text appears and fades away
				snake.eat(apple);
				gamePane.getChildren().remove(apple);
				apple = new Apple();
				gamePane.getChildren().add(apple);
			}

			// when the apple appears on snake, it is relocated
			if (snake.isOnSnake(apple)) {
				changeLocation();
			}

			// when the snake fills the scene entirely
			if (snake.snakeComplete()) {
				win();
			}

			// when snake eats itself or border
			 if (snake.collision()) {
			 gameOver();
			 }

		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.playFromStart();
	}

	public void changeLocation() {
		ArrayList<Block> blocks = new ArrayList<Block>();
		for (int i = 0; i < MainGame.width / 20; i ++) {
			for (int j = 0; j < MainGame.height / 20; j ++) {
				blocks.add(new Block(i, j));
			}
		}

		for (Iterator<Block> iterator = blocks.iterator(); iterator.hasNext();) {
			Block block = (Block) iterator.next();
			if (snake.isOnSnake(block)) {
				iterator.remove();
			}
		}
		
		Block randomBlock = blocks.get(new Random().nextInt(blocks.size()));
		apple.setX(randomBlock.getX());
		apple.setY(randomBlock.getY());
	}

	/**
	 * Fades a node until it becomes transparent. Inspired by
	 * https://docs.oracle.com/javase/8/javafx/api/javafx/animation/
	 * FadeTransition.html and
	 * http://stackoverflow.com/questions/23190049/how-to-make-a-text-content-
	 * disappear-after-some-time-in-javafx
	 */
	private FadeTransition fader(Node node) {
		FadeTransition fade = new FadeTransition(Duration.millis(500), node);
		fade.setFromValue(1);
		fade.setToValue(0);
		fade.play();
		return fade;
	}

	// Stops game and display losing scene
	public void gameOver() {
		timeline.stop();
		window.setScene(loseScene);
	}

	// Stops game and display winning scene
	public void win() {
		loguseraction.info("Game won!!");
		timeline.stop();
		window.setScene(winScene);
	}

	// Pauses/resumes game
	public void pause() {
		if (isPaused) {
			loguseraction.info("Game unpaused");
			timeline.play();
			isPaused = false;
		} else {
			loguseraction.info("Game paused");
			timeline.pause();
			isPaused = true;
		}
	}

	// Stops the games and closes the window
	public void exitGame() {
		loguseraction.info("Game exited!");
		try {
			stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
