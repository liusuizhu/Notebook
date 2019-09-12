import util.ArrayQueue;
import util.LinkedListQueue;
import util.LoopQueue;
import util.Queue;

import java.util.Random;

public class Main {

    public static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random r = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enQueue(r.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.deQueue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10*10000;

        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time: " + time1);

        Queue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time: " + time2);

        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue time: " + time3);
    }

}
