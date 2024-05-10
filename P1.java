import javax.swing.*;
import java.awt.*;

public class P1 extends JFrame {
    private JTextArea inputTextArea;
    private JButton countButton;
    private JLabel resultLabel;
    private JLabel sidebarLabel;

    public P1() {
        setTitle("Word Counter");                          //1.// Set Title of this Project
        setSize(500, 500);                          //2.// set size of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          //3.// frame properties 
        setLayout(new BorderLayout());                           //4.//use Border layout

        JPanel mainPanel = new JPanel();                                      //5.//Add Panel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));      //6.//Panel Properties
        mainPanel.setPreferredSize(new Dimension(300, getHeight()));    //7.//Panel Size

        inputTextArea = new JTextArea();                                     //8.//Add TextArea
        inputTextArea.setLineWrap(true);                                //9.// Enable line wrapping
        inputTextArea.setWrapStyleWord(true);                           //10.// Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(inputTextArea);             //11.// Add a scrollbar

        
        //12.// Set preferred size or maximum size for the text area
        scrollPane.setPreferredSize(new Dimension(250, 200));    //13.// Set preferred size
       //14.// Alternatively, you can set the maximum size:
       //15.// inputTextArea.setMaximumSize(new Dimension(250, 200));

        countButton = new JButton("Count Words");                      //16.//Add Button
        resultLabel = new JLabel("Word count: 0");

        countButton.addActionListener(e -> {
            String text = inputTextArea.getText();                          //17.// Get text from text area
            int wordCount = countWords(text);                               //18.// Count number of words 
            resultLabel.setText("Word count: " + wordCount);                //19.// Update count label
        });

        mainPanel.add(scrollPane);          //20.// Add the scroll pane instead of the text area directly
        mainPanel.add(countButton);
        mainPanel.add(resultLabel);

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());                           //21. //Add Sidebarpane1 and properties
        sidebarPanel.setPreferredSize(new Dimension(150, getHeight()));

        sidebarLabel = new JLabel("Add info");                         //22.//Add Sidebar and properties
        sidebarPanel.add(sidebarLabel, BorderLayout.NORTH);

        JScrollPane sidebarScrollPane = new JScrollPane(sidebarPanel);           //23.//Add sidebarscroll and properties
        sidebarScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(mainPanel, BorderLayout.CENTER);
        add(sidebarScrollPane, BorderLayout.WEST);                        //24.//add position

        setVisible(true);
    }

    private int countWords(String text) {
        String[] words = text.split("\\s+");                 //25.// Split text into words
        return words.length;                                       //26.//display words length
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(P1::new);
    }
}

