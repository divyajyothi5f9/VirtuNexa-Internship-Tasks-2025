
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        updateTime();
        setVisible(true);
    }

    private void updateTime() {
        timeLabel.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}
