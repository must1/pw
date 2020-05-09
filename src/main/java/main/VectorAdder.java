package main;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VectorAdder implements Runnable {

    private int[] vct1;
    private int[] vct2;
    private int[] vct3;
    private int startNumberForIteratedThread;
    private int lastNumberForIteratedThread;

    public VectorAdder(int startNumberForIteratedThread, int lastNumberForIteratedThread, int[] vct1, int[] vct2, int[] vct3) {
        this.startNumberForIteratedThread = startNumberForIteratedThread;
        this.lastNumberForIteratedThread = lastNumberForIteratedThread;
        this.vct1 = vct1;
        this.vct2 = vct2;
        this.vct3 = vct3;
    }

    public void run() {
        for (int i = startNumberForIteratedThread; i < lastNumberForIteratedThread; i++) {
            vct3[i] = vct2[i] + vct1[i];
            log.info("Value of vector{} is equal to {}: ", i, vct3[i]);
        }
    }
}
