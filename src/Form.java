import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    private JPanel panel;
    private JButton buttonOption3;
    private JButton buttonOption1;
    private JButton buttonOption2;
    private JButton buttonOption4;
    private JPanel panelButtons;
    private JPanel panelArt;
    private JLabel labelQuestion;
    private JLabel labelLevel;
    private JPanel panelLevel;
    private JPanel panelHelp;
    private JPanel panelQuestion;
    private JPanel PanelTop;
    private JLabel labelArt;
    private JLabel labelMoney;
    private JLabel labelWrong;
    private JLabel labelHalf;
    private JLabel labelHall;
    private JLabel labelCall;
    private JPanel panelRating;
    private JPanel panelMain;
    private JList listRating;

    Form() {
        this.getContentPane().add(panel);
    }

    public void setQuestion(Question question) {

        labelQuestion.setText(question.question);

        labelLevel.setText("Уровень: " + question.level);
        labelMoney.setText("Очки: 0");

        buttonOption1.setText(question.options[0]);
        buttonOption2.setText(question.options[1]);
        buttonOption3.setText(question.options[2]);
        buttonOption4.setText(question.options[3]);
    }
}
