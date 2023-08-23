package interfaceElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseTheGameYouWantToPlay {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game you want to play");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);

            JLabel label = new JLabel("Choose a Game you want to play:");
            frame.add(label, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new FlowLayout());

            JButton egiptianSenet = new JButton("Egiptian Senet");

            egiptianSenet.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Add your logic for starting a game against the computer
                    MainWindow.PlayWithComputer();
                    //close the window
                    frame.dispose();
                }
            });

            buttonPanel.add(egiptianSenet);

            frame.add(buttonPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

}
