import java.sql.*;
import java.awt.*;
public class results extends Frame
{
    examination e;
    Label l1,l2,l3,l4,l5;
    int count,sno,tmarks,total,pmark;
    String topic,result;
    mycan mn;

    public results(examination ex)
    {
        e=ex;
        count=ex.count;
        sno=ex.stdno;
        topic=ex.topi;
        tmarks=0;
        for(int r=0;r<count;r++)
        {
              System.out.println("answer  "+ex.uans[r]+"   "+ex.ans[r]);

             if(ex.ans[r].equals(ex.uans[r]))
             {
                tmarks++;
             }
        }
        total=(count)*5;
        tmarks=tmarks*5;
        pmark=total/2;
        result="fail";
        if(tmarks>=pmark)
        {
            result="pass";        

        }
        Panel p=new Panel();
        l1=new Label("SNO   :"+sno);
        l2=new Label("TOPIC  :"+ topic);
        l3=new Label("TOTAL MARKS  :"+total);
        l4=new Label("MARKS SECURED  :"+tmarks);
        l5=new Label("RESULT   :"+result);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        add("North",p);
        mn=new mycan(tmarks,total,pmark);
        add("Center",mn);


        try
          {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection c=DriverManager.getConnection("jdbc:odbc:sirisha");
               Statement st=c.createStatement();
               ResultSet rs=st.executeQuery("select * from student where sno="+sno+" and topic='"+topic+"'");
               int found=100;
               if(rs.next())
               {
                  found=200;  
               }
               if(found==200)
               {
                    st.executeUpdate("update student set totalmarks="+total+",markssecured="+tmarks+",result='"+result+"' where sno="+sno+" and topic='"+topic+"'");
               }
               else
               {
                     st.executeUpdate("insert into student values("+sno+",'"+topic+"',"+total+","+tmarks+",'"+result+"')");
               }
          }
          catch(Exception e)
          {
               e.printStackTrace();
          }

    }
/*    public static void main(String args[])
    {
        Frame f=new Frame();
        f.setSize(500,500);
        f.setTitle("dhjhjfdj");
        f.repaint();
        f.show();
        
    } */
}
class mycan extends Canvas
{
     int total,tmark,pmark;
     mycan(int tmark,int total,int pmark)
     {
          this.total=total;
          this.tmark=tmark;
          this.pmark=pmark;


     }
     public void paint(Graphics g)
     {
          g.setColor(Color.blue);
          g.drawString("TOTAL MARKS",10,20);
             
          g.fillRect(50,0,total*10,20);
          g.drawString("MARKS   GOT",10,80);
          g.fillRect(50,60,tmark*10,20);
          resize(300,300);

     }

}
