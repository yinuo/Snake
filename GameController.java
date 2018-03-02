package com.zl.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements Runnable, KeyListener{
	private Grid grid;
    private GameView gameView;
    private boolean running;

    GameController(Grid grid, GameView gameView) {
        this.grid = grid;
        this.gameView = gameView;

        running = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
                grid.changeDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                grid.changeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                grid.changeDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                grid.changeDirection(Direction.LEFT);
                break;
            // restart the game
            case KeyEvent.VK_ENTER:
                if (!running) {
                    running = true;
                    grid.init();
                    new Thread(this).start();
                }
                break;
            // pause the game
            case KeyEvent.VK_SPACE:
                running = !running;
                if (running) {
                    new Thread(this).start();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        try {
            // main game loop
            while (running) {
                // ������Ϸ��һ��
                // ������������˳���Ϸ
                if (!grid.nextRound()) {
                    running = false;
                    gameView.showGameOverMessage();
                    break;
                }
                // ���������������µ���Ϸҳ��
                gameView.draw();

                Thread.sleep(Setting.DEFAULT_MOVE_INTERVAL);
            }
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
}
