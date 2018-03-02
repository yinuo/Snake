package com.zl.snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jeff on 01/11/2016.
 */
public class GameView {
    private final Grid grid;
    private JPanel canvas;

    public GameView(Grid grid) {
        this.grid = grid;
    }

    public void init() {
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                drawGridBackground(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
            }
        };
    }

    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(null, "��Ϸ����", "��Ϸ����", JOptionPane.INFORMATION_MESSAGE);
    }

    public void draw() {
        canvas.repaint();
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public void drawSnake(Graphics graphics, Snake snake) {
        snake.getBody().forEach(each -> drawSquare(graphics, each, Setting.DEFAULT_SNAKE_COLOR));
}

    public void drawFood(Graphics graphics, Node squareArea) {
        drawCircle(graphics, squareArea, Setting.DEFAULT_FOOD_COLOR);
    }

    public void drawGridBackground(Graphics graphics) {
        graphics.setColor(Setting.DEFAULT_BACKGROUND_COLOR);
        graphics.fillRect(0, 0, Setting.DEFAULT_GRID_WIDTH, Setting.DEFAULT_GRID_HEIGHT);
    }

    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Setting.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size - 1, size - 1);
    }

    private void drawCircle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Setting.DEFAULT_NODE_SIZE;
        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
    }
}