import javax.swing.*;
import java.awt.*;

public class CleaningServiceCalculator extends JFrame {

    private JLabel totalCostLabel;
    private double sofaCost = 0;
    private double carpetsCost = 0;
    private double windowsCost = 0;
    private double kitchen = 0;
    private double wall = 0;
    private double complexProducts = 0;

    public CleaningServiceCalculator() {
        setTitle("Cleaning Service Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        JLabel squareMetersLabel = new JLabel("Площадь пола: ");
        JTextField squareMetersField = new JTextField("0", 10);
        inputPanel.add(squareMetersLabel);
        inputPanel.add(squareMetersField);

        JPanel servicesPanel = new JPanel(new GridLayout(0, 1));

        ConcreteServiceCheckBox cleaningSofaCheckBox = new ConcreteServiceCheckBox("Чистка дивана 1000р/шт", 1000);
        ConcreteServiceCheckBox cleaningCarpetsCheckBox = new ConcreteServiceCheckBox("Мойка посуды 400р", 400);
        ConcreteServiceCheckBox cleaningWindowsCheckBox = new ConcreteServiceCheckBox("Мойка окон 300р/шт", 300);
        ConcreteServiceCheckBox cleaningKithcenCheckBox = new ConcreteServiceCheckBox("Мойка кухни 4000р", 4000);
        ConcreteServiceCheckBox cleaningWallCheckBox = new ConcreteServiceCheckBox("Мойка стен 500р/стена", 500);
        ConcreteServiceCheckBox cleaningComplexProductsCheckBox = new ConcreteServiceCheckBox("Сложные изделия 300р/шт", 300);

        servicesPanel.add(cleaningSofaCheckBox);
        servicesPanel.add(cleaningCarpetsCheckBox);
        servicesPanel.add(cleaningWindowsCheckBox);
        servicesPanel.add(cleaningKithcenCheckBox);
        servicesPanel.add(cleaningWallCheckBox);
        servicesPanel.add(cleaningComplexProductsCheckBox);

        JButton calculateButton = new JButton("Посчитать");
        calculateButton.addActionListener(e -> {
            double squareMeters = Double.parseDouble(squareMetersField.getText());
            double cleaningCost = (sofaCost + carpetsCost + windowsCost + kitchen + wall + complexProducts) + squareMeters * 10;
            totalCostLabel.setText("Общая стоимость: Р " + cleaningCost);
        });

        totalCostLabel = new JLabel("Общая стоимость: $0.0");

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(calculateButton);
        bottomPanel.add(totalCostLabel);

        add(inputPanel, BorderLayout.NORTH);
        add(servicesPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        inputPanel.setBackground(Color.YELLOW);
        cleaningSofaCheckBox.setBackground(Color.YELLOW);
        cleaningCarpetsCheckBox.setBackground(Color.YELLOW);
        cleaningWindowsCheckBox.setBackground(Color.YELLOW);
        cleaningKithcenCheckBox.setBackground(Color.YELLOW);
        cleaningWallCheckBox.setBackground(Color.YELLOW);
        cleaningComplexProductsCheckBox.setBackground(Color.YELLOW);
        bottomPanel.setBackground(Color.YELLOW);
        calculateButton.setBackground(Color.RED);
        setVisible(true);
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

        public abstract void updateCost(String text, double cost);

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