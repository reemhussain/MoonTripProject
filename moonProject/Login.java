import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;

public class Login extends JFrame {
    private static passenger passenger;
    private static trip trip;
    public Login(){
        ImageIcon icon = image("imgs/bg.jpeg");
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

        JLabel tit = new JLabel("LOGIN ME");
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
        login.setBounds(40 , 250 , 400 , 300);
        login.setBackground(Color.decode("#c5b9cd"));

        JTextField username = new JTextField("");
        JTextField password = new JTextField("");
        JLabel usernameLabel = new JLabel("username");
        JLabel passwordLabel = new JLabel("password");

        usernameLabel.setBounds(60 , 300 , 100 , 50);
        passwordLabel.setBounds(60 , 380 , 100 , 50);

        username.setBounds(140 , 300 , 260 , 50);
        password.setBounds(140 , 380 , 260 , 50);
        Font uf = f.deriveFont(18f);
        Font pf = f.deriveFont(18f);
        usernameLabel.setFont(uf);
        passwordLabel.setFont(pf);

        username.setFont(pf);
        password.setFont(pf);

        username.setBackground(Color.decode("#f7f7f7"));
        password.setBackground(Color.decode("#f7f7f7"));
        username.setBorder(new EmptyBorder(10 ,10 , 10 , 10));
        password.setBorder(new EmptyBorder(10 ,10 , 10 , 10));

        add(usernameLabel);
        add(passwordLabel);

        add(username);
        add(password);

        JLabel err = new JLabel();
        err.setForeground(Color.RED);
        Font n = f.deriveFont(20f);
        err.setFont(n);
        err.setBounds( 200 , 480 , 200 , 60);
        add(err);
        JButton log = new JButton("LOGIN");
        log.setBounds(60 , 480 , 100 , 50 );
        log.setForeground(Color.white);
        log.setBackground(Color.decode("#9e379f"));
        Font logf = f.deriveFont(18f);
        log.setFont(logf);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = username.getText();
                String pass = password.getText();
                if((!name.equals("")) || (!pass.equals(""))) {
                    passenger = new passenger();
                    passenger.login(name, pass);
                    if (passenger.getLogged()) {

                        setVisible(false);
                        new Trips(name, passenger.medical, passenger.mental, pass).setVisible(true);
                    } else {
                        err.setText("User Not Found Try Again");
                    }
                }else {
                    err.setText("invalid input");
                }
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

        add(login);
        add(container);
        setVisible(true);
    }

    private static Font font (String url){
        try {
            InputStream in = Login.class.getResourceAsStream(url);
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
