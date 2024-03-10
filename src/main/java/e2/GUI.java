package e2;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

public class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton, Pair<Integer, Integer>> buttons = new HashMap<>();
    private final Logics logics;

    public GUI(int size, int numberOfBombs) {
        this.logics = new LogicsImpl(size, numberOfBombs);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * size, 100 * size);

        JPanel panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(BorderLayout.CENTER, panel);

        ActionListener onClick = (e) -> {
            final JButton bt = (JButton) e.getSource();
            final Pair<Integer, Integer> pos = buttons.get(bt);
            boolean aMineWasFound = logics.isMinePressed(pos);
            if (aMineWasFound) {
                logics.revealAllMines();
                quitGame(false);
            }
            boolean isThereVictory = logics.hasWon();
            if (isThereVictory) {
                quitGame(true);
            }
            this.drawBoard();
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton) e.getSource();
                if (bt.isEnabled()) {
                    final Pair<Integer, Integer> pos = buttons.get(bt);
                    logics.toggleFlag(pos);
                }
                drawBoard();
            }
        };

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb, new Pair<>(i, j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }

    private void quitGame(boolean isVictory) {
        this.drawBoard();
        JOptionPane.showMessageDialog(this, isVictory ? "You won!!" : "You lost!!");
        System.exit(0);
    }

    private void drawBoard() {
        for (var entry : this.buttons.entrySet()) {
            CellType value = logics.getExternalContent(entry.getValue());
            entry.getKey().setText(value.getContent());
            entry.getKey().setEnabled(value.equals(CellType.EMPTY) || value.equals(CellType.FLAG) || value.equals(CellType.MINE));
        }
    }

}
