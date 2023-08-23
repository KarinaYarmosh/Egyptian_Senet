package interfaceElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDifficulty {

    public static void GameDifficulty(){

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game difficulty selection");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);

            JLabel label = new JLabel("Choose the difficulty of the game:");
            frame.add(label, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new FlowLayout());

            JButton easy = new JButton("Easy");

            easy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Add your logic for starting a game against the computer
                    JOptionPane.showMessageDialog(null, "Easy game started");
                }
            });

            buttonPanel.add(easy);

            JButton medium = new JButton("Medium");

            medium.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Add your logic for starting a game against another player
                    JOptionPane.showMessageDialog(null, "Medium game started");
                }
            });

            buttonPanel.add(medium);

            JButton hard = new JButton("Hard");

            hard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Add your logic for starting a game against another player
                    JOptionPane.showMessageDialog(null, "Hard game started");
                }
            });

            buttonPanel.add(hard);

            frame.add(buttonPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
