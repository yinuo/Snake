package com.zl.snake;

import java.util.Arrays;
import java.util.Random;


public class Grid {
	
	private static Random r = new Random();
	
	public final boolean[][] status;
	
	private Snake snake;//棋盘里面有蛇
	private Node food;	//棋盘里面有食物
	
	private Direction snakeDirection = Direction.LEFT;
	private Direction prevDirection = Direction.LEFT;
	
	private final int width;
	private final int height;
	
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		
		status = new boolean[width][height];
		
		init();
	}
	
	public void init(){
		//clear grid
		for(int lop = 0; lop < width; lop++){
			Arrays.fill(status[lop], false);
		}
		
		snakeDirection = Direction.LEFT;
		prevDirection = Direction.LEFT;
		
		initSnake();
		createFood();
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Node getFood(){
		return food;
	}
	
	public Snake initSnake(){
		snake = new Snake();
		
		//create snake
		
		int x = width /2;
		int y = height /2;
		for(int lop = 0; lop < 5; lop++){
			snake.addTail(new Node(x, y));
			x += 1;
		}
		//update grid status
		//双冒号是java中的方法引用，格式是类名::方法名
		snake.getBody().forEach(this::occupy);
		
		return snake;
	}
	
	public Node createFood(){
		int x;
		int y;
		
		//使用Random设置x和y
		do{
			x = r.nextInt(width);
			y = r.nextInt(height);
		}while(!validPositon(new Node(x, y)));
		
		food = new Node(x, y);
		return food;
	}
	
	public boolean nextRound(){
		Node deletedTail = snake.move(snakeDirection);
		prevDirection = SnakeDirection;
		
		// Head is not in valid position
		//Game over
		if(!validPosition(snake.getHead()){
			return false;
		}
		
		//update head to grid
		occupy(snake.getHead());
		
		//if food is eaten
		if(isFood(snake.getHead())){
			snake.addTail(deletedTail);
			createFood();
		}else{
			//no food eaten, delete tail from grid
			dispose(ddeletedTail);
		}
		
		return true;		
	}
	
	public boolean validPosition(Node area){
		int x = area.getX(), y = area.getY();
		
		return x>=0 && x <width && y>=0 && y<height &&status[x][y];	
	}
	
	private void occupy(Node node){
		status[node.getX()][node.getY()] = true;
	}
	
	private void dispose(Node node){
		status[node.getX()][node.getY()] = false;
	}
	
	public boolean isFood(Node area){
		int x = area.getX(), y = area.getY();
		return x == food.getX() &&y == food.getY();
	}
	
	public void changeDirection(Direction newDirection){
		if(prevDirection.compatibleWith(newDirection)){
			snakeDirection = newDirection;
		}
	}	
}
