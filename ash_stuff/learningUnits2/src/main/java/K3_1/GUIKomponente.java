package K3_1;
/**
  * Das vorliegende Programmer�st erm�glicht das Einfügen einer GUI-Komponente
  * aus Java-Swing in ein GUI.
  * Aus Sicht der Anwendung muss nur die grafische Komponente korrekt erstellt und
  * dann im GUI abgelegt werden. Es sind noch keine Aktionen und Daten (MVC)
  * zugewiesen.
  */
 
 import javax.swing.*;
 import java.awt.*;
 
 
public class GUIKomponente extends JFrame{
  // Deklarieren Sie hier die passende GUI-Komponente aus Java-Swing!

  JLabel title = new JLabel("This is a GUI to test out Selection Items");

  DefaultListModel<String> categoriesModel = new DefaultListModel<>();
  JList<String> categories = new JList<>(categoriesModel);
  JComboBox<String> messages = new JComboBox<>();

  JCheckBox acceptAGB = new JCheckBox("I have read and accepted the AGB");

  JRadioButton male = new JRadioButton("Male");
  JRadioButton female = new JRadioButton("Female");
  ButtonGroup gender = new ButtonGroup();

  JLabel ageLabel = new JLabel("Age:");
  SpinnerModel spinnerModel = new SpinnerNumberModel(16, 16, 100, 1);
  JSpinner age = new JSpinner(spinnerModel);
  JLabel amountLabel = new JLabel("Amount:");
  JSlider amount = new JSlider(SwingConstants.HORIZONTAL, 0,20,1);

  JPanel topPanel = new JPanel();
  JPanel centerPanel = new JPanel();
  JPanel bottomPanel = new JPanel(new GridLayout(2,2));

  JPanel mainPanel = new JPanel(new GridLayout(3,1));
  
  private void init(){
    messages.addItem("I want to have this one");
    messages.addItem("Maybe I want that one");
    messages.addItem("I dont think I want anything");

    categoriesModel.addElement("Category A");
    categoriesModel.addElement("Category B");
    categoriesModel.addElement("Category C");

    amount.setMajorTickSpacing(5);
    amount.setMinorTickSpacing(1);
    amount.setPaintTicks(true);
    amount.setPaintLabels(true);

    topPanel.add(messages);
    topPanel.add(categories);

    centerPanel.add(ageLabel);
    centerPanel.add(age);
    centerPanel.add(amountLabel);
    centerPanel.add(amount);

    gender.add(male);
    gender.add(female);
    bottomPanel.add(male);
    bottomPanel.add(female);
    bottomPanel.add(acceptAGB);

    mainPanel.add(topPanel);
    mainPanel.add(centerPanel);
    mainPanel.add(bottomPanel);

    // hier die Komponente erstellen. Dazu bitte die API studieren.
    
    this.getContentPane().add(title, BorderLayout.NORTH);
    this.getContentPane().add(mainPanel, BorderLayout.CENTER);
  }
  
  
  /*
  * Der Konstruktor richtet einige Grundelemente des Fensters ein. Die eigentliche
  * Komponente wird in der Methode init() erstellt und auf das GUI gelegt.
  */
  public GUIKomponente(){
    super("Beispiel zu Auswahlelemente");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //
    init();
    //
    this.pack();
    this.setVisible(true);
  }
  
  public static void main(String[] args){
    new GUIKomponente();
  }
}