import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {

    public static void main(String args[]) {

        ArrayList<Question> questions = new ArrayList<Question>();

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

        Form form=new Form();
        form.pack();
        form.setSize(new Dimension(500, 500));
        form.setVisible(true);

        form.labelQuestion.setText(questions.get(0).question);
        form.buttonAnswer1.setText(questions.get(0).options[0]);
        form.buttonAnswer2.setText(questions.get(0).options[1]);
        form.buttonAnswer3.setText(questions.get(0).options[2]);
        form.buttonAnswer4.setText(questions.get(0).options[3]);

    }
}
