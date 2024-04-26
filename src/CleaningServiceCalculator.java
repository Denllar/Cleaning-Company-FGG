import javax.swing.*;
import java.awt.*;

public class CleaningServiceCalculator extends JFrame {


    public CleaningServiceCalculator() {

    }

    private abstract class ServiceCheckBox extends JCheckBox {
        private double cost;

        public ServiceCheckBox(String text, double cost) {
            super(text);
            this.cost = cost;

            this.addActionListener(e -> {
                if (isSelected()) {
                    updateCost(text, cost);
                } else {
                    updateCost(text, 0);
                }
            });
        }

        public abstract void updateCost(String text, double cost);di

    }

    private class ConcreteServiceCheckBox extends ServiceCheckBox {

    }

    public static void main(String[] args) {
        new CleaningServiceCalculator();
    }
}