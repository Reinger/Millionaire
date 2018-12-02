import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {

    public static void main(String args[]) {

        Form form=new Form();
        form.pack();
        //form.setSize(new Dimension(200, 200));
        form.setVisible(true);


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

        for (Question q : questions)
            q.Show();
    }
}
