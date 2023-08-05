package View.Task;

import Model.PromoHistory;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class PromosPanel extends JPanel {
    private JPanel head, main;
    private JLabel codeLabel, percentRateLabel, startDateLabel, endDateLabel;

    public PromosPanel(ArrayList<PromoHistory> promoHistories){
        main = new JPanel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        codeLabel = new JLabel("Code");
        percentRateLabel = new JLabel("Percent Rate");
        startDateLabel = new JLabel("Start Date");
        endDateLabel = new JLabel("End Date");
        head = new JPanel();
        head.setLayout(new GridLayout(1, 6));
        head.add(codeLabel);
        head.add(percentRateLabel);
        head.add(new JLabel(""));
        head.add(startDateLabel);
        head.add(new JLabel(""));
        head.add(endDateLabel);

        main.setLayout(new GridLayout(promoHistories.size(), 6));

        for (int i = 0; i < promoHistories.size(); i++) {
            PromoHistory promoHistory = promoHistories.get(i);
            main.add(new JLabel(String.valueOf(promoHistory.getCode())));
            main.add(new JLabel(promoHistory.getPercentRate().toString()));
            main.add(new JLabel(""));
            main.add(new JLabel(promoHistory.getStartDate().format(formatter)));
            main.add(new JLabel(""));
            main.add(new JLabel(promoHistory.getEndDate().format(formatter)));
        }

        add(head);
        add(main);
    }
}
