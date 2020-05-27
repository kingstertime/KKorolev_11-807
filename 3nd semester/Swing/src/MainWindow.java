import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel centRightPanel;
    private JPanel centScrollPanel;
    private JLabel statusLabel;
    private Dimension dim;
    private Boolean b1Click = false;
    private Boolean b2Click = false;
    private JTextArea textArea;

    public MainWindow(){
        super("Window");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        add(createMainPanel());
        setMinimumSize(new Dimension(600, 400));
        setVisible(true);
    }

    private JPanel createMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(createMenuBar(),BorderLayout.NORTH);
        mainPanel.add(createStatusBar(), BorderLayout.SOUTH);
        mainPanel.add(createCenterPanel(),BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createCenterPanel(){
        centerPanel = new JPanel(new BorderLayout());

        centerPanel.add(createScrollPane(),BorderLayout.CENTER);
        centerPanel.add(createCentralRightPanel(),BorderLayout.EAST);

        centerPanel.setVisible(true);
        return centerPanel;
    }

    private JPanel createCentralRightPanel(){
        centRightPanel = new JPanel();
        centRightPanel.setLayout(new GridLayout(12,0,20,20));
        JButton b1 = new JButton("Change Color");
        b1.addMouseListener(new MyListener());
        b1.setName("Change Color");
        JButton b2 = new JButton("Change Size");
        b2.addMouseListener(new MyListener());
        b2.setName("Change Size");
        JButton b3 = new JButton("HTTP-request");
        b3.addMouseListener(new MyListener());
        b3.setName("HTTP-request");
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b1Click){
                    textArea.setBackground(Color.white);
                    b1Click = false;
                }
                else{
                    textArea.setBackground(Color.red);
                    b1Click = true;
                }
            }
        });


        b2.addActionListener(new ActionListener() {
            int x;
            int y;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b2Click){
                    setSize(dim);
                    b2Click = false;
                }
                else{
                    dim = getSize();
                    setExtendedState(MAXIMIZED_BOTH);
                    b2Click = true;
                }

            }
        });
        b3.addActionListener(new ActionListener(){
            //http://www.yahoo.com - redirect
            //http://www.rambler.ru - 301
            @Override
            public void actionPerformed(ActionEvent e) {
                URLConnection connection = null;
                try {
                    connection = new URL("https://mail.ru").openConnection();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scanner scanner = null;
                try {
                    scanner = new Scanner(connection.getInputStream());
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                scanner.useDelimiter("\\Z");
                textArea.append(scanner.next());
            }

        });

        centRightPanel.add(b1);
        centRightPanel.add(b2);
        centRightPanel.add(b3);

        centRightPanel.setVisible(true);
        return centRightPanel;
    }
    @NotNull
    private JScrollPane createScrollPane(){
        textArea = new JTextArea("    ");
        textArea.addMouseListener(new MyListener());
        textArea.setName("TextArea");
        centScrollPanel = new JPanel(new GridLayout());
        centScrollPanel.add(textArea);
        JScrollPane scroll = new JScrollPane(textArea);

        scroll .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVisible(true);
        return scroll;
    };

    private JLabel createStatusBar(){
        statusLabel = new JLabel("Status bar");
        statusLabel.setBackground(new java.awt.Color(67, 67, 67));
        return statusLabel;
    }
    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createHelpMenu());

        return menuBar;
    }

    private class MyListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            statusLabel.setText("Это: " + e.getComponent().getName());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            statusLabel.setText("Status bar");
        }
    }


    private JMenu createFileMenu(){
        JMenu file = new JMenu("File");
        file.addMouseListener(new MyListener());
        file.setName("File menu");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addMouseListener(new MyListener());
        exit.setName("Выход из программы");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(exit);

        return file;
    }

    private JMenu createHelpMenu(){
        JMenu file = new JMenu("Help");
        file.addMouseListener(new MyListener());
        file.setName("Help menu");
        JMenuItem help = new JMenuItem("Help");
        help.addMouseListener(new MyListener());
        help.setName("Documentation about program");
        JMenuItem author = new JMenuItem("Author");
        JMenuItem about = new JMenuItem("About");
        file.add(help);
        file.addSeparator();
        file.add(author);
        file.add(about);
        author.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAuthorWindow();
            }
        });

        return file;
    }

    private void openAuthorWindow(){
        JFrame frame = new JFrame("Author Window");
        frame.setMinimumSize(new Dimension(200, 100));
        JLabel label = new JLabel();
        label.setText("Тут может быть Ваша реклама))");
        frame.add(label);
        frame.setVisible(true);
    }
}