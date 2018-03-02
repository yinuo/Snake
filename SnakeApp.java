package com.zl.snake;

import javax.swing.*;
import java.awt.*;

public class SnakeApp {
    public void init() {
        Grid grid = new Grid(Setting.DEFAULT_GRID_WIDTH / Setting.DEFAULT_NODE_SIZE, Setting.DEFAULT_GRID_HEIGHT / Setting.DEFAULT_NODE_SIZE);
        GameView gameView = new GameView(grid);
        GameController gameController = new GameController(grid, gameView);

        //¥¥Ω®”Œœ∑¥∞ÃÂ
        JFrame window = new JFrame("Ã∞≥‘…ﬂ");

        Container container = window.getContentPane();

        gameView.init();

        gameView.getCanvas().setPreferredSize(new Dimension(Setting.DEFAULT_GRID_WIDTH, Setting.DEFAULT_GRID_HEIGHT));
        container.add(gameView.getCanvas(), BorderLayout.CENTER);

        // ª≠≥ˆ∆Â≈Ã∫ÕÃ∞≥‘…ﬂ
        window.pack();
        window.setResizable(false);
        window.addKeyListener(gameController);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        // Start controller thread
        new Thread(gameController).start();
    }

    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}
