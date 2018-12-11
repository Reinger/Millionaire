import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Form extends JFrame {
    private JPanel panel;
    private JPanel panelButtons;
    private JPanel panelArt;
    private JPanel panelLevel;
    private JPanel panelHelp;
    private JPanel panelQuestion;
    private JPanel panelTop;
    private JPanel panelRating;
    private JPanel panelMain;
    private JPanel panelNewGame;

    private JLabel labelArt;

    private JLabel labelQuestion;
    private JButton buttonOption3;
    private JButton buttonOption1;
    private JButton buttonOption2;
    private JButton buttonOption4;

    private JLabel labelLevel;
    private JLabel labelMoney;

    private JLabel labelWrong;
    private JButton buttonHalf;
    private JButton buttonCall;
    private JButton buttonHall;

    private JList listRating;

    private JButton buttonNewGame;

    private static ArrayList<Question> questions = new ArrayList<Question>();
    private static Question question;
    private static Generation random = new Generation();//Отправляем нужный уровень
    private static int level;
    private static int[] money = {0, 500, 1000, 2000, 3000, 5000, 10000, 15000, 25000, 50000, 100000, 200000, 400000, 800000, 1500000, 3000000};

    //region Wrong
    public static boolean isWrong() {
        return wrong;
    }

    private static boolean wrong;

    public void setHaveWrong(boolean b) {
        if (b) {
            this.labelWrong.setForeground(Color.BLACK);
            wrong = b;
        } else {
            this.labelWrong.setForeground(Color.red);
            wrong = b;
        }
    }
    //endregion

    //region set Question
    private void setLabelQuestionText() {
        this.labelQuestion.setText(question.question);
    }

    private void setButtonsOptionsText() {
        this.buttonOption1.setText(question.options[0]);
        this.buttonOption2.setText(question.options[1]);
        this.buttonOption3.setText(question.options[2]);
        this.buttonOption4.setText(question.options[3]);
    }
    //endregion

    //region set Level and Money
    private void setLabelLevelText() {
        this.labelLevel.setText("Уровень: " + question.level);
    }

    private void setLabelMoneyText() {
        this.labelMoney.setText("Очки: " + money[level - 1]);
    }
    //endregion

    //region set Helps Enabled
    private void setAllButtonsHelpsEnabled(boolean b) {
        setButtonHalfEnabled(b);
        setButtonCallEnabled(b);
        setButtonHallEnabled(b);
    }

    private void setButtonHalfEnabled(boolean b) {
        this.buttonHalf.setEnabled(b);
    }

    private void setButtonCallEnabled(boolean b) {
        this.buttonCall.setEnabled(b);
    }

    private void setButtonHallEnabled(boolean b) {
        this.buttonHall.setEnabled(b);
    }
    //endregion

    //region set Options Enabled
    private void setAllButtonsOptionEnabled(boolean b) {
        setButtonOption1Enabled(b);
        setButtonOption2Enabled(b);
        setButtonOption3Enabled(b);
        setButtonOption4Enabled(b);
    }

    private void setButtonOption1Enabled(boolean b) {
        this.buttonOption1.setEnabled(b);
    }

    private void setButtonOption2Enabled(boolean b) {
        this.buttonOption2.setEnabled(b);
    }

    private void setButtonOption3Enabled(boolean b) {
        this.buttonOption3.setEnabled(b);
    }

    private void setButtonOption4Enabled(boolean b) {
        this.buttonOption4.setEnabled(b);
    }
    //endregion

    private Form() {
        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewGame();
            }
        });

        //region Click Options
        buttonOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckAnswer(1);
            }
        });

        buttonOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckAnswer(2);
            }
        });

        buttonOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckAnswer(3);
            }
        });

        buttonOption4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckAnswer(4);
            }
        });
        //endregion

        //region Click Helps
        buttonHalf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonHalfEnabled(false);

                ArrayList<String> k = random.GeneratHalf(question.answer);

                ButtonsEnabled(k.get(0));
                ButtonsEnabled(k.get(1));
            }
        });

        buttonHall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonHallEnabled(false);
            }
        });

        buttonCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonCallEnabled(false);
            }
        });
        //endregion
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

        setHaveWrong(true);

        setQuestion();

        setAllButtonsHelpsEnabled(true);
    }

    private void NoGame() {
        setHaveWrong(true);

        setAllButtonsHelpsEnabled(false);

        setAllButtonsOptionEnabled(false);
    }

    private void CheckAnswer(int k) {
        if (k == question.answer) {
            level++;
            question = questions.get(random.Generat(level));
            setQuestion();
        } else {
            if (isWrong()) {
                setHaveWrong(false);
                ButtonsEnabled(String.valueOf(k));
            } else {
                NoGame();
            }
        }
    }

    private void setQuestion() {
        setAllButtonsOptionEnabled(true);

        setLabelQuestionText();
        setButtonsOptionsText();

        setLabelLevelText();
        setLabelMoneyText();
    }

    private void ButtonsEnabled(String str) {
        switch (str) {
            case "1":
                setButtonOption1Enabled(false);
                break;
            case "2":
                setButtonOption2Enabled(false);
                break;
            case "3":
                setButtonOption3Enabled(false);
                break;
            case "4":
                setButtonOption4Enabled(false);
                break;
        }
    }
}