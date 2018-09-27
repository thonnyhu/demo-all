package concurrentmode.three;


/**
 * Created by Mirana on 16/11/2017.
 */
public class EvaluateSum {

    private int count;
    private int start;
    private int end;

    public EvaluateSum(int start,int end){
        this.start = start;
        this.end = end;
        this.count = end - start +1;
    }

    public EvaluateSum(int count, int start , int end){
        this.count = count;
        this.start = start;
        this.end = end;
    }

    public Integer solveProblem(){
        int sum = 0;
        for(int i = start;i <= end ; i++){
            sum += i;
        }
        return sum;
    }


    public int getN(){
        return count;
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }
}
