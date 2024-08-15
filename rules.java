import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class rules extends JFrame implements ActionListener{
    String name;
    JButton start,back;
    rules(String name){
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel(" WELCOME "  +  name  +  " TO THE JAVA QUIZ ");
        heading.setBounds(150,20,700,30);
        heading.setFont(new Font("Constantia", Font.BOLD , 25));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20,45,700,500);
        rules.setFont(new Font("Constantia", Font.BOLD , 15));
        //dynamically vlaues
        rules.setText(
            "<html>"+ 
            "1.Fairness: Ensure that all participants have an equal opportunity to participate and that the quiz questions are free from bias." + "<br><br>" +
            "2.No Cheating: Strictly prohibit cheating, including the use of unauthorized materials or communication during the quiz." + "<br><br>" +
            "3.Scoring System: Clearly explain how points will be awarded or deducted for each correct or incorrect answer" + "<br><br>" +
            "4.Respect: Maintain a respectful environment for all participants, both in terms of the questions asked and the interactions between participants.." + "<br><br>" +
            "5.Timeliness: Start and end the quiz on time to respect the participants' schedules and commitments." + "<br><br>" +
            "6.Feedback: Provide feedback to participants after the quiz, including correct answers and explanations for incorrect responses, to facilitate learning." + "<br><br>" +
            "7.Enjoyment: Ensure that the quiz is enjoyable for participants by creating interesting and thought-provoking questions and fostering a positive atmosphere throughout the event." + "<br><br>" +
            "8. Good Luck" + "<br><br>" +
        "<html>"
        );
        rules.setForeground(Color.BLACK);
        add(rules);

        back = new JButton("BACK");
        back.setBounds(250,500,100,30);
       back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        start = new JButton("NEXT");
        start.setBounds(400,500,100,30);
        start.setBackground(Color.BLUE);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800,650);
        setLocation(300,100);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){//override
        if(ae.getSource() == start){
            setVisible(false);
            new Quiz(name);

        }
        else{
            setVisible(false);
            new Login();
        }
                                               
    }
    public static void main(String args[]){
        new rules(" USER ");

    }
}