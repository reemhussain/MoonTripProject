import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class Trips extends JFrame {

    private String[] trips = {"1- days : 10 , time : 20:00, prices of flights : 100","2- days : 3 , time : 2:00, prices of flights : 20","3- days : 6 , time : 18:00, prices of flights : 50"};
    private int num;
    public Trips(String name , String health, String mental , String pass){
        ImageIcon icon = image("imgs/base.jpg");

        Font f = font("fonts/ant.ttf");

        setBounds(10 , 01 , 550 , 700);
        setResizable(false);
        setTitle("MOON TRIP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon logo = image("imgs/logoo.png");
        setIconImage(logo.getImage());

        JPanel container = new JPanel();
        container.setBounds(0, 0, 495 , 700);
        JLabel bg = new JLabel("", icon , JLabel.CENTER);
        bg.setBounds(-10 , 0 , 495 , 700);
        container.add(bg);

        JLabel tit = new JLabel("Available Trips ");
        tit.setBounds(40 , 40 , 550 , 60);
        tit.setForeground(Color.decode("#fc3468"));
        Font foa = f.deriveFont(60f);
        tit.setFont(foa);
        add(tit);

        JLabel title = new JLabel("Witch Trip Do You Want?");
        title.setBounds(40 , 120 , 550 , 60);
        title.setForeground(Color.ORANGE);
        Font fo = f.deriveFont(40f);
        title.setFont(fo);
        add(title);

        JPanel login = new JPanel();
        login.setBounds(0 , 200 , 530 , 400);
        login.setBorder(new EmptyBorder(10 , 10 , 10 , 10));
        login.setLayout(new GridLayout(4 , 0 , 0 , 10));

        int i = 0;
        for (String trip : trips) {
            String[] tmp  = trip.split(",");
            String[] days = tmp[0].toString().split(":");
            String[] time = tmp[1].toString().split(":");
            String[] price = tmp[2].toString().split(":");

            JPanel item = new JPanel();
            item.setBackground(Color.WHITE);
            item.setBorder(new EmptyBorder(10 , 10 , 10, 10));
            item.setLayout(new GridLayout(2 , 0));
            i++;
            JLabel titx = new JLabel("Trip Type" +i);
            titx.setBounds(60 , 10 , 300 , 40);
            Font v = f.deriveFont(25f);
            titx.setForeground(Color.BLUE);
            titx.setFont(v);
            item.add(titx);
            JPanel fot = new JPanel();
            fot.setBackground(Color.WHITE);
            fot.setLayout(new GridLayout(0 , 7));
            JLabel ti = new JLabel("Days");
            ti.setBackground(Color.WHITE);
            fot.add(ti);
            JLabel ti1 = new JLabel(days[1]);
            ti1.setBackground(Color.WHITE);
            fot.add(ti1);
            JLabel ti2 = new JLabel("Time");
            ti2.setBackground(Color.WHITE);
            fot.add(ti2);
            JLabel ti3 = new JLabel(time[1]);
            ti3.setBackground(Color.WHITE);
            fot.add(ti3);
            JLabel ti4 = new JLabel("Price");
            ti4.setBackground(Color.WHITE);
            fot.add(ti4);
            JLabel ti5 = new JLabel(price[1]);
            ti5.setBackground(Color.WHITE);
            fot.add(ti5);

            JButton check = new JButton("BOOK");
            check.setBackground(Color.orange);
            check.setForeground(Color.BLACK);
            check.setBorder(new EmptyBorder(0,0,0,0));
            fot.add(check);
            check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new finish(
                            name , health , mental , pass,days[1] , time[1] , price[1]
                    )
                            .setVisible(true);
                }
            });
            item.add(fot);
            login.add(item);
        }

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
