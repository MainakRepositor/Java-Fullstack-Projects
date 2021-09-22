import java.awt.*;

public class subjectslist extends Frame
{
    public List sublist;
    int snum;
    Button r,bb,ex;
    public subjectslist(int ss)
    {
        snum=ss;
        System.out.println("sno="+snum);
        setTitle("SUBJECTS LIST");
        setLayout(new FlowLayout());
        sublist=new List(6,false);
        sublist.addItem("Internet Basics");        
        sublist.addItem("Java");        
        sublist.addItem("Jdbc");        
        sublist.addItem("Servlets");        
        sublist.addItem("Java Beans");        
        sublist.addItem("Rmi");        
        sublist.addItem("Corba");
        add(sublist);
        r=new Button("Report");
        bb=new Button("Select");
        ex=new Button("Exit");
        add(r);
        add(bb);
        add(ex);
    }
    public boolean action(Event e,Object arg)
    {
        if(e.target.equals(bb))
        {
                String str=sublist.getItem(sublist.getSelectedIndex());
                examrules e1=new examrules(snum,str);
                hide();
                e1.resize(300,300);
                e1.show();
        }
        else if(e.target.equals(ex))
        {
            System.out.println("sirisha");
            welcome wel=new welcome();
            hide();
            wel.resize(400,400);
            wel.show();
        }
        else if(e.target.equals(r))
        {
            studentreport stdrep=new studentreport(snum);
            hide();
            stdrep.resize(400,400);
            stdrep.show();
        }
        return true;
    }
    public boolean handleEvent(Event e)
    {
        if(e.id==Event.WINDOW_DESTROY)
        System.exit(0);
        return super.handleEvent(e);
    }
}

            
