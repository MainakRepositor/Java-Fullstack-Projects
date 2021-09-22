import java.awt.*;

public class examrules extends Frame
{
    int snum;
    String topic;
    Panel p,p1;
    Button b1;
    Button b2;
    public examrules(int ss,String top)
    {
         snum=ss;
         topic=top;
         p=new Panel();
         Label l1=new Label("You have selected "+topic);
         p.add(l1);
         Label l2=new Label("________________________________________");
         p.add(l2);
         Label l3=new Label("Rules");
         p.add(l3);
         Label l4=new Label("1. Exam carries for 1 hr");
         Label l5=new Label("2.If exam is not completed in a hr,it will not accept further");
         Label l6=new Label("3.Best of luck");
         p.add(l4);
         p.add(l5);
         p.add(l6);
         add("Center",p);
         p1=new Panel();
         b1=new Button("Start");
         b2=new Button("Back");
         p1.add(b1);
         p1.add(b2);
         add("South",p1);
    }
    public boolean handleEvent(Event e)
    {
        if(e.id==Event.WINDOW_DESTROY)
                System.exit(0);
        return super.handleEvent(e);
    }
    public boolean action(Event e,Object arg)
    {
        if(e.target.equals(b2))      //back
        {
            subjectslist ss=new subjectslist(snum);
            hide();
            ss.resize(300,300);
            ss.show();
        }
        if(e.target.equals(b1))       //start
        {
             try
             {
             examination ex=new examination(snum,topic);
             hide();
             ex.resize(300,300);
             ex.show();
             //Thread t=new Thread();
             //t.sleep(30000);
             //System.out.println("time over...");
             //System.exit(0);
             }
             catch(Exception gg){}
        }
        else
             return super.action(e,arg);
        return true; 
    }
                
}
