package ques5;

import java.util.Arrays;
import java.util.concurrent.*;

public class Fibonacci_int extends RecursiveTask<Integer>{
    private int n, result;
    Fibonacci_int(int n){
        this.n = n;
    }

    @Override
    public Integer compute() {
        if (this.n<2){
//            this.result=this.n;
            return this.n;
        }
        Fibonacci_int left = new Fibonacci_int(this.n-1);
        Fibonacci_int right = new Fibonacci_int(this.n-2);

        left.fork();
//        right.compute();
//        left.join();
//        this.result = left.getResult() + right.result;
//        return this.result;
        return right.compute() + left.join();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        Fibonacci_int task = new Fibonacci_int(40);
//        pool.invoke(task);
//        System.out.println(task.getResult());
        System.out.println(pool.invoke(task));
    }

    public int getResult() {
        return result;
    }
}