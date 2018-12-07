public class Question {
    String question;
    String[] options = new String[4];
    int answer;
    int level;

    Question(String[] s) {
        question = s[0];
        options[0] = s[1];
        options[1] = s[2];
        options[2] = s[3];
        options[3] = s[4];
        answer = Integer.decode(s[5]);
        level = Integer.decode(s[6]);
    }
}
