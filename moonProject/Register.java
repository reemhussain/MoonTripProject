import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class Register extends JFrame {
    private static passenger passenger;

    public Register(){
        ImageIcon icon = image("imgs/tr.jpg");
        Font f = font("fonts/ant.ttf");
        String[] data = new String[2];

        setBounds(10 , 01 , 495 , 700);
        setResizable(false);
        setTitle("MOON TRIP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon logo = image("imgs/logoo.png");
        setIconImage(logo.getImage());
        //panel

        JPanel container = new JPanel();
        container.setBounds(0, 0, 495 , 700);
        JLabel bg = new JLabel("", icon , JLabel.CENTER);
        bg.setBounds(-10 , 0 , 495 , 700);
        container.add(bg);

        JLabel tit = new JLabel("REGISTER");
        tit.setBounds(40 , 40 , 550 , 60);
        tit.setForeground(Color.decode("#fc3468"));
        Font foa = f.deriveFont(60f);
        tit.setFont(foa);
        add(tit);

        JLabel title = new JLabel(" Fly Me To the Moon");
        title.setBounds(30 , 120 , 550 , 60);
        title.setForeground(Color.ORANGE);
        Font fo = f.deriveFont(50f);
        title.setFont(fo);
        add(title);

        JPanel login = new JPanel();
        login.setBounds(40 , 200 , 400 , 420);
        login.setBackground(Color.decode("#c5b9cd"));

        JTextField username = new JTextField("");
        JTextField health = new JTextField("");
        JTextField mental = new JTextField("");
        JTextField password = new JTextField("");

        JLabel usernameLabel = new JLabel("username");
        JLabel passwordLabel = new JLabel("password");
        JLabel mentalLabel = new JLabel("mental");
        JLabel healthLabel = new JLabel("medical");

        usernameLabel.setBounds(60 , 280 , 100 , 50);
        healthLabel.setBounds(60 , 350 , 100 , 50);
        mentalLabel.setBounds(60 , 420 , 100 , 50);
        passwordLabel.setBounds(60 , 490 , 100 , 50);

        username.setBounds(140 , 280 , 260 , 50);
        health.setBounds(140 , 350 , 260 , 50);
        mental.setBounds(140 , 420 , 260 , 50);
        password.setBounds(140 , 490 , 260 , 50);
        username.setBackground(Color.decode("#f7f7f7"));
        health.setBackground(Color.decode("#f7f7f7"));
        mental.setBackground(Color.decode("#f7f7f7"));
        password.setBackground(Color.decode("#f7f7f7"));

        Font uf = f.deriveFont(18f);
        Font mf = f.deriveFont(18f);
        Font nf = f.deriveFont(18f);
        Font pf = f.deriveFont(18f);

        usernameLabel.setFont(uf);
        passwordLabel.setFont(uf);
        mentalLabel.setFont(uf);
        healthLabel.setFont(uf);

        username.setFont(uf);
        health.setFont(mf);
        mental.setFont(nf);
        password.setFont(pf);

        username.setBorder(new EmptyBorder(10 ,10 , 10 , 10));
        health.setBorder(new EmptyBorder(10 ,10 , 10 , 10));
        mental.setBorder(new EmptyBorder(10 ,10 , 10 , 10));
        password.setBorder(new EmptyBorder(10 ,10 , 10 , 10));

        add(usernameLabel);
        add(healthLabel);
        add(mentalLabel);
        add(passwordLabel);

        add(username);
        add(health);
        add(mental);
        add(password);

        JLabel err = new JLabel("" , null , JLabel.CENTER);
        err.setForeground(Color.black);
        Font n = f.deriveFont(20f);
        err.setFont(n);
        err.setBounds( 40 , 200 , 400 , 60);
        add(err);

        JButton log = new JButton("LOGIN");
        log.setBounds(320 , 550 , 100 , 50 );
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
        reg.setBounds(60 , 550 , 100 , 50 );
        reg.setForeground(Color.white);
        reg.setBackground(Color.decode("#493267"));
        Font regf = f.deriveFont(18f);
        reg.setFont(regf);
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = username.getText();
                String he = health.getText();
                String me = mental.getText();
                String pass = password.getText();

                if(!name.isEmpty() || !pass.isEmpty() || !he.isEmpty() || !me.isEmpty()) {
                passenger = new passenger();
                passenger.createAccount(name,pass, he, me);
                if(passenger.getLogged()){
                    setVisible(false);
                    new Trips(name , he , me , pass).setVisible(true);
                }
                else {
                    err.setText("error please try again");
                }
                }else {
                    err.setText("invalid input");
                }
            }
        });
        add(reg);

        add(login);
        add(container);
        setVisible(true);
    }

    private static Font font (String url){
        try {
            InputStream in = Register.class.getResourceAsStream(url);
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
