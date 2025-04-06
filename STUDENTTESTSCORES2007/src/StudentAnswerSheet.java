import java.util.ArrayList;

public class StudentAnswerSheet{
    private ArrayList<String> answers;
    private String name;

    public StudentAnswerSheet(String nm, ArrayList<String> ans)
    {
      name = nm;
      answers = new ArrayList<String>();
      for (String a : ans)
        answers.add(a);
    }

    public double getScore(ArrayList<String> key){
        double score = 0;
//key.size() is equal to the number of answers in this answer sheet
        for(int i = 0; i < key.size(); i++){
            if(answers.get(i).equals(key.get(i)))
            score += 1;
            else if(! answers.get(i).equals("?"))
            score -= 0.25;
        }
        return score;
    }

    public String getName(){
        return name;
    }
}
