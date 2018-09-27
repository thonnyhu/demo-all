package concurrentmode.three;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Mirana on 16/11/2017.
 */
public class EvaluateSumTask extends RecursiveTask<Integer>{

    private EvaluateSum problem;
    public Integer result;

    public EvaluateSumTask(EvaluateSum problem){
        this.problem = problem;
    }

    protected Integer compute() {
        if(problem.getN() < 2){
            result = problem.solveProblem();
        }else {
            int middle = (problem.getStart()+problem.getEnd())/2;
            EvaluateSumTask leftTask = new EvaluateSumTask(new EvaluateSum(problem.getStart(),middle));
            EvaluateSumTask rightTask = new EvaluateSumTask(new EvaluateSum(middle+1,problem.getEnd()));
            leftTask.fork();
            rightTask.fork();
            Integer join = leftTask.join();
            Integer join1 = rightTask.join();
            result = join + join1;
        }
        return result;
    }
}
