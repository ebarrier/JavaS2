package ee.itcollege.tetris.parts;

import static org.junit.Assert.*;

import org.junit.Test;

public class FigureTest {
	
	public static double PRECISION = .001;
	
	@Test
	public void testRotate() {
		Figure figure = new Figure();
		Block block = new Block(1,2);
		figure.getChildren().add(block);
		assertEquals(Block.SIZE*1, block.getX(), PRECISION);
		assertEquals(Block.SIZE*2, block.getY(), PRECISION);
		
		figure.rotate();
		assertEquals(Block.SIZE*-2, block.getX(), PRECISION);
		assertEquals(Block.SIZE*1, block.getY(), PRECISION);
		
		figure.rotate();
		assertEquals(Block.SIZE*-1, block.getX(), PRECISION);
		assertEquals(Block.SIZE*-2, block.getY(), PRECISION);
		
		figure.rotate();
		assertEquals(Block.SIZE*2, block.getX(), PRECISION);
		assertEquals(Block.SIZE*-1, block.getY(), PRECISION);
		
		figure.rotate();
		assertEquals(Block.SIZE*1, block.getX(), PRECISION);
		assertEquals(Block.SIZE*2, block.getY(), PRECISION);
	}

	@Test
	public void testMove() {
		
		Figure figure = new Figure();
		figure.setLayoutX(0);
		figure.setLayoutY(0);
		
		figure.move(1, 0);
		
		assertEquals(Block.SIZE, figure.getLayoutX(), PRECISION);
		assertEquals(0, figure.getLayoutY(), PRECISION);
		
		figure.move(1, 0);
		
		assertEquals(Block.SIZE*2, figure.getLayoutX(), PRECISION);
		assertEquals(0, figure.getLayoutY(), PRECISION);
		
		figure.move(0, 1);
		
		assertEquals(Block.SIZE*2, figure.getLayoutX(), PRECISION);
		assertEquals(Block.SIZE, figure.getLayoutY(), PRECISION);
		
		figure.move(0, 2);
		
		assertEquals(Block.SIZE*2, figure.getLayoutX(), PRECISION);
		assertEquals(Block.SIZE*3, figure.getLayoutY(), PRECISION);
		
		figure.move(0, -1);
		
		assertEquals(Block.SIZE*2, figure.getLayoutX(), PRECISION);
		assertEquals(Block.SIZE*2, figure.getLayoutY(), PRECISION);
		
		figure.move(-3, -5);
		
		assertEquals(Block.SIZE*-1, figure.getLayoutX(), PRECISION);
		assertEquals(Block.SIZE*-3, figure.getLayoutY(), PRECISION);
	}

}
