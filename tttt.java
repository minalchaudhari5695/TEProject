package attg;


//package components;

/*
 * SimpleTableDemo.java requires no other files.
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import javax.swing.table.TableModel;

public class tttt extends JPanel {
    //private boolean DEBUG = false;
boolean flag;
    String columnNames[] = {"timeslot","mon","tue","wed","thur","fri","sat"};
      Object[][] data = {
        {"11-12","*","*","*","*","*","*","*" },
        {"12-1","*","*","*","*","*","*","*" },
        {"1-1:45","r","r","r","r","r","r","r" },
        {"1:45-2:45","*","*","*","*","*","*","*" },
        {"2:45-3:45","*","*","*","*","*","*","*" },
        {"3:45-4:45","*","*","*","*","*","*","*" },
        {"4:45-5:45","*","*","*","*","*","*","*" },
         };
    
    public tttt() {
        super(new GridLayout(1,0));
          JTable table=new JTable(data,columnNames);
        table.setEnabled(false);
      table.setPreferredScrollableViewportSize(new Dimension(500, 110));
        table.setFillsViewportHeight(true);
      //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
        add(scrollPane);
      //    validate();      
          Vector<String> sub = new Vector<String>();
       try {
            java.sql.Connection conn = DBConnection.connect();
            Statement st = conn.createStatement();

             ResultSet rs=st.executeQuery("select distinct sname from sub_manager group by sname");
             while(rs.next())
             {
                 String s=rs.getString("sname");
                 sub.addElement(s);
             }
        }
       catch(Exception e){}
      int c=0,i,j=1;
    data[0][1]="oomd-a1,dbms-a2";
      data[1][1]=",wpl-a3,os-a4";
      data[5][2]="oomd-a2,dbms-a3";
      data[6][2]=",wpl-a4,os-a1";
      data[0][3]="oomd-a3,dbms-a4";
      data[1][3]=",wpl-a1,os-a2";
      data[5][4]="oomd-a4,dbms-a1";
      data[6][4]=",wpl-a2,os-a3";
      int k=0;
      int col=table.getColumnCount();
      int row=table.getRowCount();
        
    
           for(i=0;i<row;i++)
           {
               for(j=1;j<col;j++)
           {
                 String s1=sub.get(k);
               
              if(table.getValueAt(i,j).equals("*"))
              {  table.setValueAt(s1, i, j);
              c++;
              if(c==4)
              { c=0;
                  k++;
                  break;
            }
           }
           }
           }
      }
          
    private void printDebugData(JTable table) throws IOException {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
    
        }
    

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create and set up the content pane.
        tttt newContentPane = new tttt();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        frame.setAlwaysOnTop(true);
        //Display the window.
   // frame.validate();
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        
    }

 
    
   public void get_data()
   {
       ArrayList ar=new ArrayList();
       try{
         Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection myConnection1=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/practicle","minal","system");
           Statement st=myConnection1.createStatement();
                 ResultSet rs=st.executeQuery("select * from teacher_info");
           while(rs.next()){
           
           ar.add(rs.getString(2));
           }
           Iterator itr=new Iterator() {

                @Override
                public boolean hasNext() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public Object next() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
          while(itr.hasNext()){
          System.out.println(itr.next());
          }
       }
       catch(Exception e){}
     
   }
   
}