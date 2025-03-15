// Creativity points

package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;    
import java.awt.event.*; 


public class WelcomeSign {

    public WelcomeSign() {

        // Color pallete

        Color eggplant = new Color(81, 45, 56); 
        Color skyMagenta = new Color(178, 112, 146); 
        //Color fairyTale = new Color(244, 191, 219); 
        Color lavenderBlush = new Color(255, 233, 243); 
        Color cambridgeBlue = new Color(135, 186, 171);

        //creating and setting the frame
        JFrame frame = new JFrame("Hello friend :)");
        
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setForeground(eggplant);

        //panel creating
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(skyMagenta);

        //Welcome message
        JLabel welcomeLabel = new JLabel("Welcome to the GenericsKB :D !", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Courier New", Font.BOLD, 16)); 
        welcomeLabel.setForeground(lavenderBlush);
        panel.add(welcomeLabel, BorderLayout.CENTER);

        //close button
        JButton closeButton = new JButton("Start in Terminal:");
        closeButton.setBackground(cambridgeBlue);
        closeButton.setForeground(Color.WHITE);

        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

        //adding to the scene
        panel.add(closeButton, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }
    
}
