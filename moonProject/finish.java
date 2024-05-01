import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class finish extends JFrame {
    private static passenger passenger;
    private static trip trip;
    public finish(String name ,String health ,String mental ,String pass,String days ,String time ,String price){
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

        JLabel tit = new JLabel("Welcome");
        tit.setBounds(40 , 40 , 550 , 60);
        tit.setForeground(Color.decode("#fc3468"));
        Font foa = f.deriveFont(60f);
        tit.setFont(foa);
        add(tit);

        JLabel title = new JLabel(name);
        title.setBounds(40 , 120 , 550 , 60);
        title.setForeground(Color.ORANGE);
        Font fo = f.deriveFont(50f);
        title.setFont(fo);
        add(title);

        JPanel login = new JPanel();
        login.setBounds(40 , 250 , 400 , 300);
        login.setBackground(Color.decode("#c5b9cd"));

        if(health.equals("ok") && mental.equals("ok")) {

            JLabel ti = new JLabel("Days");
            ti.setBackground(Color.WHITE);
            ti.setBounds( 80 , 300 , 100 , 50 );
            Font uf = f.deriveFont(22f);
            ti.setFont(uf);
            add(ti);

            JLabel ti1 = new JLabel(days);
            ti1.setBackground(Color.WHITE);
            ti1.setBounds( 220 , 300 , 100 , 50 );
            Font rf = f.deriveFont(18f);
            ti1.setFont(rf);
            add(ti1);

            JLabel ti2 = new JLabel("Time");
            ti2.setBackground(Color.WHITE);
            ti2.setBounds( 80 , 350 , 100 , 50 );
            ti2.setFont(uf);
            add(ti2);

            JLabel ti12 = new JLabel(time);
            ti12.setBackground(Color.WHITE);
            ti12.setBounds( 220 , 350 , 100 , 50 );
            ti12.setFont(rf);
            add(ti12);

            JLabel ti3 = new JLabel("Price");
            ti3.setBackground(Color.WHITE);
            ti3.setBounds( 80 , 400 , 100 , 50 );
            ti3.setFont(uf);
            add(ti3);

            JLabel ti13 = new JLabel(price);
            ti13.setBackground(Color.WHITE);
            ti13.setBounds( 220 , 400 , 100 , 50 );
            ti13.setFont(rf);
            add(ti13);

            JLabel er = new JLabel("You Welcome To Go" , null , JLabel.CENTER);
            er.setBounds( 30 , 250 , 400 , 60);
            er.setForeground(Color.BLACK);
            Font erfo = f.deriveFont(40f);
            er.setFont(erfo);

            add(er);

        }else{
            JLabel er = new JLabel("You Can Not Go" , null , JLabel.CENTER);
            er.setBounds( 40 , 300 , 400 , 60);
            er.setForeground(Color.BLACK);
            Font erfo = f.deriveFont(40f);
            er.setFont(erfo);

            add(er);
        }
        JButton log = new JButton("Ok Done");
        log.setBounds(60 , 480 , 100 , 50 );
        log.setForeground(Color.white);
        log.setBackground(Color.decode("#9e379f"));
        Font logf = f.deriveFont(18f);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Trips(name , health  , mental , pass).setVisible(true);
            }
        });
        log.setFont(logf);

        add(log);


        add(login);
        add(container);
        setVisible(true);
    }

    private static Font font (String url){
        try {
            InputStream in = finish.class.getResourceAsStream(url);
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
