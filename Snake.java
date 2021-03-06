package com.zl.snake;

//List里面的LinkedList是基于链表实现的，插入、删除和移动元素快
import java.util.LinkedList;

public class Snake {
	private LinkedList<Node> body = new LinkedList<Node>();
	
	public Snake(){
	}

	public Node eat(Node food){
		//如果food与头部相邻，则将food这个Node加入到body中，返回food
		//否则不做任何操作，返回null
		
		if(isAdjacent(getHead(), food)){
			body.addFirst(food);
			return food;
		}
		
		return null;
	}
	
	private static boolean isAdjacent(Node a, Node b){
		return Math.abs(a.getX() - b. getX()) + Math.abs(a.getY() - b.getY()) == 1;
	}
	
	/**
	 * 往某个方向移动，蛇的身体可能会重叠，重叠判断由Grid处理
	 */
	
	public Node move(Direction direction){
		//根据方向更新贪吃蛇的body
		//返回移动之前的尾部Node
		
		int headX = getHead().getX();
		int headY = getHead().getY();
		
		Node newHead = null;
		
		switch (direction){
		case UP:
			newHead = new Node(headX, headY - 1);
			break;
		case DOWN:
			newHead = new Node(headX, headY + 1);
			break;
		case LEFT:
			newHead = new Node(headX - 1, headY);
			break;
		case RIGHT:
			newHead = new Node(headX + 1, headY);
			break;
		default:
			break;
		}
		body.addFirst(newHead);
		
		return body.removeLast();
	}
	
	public Node getHead(){
		return body.getFirst();
	}
	
	public Node addTail(Node area){
		this.body.addLast(area);
		return area;
	}
	
	public LinkedList<Node> getBody(){
		return body;
	}
}
