package com.zl.snake;

//List�����LinkedList�ǻ�������ʵ�ֵģ����롢ɾ�����ƶ�Ԫ�ؿ�
import java.util.LinkedList;

public class Snake {
	private LinkedList<Node> body = new LinkedList<>();
	
	public Snake(){
	}

	public Node eat(Node food){
		//���food��ͷ�����ڣ���food���Node���뵽body�У�����food
		//�������κβ���������null
		
		if(isAdjacent(getHead(), food)){
			body.addFirst(food);
			return food;
		}
	}
}
