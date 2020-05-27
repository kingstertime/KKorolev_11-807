import javax.swing.JFrame;
import javax.swing.JLabel;
public class HelloWorld {
    public static void main(String[] args) {
        JFrame w = new JFrame("Hello, World!");
// Приложение завершает работу, если мы закроем это окно
// По умолчанию завершает работу, если мы закроем все его окна w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Добавляем нередактируемый текст (надпись)
        w.add(new JLabel("Hello World"));
// Окно 400х200, левый угол - 100х100 монитора w.setBounds(100,100,400,200);
// Показать окно
        w.setVisible(true);
    }
}