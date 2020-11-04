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
  private MD5 checker;

  public GUI() {
    checker = new MD5();

    frame = new JFrame("MD5 Hash");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();

    button1 = new JButton("select");
    button2 = new JButton("preview");

    button1.addActionListener(this);
    button2.addActionListener(this);

    panel.add(button1);
    panel.add(button2);

    frame.add(panel);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String com = e.getActionCommand();

    if (com.equals("select")) {
      JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());

      int r = j.showOpenDialog(null);

      if (r == JFileChooser.APPROVE_OPTION) {
        filepath = j.getSelectedFile().getAbsolutePath();
      }
      System.out.println(filepath);
    } else if (com.equals("preview")) {
      System.out.println("preview");
      String[] columns = {"plaintext", "result"};
      String[][] data = {};
      try {
        String[][] res = checker.check_hash(filepath);
        data = res;
      } catch (Exception ex) {
        System.out.println(ex);
      }
      table = new JTable(data, columns);

      JScrollPane scrollPane = new JScrollPane(table);
      frame.add(scrollPane);
      frame.setVisible(true);
    }
  }

  public static void main(String[] args) { new GUI(); }
}
