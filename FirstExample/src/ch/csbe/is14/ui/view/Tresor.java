package ch.csbe.is14.ui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Tresor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, content;
	private JTextField[] fields;
	private JLabel l;
	private JButton open;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tresor frame = new Tresor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tresor(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Tresor");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		
		content = new JPanel();
		contentPane.add(content, BorderLayout.CENTER);
		content.setLayout(new GridBagLayout());
	
		
		fields = new JTextField[4];
		Dimension d = new Dimension(50,90);
		Font f = new Font(Font.SANS_SERIF, 0, 50);
		
		for(int i = 0; i < 4; i++){
			JTextField first = new JTextField();
			first.setName("field"+i);
			first.setMinimumSize(d);
			first.setPreferredSize(d);
			first.setFont(f);
			first.setDocument(new PlainDocument(){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void insertString(int off, String str, AttributeSet as) throws BadLocationException{
					if(getLength() > 0){
						return;
					}
					super.insertString(off, str, as);
				}
			});
			
			first.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e){
					boolean failure = false;
					for(int i = 0; i < 4; i++){
						if(fields[i].getText().length()==0){
							failure = true;
							break;
						}
					}
					if(!failure){
						open.setEnabled(true);
					}
				}
			});
			content.add(first);
			first.setColumns(1);
			fields[i] = first;
		}
		l = new JLabel("TRESOR geöffnet");
		Dimension d1 = new Dimension(200,90);
		l.setPreferredSize(d1);
		l.setMinimumSize(d1);
		l.setVisible(false);
		content.add(l);
		
		JPanel footer = new JPanel();
		contentPane.add(footer, BorderLayout.SOUTH);
		
		open = new JButton("öffnen");
		open.setActionCommand("open");
		open.setEnabled(false);
		
		open.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					newContent();
			}
		});
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="open"){
					newContent();		
				}
			}
		});
		footer.add(open);

	}
	
	private void newContent(){
			String[] pw = {"a","b","c","d"};
			boolean failure = false;
			for(int i = 0; i < 4; i++){
				if(!fields[i].getText().equals(pw[i])){
					failure = true;
					break;
				}
			}
			if(!failure){
				for(int i = 0; i < 4; i++){
					fields[i].setVisible(false);
				}
				l.setVisible(true);
				open.setVisible(false);
				content.repaint();
				contentPane.repaint();
			}
		
	}

}
