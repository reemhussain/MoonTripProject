import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        ImageIcon icon = image("imgs/moon1.png");

        Font f = font("fonts/ant.ttf");

        setBounds(10 , 01 , 495 , 700);
        setResizable(false);
        setTitle("MOON TRIP");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon logo = image("imgs/logoo.png");
        setIconImage(logo.getImage());

        JMenu menu, submenu;
        JMenuItem i1, i2, i3, i4, i5;
        JMenuBar mb=new JMenuBar();
        menu=new JMenu("Menu");
        submenu=new JMenu("made by");
        i1=new JMenuItem("exit");
        i5=new JMenuItem("Reem & Rahaf");
        submenu.add(i5);
        menu.add(i1);
        menu.add(submenu);
        mb.add(menu);
setJMenuBar(mb);
        //panel

        JPanel container = new JPanel();
        container.setBounds(0, 0, 495 , 700);
        JLabel bg = new JLabel("", icon , JLabel.CENTER);
        bg.setBounds(-10 , 0 , 495 , 700);
        container.add(bg);

        JLabel tit = new JLabel("WELCOME");
        tit.setBounds(40 , 200 , 550 , 60);
        tit.setForeground(Color.decode("#fc3468"));
        Font foa = f.deriveFont(60f);
        tit.setFont(foa);
        add(tit);

        JLabel title = new JLabel(" Fly Me To the Moon");
        title.setBounds(30 , 260 , 550 , 60);
        title.setForeground(Color.ORANGE);
        Font fo = f.deriveFont(50f);
        title.setFont(fo);
        add(title);

        JLabel madeby = new JLabel("Made By :  Reem & Rahaf");
        madeby.setBounds(44 , 320 , 550 , 60);
        madeby.setForeground(Color.white);
        Font madebyf = f.deriveFont(20f);
        madeby.setFont(madebyf);
        add(madeby);

        /*JPanel login = new JPanel();
        login.setBounds(50 , 350 , 300 , 200);
        //login.setBackground(Color.WHITE);*/

        JButton log = new JButton("LOGIN");
        log.setBounds(40 , 500 , 100 , 50 );
        log.setForeground(Color.white);
        log.setBackground(Color.decode("#9e379f"));
        Font logf = f.deriveFont(18f);
        log.setFont(logf);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
        });
        add(log);

        JButton reg = new JButton("REGISTER");
        reg.setBounds(40 , 580 , 100 , 50 );
        reg.setForeground(Color.white);
        reg.setBackground(Color.decode("#493267"));
        Font regf = f.deriveFont(18f);
        reg.setFont(regf);
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Register().setVisible(true);
            }
        });
        add(reg);

        //add(login);
        add(container);
        setVisible(true);
    }

    private static Font font (String url){
        try {
            InputStream in = Main.class.getResourceAsStream(url);
            return Font.createFont(Font.TRUETYPE_FONT, in);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public ImageIcon image(String url){
        java.net.URL imgUrl = getClass().getResource(url);

        if(imgUrl != null){
            return new ImageIcon(imgUrl);
        }else{
            return null;
        }
    }
}
