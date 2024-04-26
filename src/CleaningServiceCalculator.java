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
        public ConcreteServiceCheckBox(String text, double cost) {
            super(text, cost);
        }

        @Override
        public void updateCost(String text, double cost) {
            if (text.equals("Чистка дивана 1000р/шт")) {
                sofaCost = cost;
            } else if (text.equals("Мойка посуды 400р")) {
                carpetsCost = cost;
            } else if (text.equals("Мойка окон 300р/шт")) {
                windowsCost = cost;
            } else if (text.equals("Мойка кухни 4000р")) {
                kitchen = cost;
            } else if (text.equals("Мойка стен 500р/стена")) {
                wall = cost;
            } else if (text.equals("Сложные изделия 300р/шт")) {
                complexProducts = cost;
            }
        }

    }

    public static void main(String[] args) {
        new CleaningServiceCalculator();
    }
}