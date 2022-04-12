package guiuebung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tip extends JFrame {
    private ArrayList<String> tipsTitle = new ArrayList<>();
    private ArrayList<String> tipsDescription = new ArrayList<>();
    private JLabel titleLabel;
    private JTextArea descriptionArea;
    private JLabel dontShowTipsLabel;
    private JCheckBox dontShowTipsCheckBox;
    private JButton back;
    private JButton next;
    private JPanel tipPanel;
    private JPanel dontShowTipPanel;
    private JPanel buttonPanel;
    private JPanel soutPanel;
    private int currentTip = 0;
    private boolean showTips = true;

    public Tip() {
        super("Tipp");
        fillArrayList();
        init();
        pack();
        setVisible(true);
    }

    private void init() {
        tipPanel = new JPanel();
        tipPanel.setLayout(new GridLayout(0, 1));
        titleLabel = new JLabel(tipsTitle.get(currentTip));
        descriptionArea = new JTextArea(tipsDescription.get(currentTip), 5, 50);
        descriptionArea.setEditable(false);
        tipPanel.add(titleLabel);
        tipPanel.add(descriptionArea);


        dontShowTipPanel = new JPanel();
        dontShowTipPanel.setLayout(new GridLayout(0, 2));
        dontShowTipsLabel = new JLabel("Tipps nicht mehr anzeigen");
        dontShowTipsCheckBox = new JCheckBox();

        dontShowTipPanel.add(dontShowTipsLabel);
        dontShowTipPanel.add(dontShowTipsCheckBox);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 2));
        back = new JButton("Zurueck");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (--currentTip == -1) {
                    currentTip = 4;
                }
                descriptionArea.setText(tipsDescription.get(currentTip));
                titleLabel.setText(tipsTitle.get(currentTip));
            }
        });
        next = new JButton("Naechster");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (++currentTip >= 5) {
                    currentTip = 0;
                }
                descriptionArea.setText(tipsDescription.get(currentTip));
                titleLabel.setText(tipsTitle.get(currentTip));
            }
        });

        buttonPanel.add(back);
        buttonPanel.add(next);

        soutPanel = new JPanel();
        soutPanel.setLayout(new BorderLayout());

        soutPanel.add(dontShowTipPanel, BorderLayout.WEST);
        soutPanel.add(buttonPanel, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(tipPanel, BorderLayout.CENTER);
        add(soutPanel, BorderLayout.SOUTH);

    }

    private void fillArrayList() {
        tipsTitle.add("Hilfreicher Tipp 1");
        tipsTitle.add("Hilfreicher Tipp 2");
        tipsTitle.add("Hilfreicher Tipp 3");
        tipsTitle.add("Hilfreicher Tipp 4");
        tipsTitle.add("Hilfreicher Tipp 5");

        tipsDescription.add("Beschriebung des sehr hilfreichen Tipps 1");
        tipsDescription.add("Beschriebung des sehr hilfreichen Tipps 2");
        tipsDescription.add("Beschriebung des sehr hilfreichen Tipps 3");
        tipsDescription.add("Beschriebung des sehr hilfreichen Tipps 4");
        tipsDescription.add("Beschriebung des sehr hilfreichen Tipps 5");
    }


}
