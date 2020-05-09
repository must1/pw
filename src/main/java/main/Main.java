package main;

import lombok.extern.slf4j.Slf4j;
import main.utilities.VectorUtility;

@Slf4j
public class Main {

    public static final int VECTOR_SIZE = 7;
    private static final int THREADS_NUMBER = 7;
    private static final int numberForOneThread = VECTOR_SIZE / THREADS_NUMBER;
    private static int howManyThreadsLeft = VECTOR_SIZE - numberForOneThread * THREADS_NUMBER;

    public static void main(String[] args) {
        Thread[] threadsArray = new Thread[THREADS_NUMBER];

        int[] vct1 = new int[VECTOR_SIZE];
        int[] vct2 = new int[VECTOR_SIZE];
        int[] resultOfTwoVectors = new int[VECTOR_SIZE];

        VectorUtility.fillVectorWithNumberValues(vct1, vct2);

        VectorUtility.printVector(vct1);
        System.out.println();
        VectorUtility.printVector(vct2);
        System.out.println();

        sumTwoVectors(vct1, vct2, resultOfTwoVectors, threadsArray);

        for (Thread x : threadsArray) {
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        VectorUtility.printVector(resultOfTwoVectors);
    }

    private static void sumTwoVectors(int[] vct1, int[] vct2, int[] resultOfTwoVectors, Thread[] threadsArray) {
        int startNumberForIteratedThread = 0;
        int lastNumberForIteratedThread = numberForOneThread;
        int i = 0;
        while (i < THREADS_NUMBER) {
            if (howManyThreadsLeft != 0) {
                howManyThreadsLeft--;
                lastNumberForIteratedThread++;
            }
            threadsArray[i] = new Thread(new VectorAdder(
                    startNumberForIteratedThread, lastNumberForIteratedThread, vct1, vct2, resultOfTwoVectors));
            threadsArray[i].start();

            startNumberForIteratedThread = lastNumberForIteratedThread;
            lastNumberForIteratedThread = lastNumberForIteratedThread + numberForOneThread;
            i++;
        }
    }
}
