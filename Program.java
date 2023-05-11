import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program extends JFrame {

    private JLabel label;

    public Program() throws Exception{
        super("Key Logger");

        createGUI();
    }

    public void createGUI() throws Exception{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setFocusable(true);


        FileWriter fWriter = new FileWriter("output.txt", true);

        label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                label.setText(e.getKeyText(e.getKeyCode()));
                try {
                    fWriter.append(e.getKeyChar());
                    fWriter.flush();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });

        panel.add(label, BorderLayout.CENTER);
        setPreferredSize(new Dimension(300, 300));
        getContentPane().add(panel);

    }


    public static void main(String[] args) {





            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    try {

                        Program frame = new Program();


                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }

                }
            });





    }
}
