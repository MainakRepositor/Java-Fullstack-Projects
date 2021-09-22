import java.awt.*;

public class answerlist extends Frame
{
     String[] uans,umark;
     int count,i;
     public List anslist;
     String topic;
     int snum;
     Panel p,p1,p2;
     Label l1;
     Button b1,b2;
     examination ex;
     int mark;
     CheckboxGroup cbg;
     Checkbox cba[];
     int amark[];
     int umarkcount;
   //int qcount,String[] uanswer,int mark,int stdno,String top
   public answerlist(examination d)
   {
      //count,uans,qmark,stdno,topi
      ex=d;
      count=ex.count;
      topic=ex.topi;
      snum=ex.stdno;
      uans=new String[count];
      umark=new String[count];
      umarkcount=0;
      for(i=0;i<count;i++)
      {

          uans[i]=ex.uans[i];
          umark[i]=ex.umark[i];
          if(umark[i].equals("M"))
          {
            umarkcount++;  
          }

      }
      cbg =new CheckboxGroup();
      amark=new int[umarkcount];
      cba=new Checkbox[umarkcount];
     int xz=0;
     for(i=0;i<count;i++)
     {
               if(umark[i].equals("M"))
               {

                    uans[i]=umark[i]+uans[i];
                    amark[xz]=i;
                    cba[xz]=new Checkbox("",cbg,false);
                    xz++;
               }
      }
      p=new Panel();
      p.setLayout(new FlowLayout());
      Label ls[]=new Label[count];
      xz=0;
      for(i=0;i<count;i++)
      {
               ls[i]=new Label(uans[i]);
               if(umark[i].equals("M"))
               {
                p.add(cba[xz]);
                xz++;
               }
               p.add(ls[i]);

      }
      for(int h=0;h<count;h++)
      {
        System.out.println(ex.uans[h]);

      }
      add("Center",p);
      
      p1=new Panel();
      l1=new Label("ANSWER SHEET");
      p1.add(l1);
      add("North",p1);

      p2=new Panel();
      b1=new Button("Review");
      b2=new Button("End");
      p2.add(b1);
      p2.add(b2);
      add("South",p2);

   }
   public boolean handleEvent(Event e)
   {
        if(e.id==Event.WINDOW_DESTROY)
                System.exit(0);
        return super.handleEvent(e);
   }

   public boolean action(Event e,Object o)
   {
          if(e.target.equals(b1))  //review
          {
                    //examination ex=new examination(snum,topic);
             hide();
                    //ex.resize(300,300);
             
             for(int k=0;k<umarkcount;k++)
             {
                if(cba[k].getState()==true)
                {
                    mark=amark[k];

                }


             }
             ex.show();
             ex.add124(mark);
          }
          else if(e.target.equals(b2))  //end
          {
              hide();
              ex.dispresults();
          }
          else return super.action(e,o);
          return true;

     }
}
