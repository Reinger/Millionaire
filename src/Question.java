public class Question {
    String question;
    String[] options = new String[4];
    int answer;
    int difficult;

/*    Question(){
        question="Вопрос";
        options[0]="1 вариант";
        options[1]="2 вариант";
        options[2]="3 вариант";
        options[3]="4 вариант";
        answer=1;
        difficult=1;
    }*/

/*    Question(String _question, String option1, String option2, String option3, String option4, int _answer, int _difficult){
        question=_question;
        options[0]=option1;
        options[1]=option2;
        options[2]=option3;
        options[3]=option4;
        answer=_answer;
        difficult=_difficult;
    }*/

    Question(String[] s) {
        question = s[0];
        options[0] = s[1];
        options[1] = s[2];
        options[2] = s[3];
        options[3] = s[4];
        answer = Integer.decode(s[5]);
        difficult = Integer.decode(s[6]);
    }

    public void Show() {
        System.out.println(question + ' ' + options[0] + ' ' + options[1] + ' ' + options[2] + ' ' + options[3] + ' ' + answer + ' ' + difficult);
    }
}
