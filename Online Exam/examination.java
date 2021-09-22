import java.awt.*;
import java.sql.*;

public class examination extends Frame
{
     int stdno,i;
     int qcounter;
     String topi;
     int count=0;
     int qno;
     String[] ques;
     String[] op1;
     String[] op2;
     String[] op3;
     String[] op4;
     String[] ans;
     String[] uans;
     String[] umark;
     Panel p,p1,p3;
     Label l1,l2,l3;
     Button pre,n,m,c;
     CheckboxGroup radio;
     Checkbox radioop1,radioop2,radioop3,radioop4;
     int qmark;
     mythread mn;
     results a2;
     public examination(int snum,String top)
     {

        qcounter=0;
        stdno=snum;
        topi=top;
        
        try
          {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection c=DriverManager.getConnection("jdbc:odbc:sirisha");
               Statement st=c.createStatement();
               ResultSet rs=st.executeQuery("Select * from question where topic='"+topi+"' order by qno");

               while(rs.next())
               {
                    count++;
               }
               st.close();
               ques = new String[count];
                   
                    op1=new String[count];
                    op2=new String[count];                    
                    op3=new String[count];
                    op4=new String[count];
                    ans=new String[count];
                    uans=new String[count];
                    umark=new String[count];
               Statement st1=c.createStatement();
               rs=st1.executeQuery("Select * from question where topic='"+topi+"'");
               int i=0;
               while(rs.next())
               {
                    ques[i]=rs.getString(2);
                    op1[i]=rs.getString(4);
                    op2[i]=rs.getString(5);
                    op3[i]=rs.getString(6);
                    op4[i]=rs.getString(7);
                    ans[i]=rs.getString(8);
                    umark[i]="N";
                    i++;
               }

               st1.close();
              System.out.println(count);
          }
         catch(Exception e)
         {
               System.out.println("inside:"+e);
               e.printStackTrace();
         }
         p=new Panel();
         p3=new Panel();
         p1=new Panel();
         pre=new Button("Previous");
         n=new Button("Next");
         m=new Button("Mark/Unmark");
         c=new Button("Close");
       //  System.out.println("Value of ques[]"+ques[qcounter]);
         l1=new Label(""+ques[qcounter]);
         qno=qcounter+1;
         l3=new Label("Time :00::50::00");
         l2=new Label("Q.NO"+qno+"of"+count);
         p.add(l1);

         p3.add(l2);
         p3.add(l3);
         p1.add(pre);
         p1.add(n);
         p1.add(m);
         p1.add(c);
         radio=new CheckboxGroup();
         radioop1=new Checkbox(op1[qcounter],radio,false);
         radioop2=new Checkbox(op2[qcounter],radio,false);
         radioop3=new Checkbox(op3[qcounter],radio,false);
         radioop4=new Checkbox(op4[qcounter],radio,false);
         
         p.add(radioop1);
         p.add(radioop2);
         p.add(radioop3);
         p.add(radioop4);
         add("Center",p);
         add("South",p1);
         add("North",p3);
         mn=new mythread(this);
         mn.start();
         show();

    }
    public boolean handleEvent(Event e)
    {
        if(e.id==Event.WINDOW_DESTROY)
            System.exit(0);

        return super.handleEvent(e);
    }
    public boolean action(Event e,Object o)
    {
        
        if(e.target.equals(pre))
        {
           qcounter=qcounter-1;
           if(qcounter<=0)
           {
                qcounter=0;
           }
           add124(qcounter);
       }

        else if(e.target.equals(n))
        {  
           qcounter=qcounter+1;
           if(qcounter>=(count))
           {
                qcounter=qcounter-1;
           }
           add124(qcounter);
        }
        else if(e.target.equals(m))

        {      
               umark[qcounter]="M";
        }

        else if(e.target.equals(c))
        {
             //count,uans,qmark,stdno,topi
             disp124();  
        }
        if(radioop1.getState())
        {
                uans[qcounter]= op1[qcounter];
        }
        else  if(radioop2.getState())
        {
                uans[qcounter]= op2[qcounter];
        }
        else  if(radioop3.getState())
        {
                uans[qcounter]= op3[qcounter];
        }
        else  if(radioop4.getState())
        {
                uans[qcounter]= op4[qcounter];
        }

     
         return super.action(e,o);
    }
    public void disp124()
    {
             answerlist al=new answerlist(this);
             hide();
             al.resize(300,300);
             al.show();

    }

    public void dispresults()
    {
             if(a2==null)
             {
                System.out.println("Method dispresults called");
                a2=new results(this);
                hide();
                a2.resize(300,300);
                a2.show();
             }

    }

    public void add124(int c)
    {
         qcounter=c;
         //p.removeAll();
         umark[c]="N";
         //l1=new Label(ques[c]);
         l1.setText(ques[c]);
         //p.add(l1);
         //radio=new CheckboxGroup();
         //radioop1=new Checkbox(op1[c],radio,false);
         //radioop2=new Checkbox(op2[c],radio,false);
         //radioop3=new Checkbox(op3[c],radio,false);
         //radioop4=new Checkbox(op4[c],radio,false);
           radioop1.setLabel(op1[c]);
           radioop2.setLabel(op2[c]);
           radioop3.setLabel(op3[c]);
           radioop4.setLabel(op4[c]);

         //p.add(radioop1);
         //p.add(radioop2);
         //p.add(radioop3);
         //p.add(radioop4);
         
         //add("Center",p);
         l2.setText("Q.NO"+(c+1)+"of"+count);
         System.out.println("change="+(c+1)+"    "+count);
         validate();

         return;
    }

}


class mythread extends Thread
{
     examination ex;
     mythread(examination f)
     {
          ex=f;

     }
     public void run()
     {
          long time=ex.count*100000;
          System.out.println("time:"+time);
          for(long i=0;i<time;i++)
          {
              long sec=i/1000;
              long min=sec/60;
              long hr=min/60;
              sec=sec%60;
              String str1="Time:"+hr+"::"+min+"::"+sec;
                int qno=ex.qcounter+1;
               //ex.p3.removeAll();
               //Panel p3=new Panel();
               //Label l2=new Label("Q.NO"+qno+"of"+ex.count);
               //ex.l2.setText("Q.NO"+qno+"of"+ex.count);
               //p3.add(l2);
               //Label l3=new Label(str1);
               ex.l3.setText(str1);
               //p3.add(l3);
               //ex.add("North",p3);
               ex.validate();


          }
          
          System.out.println("time over...");

          ex.dispresults();
          //System.exit(0);
     }
}
