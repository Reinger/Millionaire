import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
    private JButton buttonNewGame;

    private static ArrayList<Question> questions = new ArrayList<Question>();
    private static Question question;
    private static Generation random = new Generation();//Отправляем нужный уровень
    private static int level;
    private static int[] money = {0, 500, 1000, 2000, 3000, 5000, 10000, 15000, 25000, 50000, 100000, 200000, 400000, 800000, 1500000, 3000000};

    private Form() {
        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewGame();
            }
        });

        buttonOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChekAnswer(1);
            }
        });

        buttonOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChekAnswer(2);
            }
        });

        buttonOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChekAnswer(3);
            }
        });

        buttonOption4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChekAnswer(4);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form");
        frame.setContentPane(new Form().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        ParsingQuestion();
    }
    
    private static void ParsingQuestion() {
        try {
            FileInputStream fstream = new FileInputStream("Voprosy.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] s = strLine.split("\t");
                questions.add(new Question(s));
            }
        } catch (
                IOException e) {
            System.out.println("Ошибка");
        }
    }

    private void NewGame() {
        level = 1;
        question = questions.get(random.Generat(level));
        setQuestion(question);
    }

    private void ChekAnswer(int k) {
        if (k == question.answer) {
            level++;
            question = questions.get(random.Generat(level));
            setQuestion(question);
        } else {
            NewGame();
        }
    }

    private void setQuestion(Question question) {
        labelQuestion.setText(question.question);

        labelLevel.setText("Уровень: " + question.level);
        labelMoney.setText("Очки: "+money[level-1]);

        buttonOption1.setText(question.options[0]);
        buttonOption2.setText(question.options[1]);
        buttonOption3.setText(question.options[2]);
        buttonOption4.setText(question.options[3]);
    }
}


