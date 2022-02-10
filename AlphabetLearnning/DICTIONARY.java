import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class DICTIONARY extends JFrame implements ActionListener{

	JLabel l1 = new JLabel("Welcome to DICTIONARY");
	JLabel l2 = new JLabel("Input A Letter");
	
	JTextField t1 = new JTextField ("");
	
	JButton bk = new JButton("Back");
	JButton sb = new JButton("Submit");
	JButton de = new JButton("Delete Letter");
	JButton ad = new JButton("Add Letter");
	JButton ud = new JButton("Update Letter");
	
	 JPanel panel;
	JTextArea wordsArea;
	JScrollPane wordsScrollPane; 
	Database db;
public DICTIONARY() 
{
	
	    super("DICTIONARY");
		this.setSize(800,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		
	
	db=new Database();
	
	l1.setBounds(200,30,150,30);
	panel.add (l1);
	
	l2.setBounds(30,70,150,30);
	panel.add (l2);
	
	t1.setBounds(200,70,250,30);
	panel.add(t1);
	
	bk.setBounds(200,500,100,30);
	bk.addActionListener(this);
	panel.add(bk);
	
	de.setBounds(620,200,180,30);
	de.addActionListener(this);
	panel.add(de);
	
	ad.setBounds(620,400,180,30);
	ad.addActionListener(this);
	panel.add(ad);
	
	
	sb.setBounds(100,150,100,30);
	sb.addActionListener(this);
	panel.add(sb);
	
		ud.setBounds(620,300,180,30);
	ud.addActionListener(this);
	panel.add(ud);
	
	//Text area
	wordsArea = new JTextArea("");
	wordsArea.setFont(new Font("Serif", Font.ITALIC, 30));
	wordsArea.setLineWrap(true);
	wordsArea.setWrapStyleWord(true);
	wordsArea.setEditable(false);
	panel.add(wordsArea);
	
	
	wordsScrollPane = new JScrollPane(wordsArea);
	wordsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	wordsScrollPane.setPreferredSize(new Dimension(250, 250));
	wordsScrollPane.setBounds(40,200,500,300);
	panel.add(wordsScrollPane);

	this.add(panel);	
}

public void actionPerformed(ActionEvent e){
	
	
	if (e.getSource()==bk) {
		
		GUI ft = new GUI();
		ft.setVisible(true);
		this.setVisible(false);	
	}
	if (e.getSource()==sb) {
		wordsArea.setText(db.getFromDatabase(t1.getText()));
		//SwingUtilities.updateComponentTreeUI(this);	
	}	
	else if (e.getSource()==de) {
		
		DELETE U = new DELETE();
		U.setVisible(true);
		this.setVisible(false);	
	}
	else if (e.getSource()==ad) {
		
		ADD W = new ADD();
		W.setVisible(true);
		this.setVisible(false);	
	}
	else if (e.getSource()==ud) {
		
		UPDATE r = new UPDATE();
		r.setVisible(true);
		this.setVisible(false);	
	}
}
}