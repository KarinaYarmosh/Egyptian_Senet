package interfaceElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow{

    public static void PlayWithComputer(){

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game Type Selection");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);

            JLabel label = new JLabel("Choose a Game Type:");
            frame.add(label, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new FlowLayout());

            JButton vsComputerButton = new JButton("Play with Computer");

            vsComputerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Add your logic for starting a game against the computer
                    SelectDifficulty.GameDifficulty();
                }
            });

            buttonPanel.add(vsComputerButton);

            JButton vsPlayerButton = new JButton("Play with Player");

            vsPlayerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Add your logic for starting a game against another player
                    JOptionPane.showMessageDialog(null, "Starting game with player");
                    frame.dispose();
                    //need to do window of choosing the color of the chips
                }
            });

            buttonPanel.add(vsPlayerButton);

            frame.add(buttonPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

}
