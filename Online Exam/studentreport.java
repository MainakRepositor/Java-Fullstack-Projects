import java.awt.*;
import java.sql.*;

public class studentreport extends Frame
{
    int stdno,scount=0;
    String[] topic;
    int[] totalmarks;
    int[] markssecured;
    String[] result;
    Panel p,p1;
    String[] str;
    int i;
    Button b;

    public studentreport(int snum)
    {
        System.out.println("sirishasrinivas");
        p=new Panel();
        p1=new Panel();
        b=new Button("Back");
        stdno=snum;
        try
          {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection c=DriverManager.getConnection("jdbc:odbc:sirisha");
               Statement st=c.createStatement();
               ResultSet rs=st.executeQuery("Select * from student where sno="+stdno);//+"' order by qno");

               while(rs.next())
               {
                    scount++;
               }
               str=new String[scount];
               topic=new String[scount];
               totalmarks=new int[scount];
               markssecured=new int[scount];
               result=new String[scount];

               rs=st.executeQuery("Select * from student where sno="+stdno);//+"' order by qno");
               i=0;
  //             stdno=rs.getInt(1);
               while(rs.next())
               {
                    topic[i]=rs.getString(2);
                    totalmarks[i]=rs.getInt(3);
                    markssecured[i]=rs.getInt(4);
                    result[i]=rs.getString(5);
                    str[i]=stdno+topic[i]+totalmarks[i]+markssecured[i]+result[i];
                    i++;
               }


               Label ls[]=new Label[scount];
               
               for(i=0;i<scount;i++)
               {
                    ls[i]=new Label(str[i]);
                    System.out.println(str[i]);
                    //str=i+1+" "+topic[i]+" "+totalmarks[i]+" "+markssecured[i]+" "+result[i]+" ";
                    p.add(ls[i]);
               }
               p1.add(b);
               add("South",p1);
               add("Center",p);
          }

          catch(Exception e)
          {
            e.printStackTrace();
          }
    }
    public boolean action(Event e,Object o)
    {
        if(e.target.equals(b))
        {
            subjectslist s=new subjectslist(stdno);
            hide();
            s.resize(400,300);
            s.show();
        }
//        else return super.action(Event e,Object o);
        return true;
    }
    public boolean handleEvent(Event e)
    {
        if(e.id==Event.WINDOW_DESTROY)
        System.exit(0);
        return super.handleEvent(e);
    }
}
