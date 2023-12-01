package ques5;

import java.util.concurrent.*;

public class Fibonacci_void extends RecursiveAction {
    private int n, result;
    Fibonacci_void(int n){
        this.n = n;
    }

    @Override
    public void compute() {
        if (this.n<2){
            this.result = n;
            return;
        }
        Fibonacci_void left = new Fibonacci_void(this.n-1);
        Fibonacci_void right = new Fibonacci_void(this.n-2);
        left.fork();
        right.compute();
        left.join();
        this.result = left.getResult() + right.getResult();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        Fibonacci_void task = new Fibonacci_void(40);
        pool.invoke(task);
        System.out.println(task.getResult());
    }

    public int getResult() {
        return result;
    }
}