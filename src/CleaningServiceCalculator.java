import javax.swing.*;
import java.awt.*;

public class CleaningServiceCalculator extends JFrame {


    public CleaningServiceCalculator() {

    }

    private abstract class ServiceCheckBox extends JCheckBox {

    }

    private class ConcreteServiceCheckBox extends ServiceCheckBox {

    }

    public static void main(String[] args) {
        new CleaningServiceCalculator();
    }
}