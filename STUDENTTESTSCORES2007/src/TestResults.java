import java.util.ArrayList;

public class TestResults
{
  private ArrayList<StudentAnswerSheet> sheets;

  public TestResults(ArrayList<StudentAnswerSheet> shs)
  {
    sheets = new ArrayList<StudentAnswerSheet>();
    for (StudentAnswerSheet s : shs)
      sheets.add(s);
  }

      public String highestScoringStudent (ArrayList<String> key){
        int maxIndex = 0;

        for(int i = 1; i < sheets.size(); i++){
            if(sheets.get(i).getScore(key)>
                sheets.get(maxIndex).getScore(key)){
                    maxIndex = i;
                }
        }
        return sheets.get(maxIndex).getName();
    }
}

  