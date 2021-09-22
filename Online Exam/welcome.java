import java.awt.*;

public class welcome extends Frame
{
    int stdno;
    TextField tf1;
    Button b;
    public welcome()
    {
        b=new Button("GO ON");
        tf1=new TextField(10);
        setTitle("WELCOME");
        Panel p=new Panel();
        p.setLayout(new FlowLayout());
        p.add(new Label("C.S.Software Enterprise Ltd.,"));
        p.add(new Label("STUDENT NO:"));
        p.add(tf1);
        p.add(b);
        add("Center",p);

    }
    public boolean action(Event e,Object arg)
    {
        if(e.target.equals(b))
        {
            stdno=Integer.parseInt(tf1.getText());
            System.out.println(stdno);
            subjectslist ss=new subjectslist(stdno);
            hide();
            ss.resize(300,300);
            ss.show();
        }

        return super.action(e,arg);
    }
    public boolean handleEvent(Event e)
    {
        if(e.id==Event.WINDOW_DESTROY)
        System.exit(0);
        return super.handleEvent(e);
    }
    public static void main(String args[])
    {
        Frame f=new welcome();
        f.resize(400,500);
        f.show();

    }

}

            
