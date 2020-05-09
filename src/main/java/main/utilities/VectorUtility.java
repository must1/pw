package main.utilities;

import lombok.experimental.UtilityClass;
import main.Main;

import java.util.Random;

@UtilityClass
public class VectorUtility {

    private Random random = new Random();

    public void printVector(int[] vct) {
        for (int x : vct) {
            System.out.print(x + " ");
        }
    }

    public void fillVectorWithNumberValues(int[] vct1, int[] vct2) {
        for (int i = 0; i < Main.VECTOR_SIZE; i++) {
            vct1[i] = random.nextInt(10);
            vct2[i] = random.nextInt(10);
        }
        System.out.println();
    }
}
