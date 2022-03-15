//TIC-TAC-TOE
 
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener{
	
	private JFrame frame = new JFrame();
	private JPanel title = new JPanel();
	private JPanel title1 = new JPanel();
	private JPanel title2 = new JPanel();
	private JPanel board = new JPanel();
	private JLabel label = new JLabel();
	private JLabel label2 = new JLabel();
	private JButton[] button = new JButton[9];
	private Random rand = new Random();
	private boolean turn;
	private boolean status=true;
	
	TicTacToe(){
		
		frame.setLayout(new BorderLayout());
		frame.setSize(1000,1000);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		title.setLayout(new BoxLayout(title, BoxLayout.Y_AXIS));
		title.setBounds(0,0,1000,200);
		title1.setLayout(new BorderLayout());
		title2.setLayout(new BorderLayout());
		
		board.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++)
		{
			button[i] = new JButton();
			board.add(button[i]);
			button[i].setFont(new Font("Ink Free",Font.BOLD | Font.ITALIC,180));
			button[i].setBackground(new Color(230,255,255));
			button[i].setFocusable(false);
			button[i].setText("");
			button[i].addActionListener(this);
		}
		
		label.setFont(new Font("Times New Roman",Font.BOLD,60));
		label.setBackground(new Color(0,0,100));
		label.setForeground(new Color(255,255,255));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("START!!");
		label.setOpaque(true);
		
		label2.setFont(new Font("Times New Roman",Font.BOLD,60));
		label2.setBackground(new Color(0,0,100));
		label2.setForeground(new Color(255,255,255));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setText("Tic Tac Toe");
		label2.setOpaque(true);
		
		title1.add(label2);
		title2.add(label);
		title.add(title1,BorderLayout.NORTH);
		title.add(title2,BorderLayout.CENTER);
		frame.add(title,BorderLayout.NORTH);
		frame.add(board);
		
		start();
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==button[i])
			{
				
				if(button[i].getText()=="")
				{
					if(turn)
					{
						turn=false;
						button[i].setText("O");
						button[i].setForeground(new Color(150,0,128));
						label.setText("X's turn");
					}
					else
					{
						turn=true;
						button[i].setText("X");
						button[i].setForeground(new Color(255,153,0));
						label.setText("O's turn");
					}
					overCheck();
				}
					
			}
		}
	}
	
	public void start(){
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		if (rand.nextInt(2)==0)
		{
			turn=true;
			label.setText("O's Turn");
		}
		else
		{		
			turn=false;
			label.setText("X's Turn");
		}	
	}
		
	public void overCheck()
	{
		if(button[0].getText()==button[1].getText() && button[0].getText()==button[2].getText())
		{
			if(button[0].getText()=="O")
				over(0,0,1,2);
			if(button[0].getText()=="X")
				over(1,0,1,2);
		}
		else if(button[4].getText()==button[3].getText() && button[4].getText()==button[5].getText())
		{
			if(button[3].getText()=="O")
				over(0,3,4,5);
			if(button[3].getText()=="X")
				over(1,3,4,5);
		}
		else if(button[7].getText()==button[8].getText() && button[6].getText()==button[8].getText())
		{
			if(button[6].getText()=="O")
				over(0,6,7,8);
			if(button[6].getText()=="X")
				over(1,6,7,8);
		}
		else if(button[0].getText()==button[3].getText() && button[0].getText()==button[6].getText())
		{
			if(button[0].getText()=="O")
				over(0,0,3,6);
			if(button[0].getText()=="X")
				over(1,0,3,6);
		}
		else if(button[1].getText()==button[4].getText() && button[1].getText()==button[7].getText())
		{
			if(button[1].getText()=="O")
				over(0,1,4,7);
			if(button[1].getText()=="X")
				over(1,1,4,7);
		}
		else if(button[2].getText()==button[5].getText() && button[2].getText()==button[8].getText())
		{
			if(button[2].getText()=="O")
				over(0,2,5,8);
			if(button[2].getText()=="X")
				over(1,2,5,8);
		}
		else if(button[0].getText()==button[4].getText() && button[0].getText()==button[8].getText())
		{
			if(button[0].getText()=="O")
				over(0,0,4,8);
			if(button[0].getText()=="X")
				over(1,0,4,8);
		}
		else if(button[2].getText()==button[4].getText() && button[2].getText()==button[6].getText())
		{
			if(button[2].getText()=="O")
				over(0,2,4,6);
			if(button[2].getText()=="X")
				over(1,2,4,6);
		}
		else{
			int flag=1;
			for(int i=0;i<9;i++)
			{
				if(button[i].getText()=="")
					flag=0;
			}
			if(flag==1)
				over(2,0,0,0);
		}
		
	}
	
	public void over(int who, int x, int y, int z)
	{
		for(int i=0;i<9;i++)
			button[i].setEnabled(false);
		if(who==2)
		{
			label.setText("IT'S A DRAW!");
			status=false;
		}
		else
		{
			if(who==0)
				label.setText("O WINS!");	
			else if(who==1)
				label.setText("X WINS!");
			button[x].setBackground(new Color(0,102,0));
			button[y].setBackground(new Color(0,102,0));
			button[z].setBackground(new Color(0,102,0));
			status=false;
		}
		newOrEnd();
		
	}
	
	public void newOrEnd() {
        JDialog.setDefaultLookAndFeelDecorated(true);
		int response=0;
        if(status==false)
            response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", 
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.NO_OPTION)
                System.exit(0);
        
        else if (response == JOptionPane.YES_OPTION)
				new TicTacToe().start();
	
        else if (response == JOptionPane.CLOSED_OPTION) 
                System.exit(0);
        
    }
	
	public static void main(String[] args)
	{
		TicTacToe game = new TicTacToe();
	}
}