package co.edu.unbosque.ElectroShop.utils;

import java.util.Random;

public class PaySimu {

    /**
     * Simulate a payment processing.
     * @throws InterruptedException if the thread is interrupted
     */
    public static void simulatePayment() {
        try {
            Random random = new Random();
            int processingTime = 1 + random.nextInt(10);
            Thread.sleep(processingTime);
        } catch (InterruptedException e) {
            System.err.println("Error durante la simulación del pago: " + e.getMessage());
        }
    }
}
