// package P1;

// import P1.MD5;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class GUI implements ActionListener {

  private JFrame frame;
  private JPanel panel;
  private JTable table;
  private JButton button1;
  private JButton button2;
  private String filepath;

  public GUI() {
    frame = new JFrame("MD5 Hash");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    panel = new JPanel();

    button1 = new JButton("select");
    button2 = new JButton("preview");

    button1.addActionListener(this);
    button2.addActionListener(this);

    panel.add(button1);
    panel.add(button2);

    frame.add(panel);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String com = e.getActionCommand();

    if (com.equals("select")) {
      JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());

      int r = j.showOpenDialog(null);

      if (r == JFileChooser.APPROVE_OPTION) {
        filepath = j.getSelectedFile().getAbsolutePath();
      } else
        System.out.println("select");
    } else if (com.equals("preview")) {
      System.out.println("preview");
    }
  }

  public static void main(String[] args) {
    new GUI();
  }
}
