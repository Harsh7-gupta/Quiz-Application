import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
    JButton rules,back;
    JTextField tfname;
    Login(){
        getContentPane().setBackground(Color.WHITE);//changing whole frame colour.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/pp.jpg"));//upload the image in the code.
        setLayout(null);

        //now adding component or image to the frame using add function.
        JLabel img = new JLabel(i1);
        img.setBounds(0,0,550,450);
        add(img);

        JLabel heading = new JLabel("JAVA QUIZ ");
        heading.setBounds(765,60,300,45);
        heading.setFont(new Font("Constantia", Font.BOLD , 40));
        heading.setForeground(Color.RED);
        add(heading);


        JLabel name = new JLabel(" ENTER YOUR NAME ");
        name.setBounds(770,150,300,25);
        name.setFont(new Font("Constantia", Font.BOLD , 20));
        name.setForeground(Color.RED);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735, 200,300,25);
        tfname.setFont(new Font("Constantia", Font.BOLD,18));
        add(tfname);

        rules = new JButton("NEXT");
        rules.setBounds(735,270,120,25);
        rules.setBackground(Color.BLUE);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("BACK");
        back.setBounds(910,270,120,25);
       back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

       
        setSize(1200,500);
        setLocation(200,150);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae){ //override
        if(ae.getSource()==rules){
            String name = tfname.getText();
            setVisible(false);
            new rules(name);
            

        }
        else if(ae.getSource()==back){
            setVisible(false);
        }

    }
    public static void main(String args[]){
        new Login();
    }

}