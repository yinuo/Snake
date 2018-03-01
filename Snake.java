package com.zl.snake;

//List里面的LinkedList是基于链表实现的，插入、删除和移动元素快
import java.util.LinkedList;

public class Snake {
	private LinkedList<Node> body = new LinkedList<>();
	
	public Snake(){
	}

	public Node eat(Node food){
		//如果food与头部相邻，则将food这个Node加入到body中，返回food
		//否则不做任何操作，返回null
		
		if(isAdjacent(getHead(), food)){
			body.addFirst(food);
			return food;
		}
	}
}
