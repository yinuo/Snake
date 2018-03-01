package com.zl.snake;

/**
 * 贪吃蛇前进的方向
 * */
//枚举是一种特殊的类
public enum Direction{
	
	UP(0),
	RIGHT(1),
	DOWN(2),
	LEFT(3);
	
	//成员变量
	private final int directionCode;
	
	//构造函数
	Direction(int directionCode){
		this.directionCode = directionCode;
	}
	
	//成员方法
	public int directionCode(){
		return directionCode;
	}
	
	/**判断方向改变是否有效，例如从上变为下为无效，从下变为左为有效
	*/
	//定义boolean型的方法，返回值是boolean型
	public boolean compatibleWith(Direction direction){
		return Math.abs(direction.directionCode - directionCode)!=2;
	}
}
