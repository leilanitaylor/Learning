package edXAlgorithmicDesignAndTechniques;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPairwiseProductTest {
    MaxPairwiseProduct maxPairProd;
    @BeforeEach
    public void setUP() {maxPairProd = new MaxPairwiseProduct(); }

    @Test
    void testGetMaxPairwiseProduct() {
        int[] numbers = {100000, 90000};
        long result = maxPairProd.getMaxPairwiseProduct(numbers);
        long expected = 9000000000L;
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void stressTestGetMaxPairwiseProduct() {
        int n = (int)(Math.random() * 100) + 2;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (int)(Math.random() * 100000);
        }
        long fastResult = maxPairProd.getMaxPairwiseProduct(numbers);
        long slowResult = getMaxPairwiseProductSlow(numbers);
        Assertions.assertNotNull(fastResult);
        Assertions.assertNotNull(slowResult);
        Assertions.assertEquals(slowResult, fastResult);
    }


    private static long getMaxPairwiseProductSlow(int[] numbers) {
        long product = 0;
        int n = numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((long)numbers[i] * (long)numbers[j] > product) {
                    product = (long)numbers[i] * (long)numbers[j];
                }
            }
        }
        return product;
    }
}