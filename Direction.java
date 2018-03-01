package com.zl.snake;

/**
 * ̰����ǰ���ķ���
 * */
//ö����һ���������
public enum Direction{
	
	UP(0),
	RIGHT(1),
	DOWN(2),
	LEFT(3);
	
	//��Ա����
	private final int directionCode;
	
	//���캯��
	Direction(int directionCode){
		this.directionCode = directionCode;
	}
	
	//��Ա����
	public int directionCode(){
		return directionCode;
	}
	
	/**�жϷ���ı��Ƿ���Ч��������ϱ�Ϊ��Ϊ��Ч�����±�Ϊ��Ϊ��Ч
	*/
	//����boolean�͵ķ���������ֵ��boolean��
	public boolean compatibleWith(Direction direction){
		return Math.abs(direction.directionCode - directionCode)!=2;
	}
}
