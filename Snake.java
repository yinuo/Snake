package com.zl.snake;

//List�����LinkedList�ǻ�������ʵ�ֵģ����롢ɾ�����ƶ�Ԫ�ؿ�
import java.util.LinkedList;

public class Snake {
	private LinkedList<Node> body = new LinkedList<Node>();
	
	public Snake(){
	}

	public Node eat(Node food){
		//���food��ͷ�����ڣ���food���Node���뵽body�У�����food
		//�������κβ���������null
		
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
	 * ��ĳ�������ƶ����ߵ�������ܻ��ص����ص��ж���Grid����
	 */
	
	public Node move(Direction direction){
		//���ݷ������̰���ߵ�body
		//�����ƶ�֮ǰ��β��Node
		
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
