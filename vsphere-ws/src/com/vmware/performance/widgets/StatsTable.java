/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vmware.performance.widgets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The Class StatsTable.
 */
public class StatsTable extends JPanel {

   /** The table model. */
   private StatsTableModel tableModel;

   /** The label. */
   private JLabel label;

   /**
    * Instantiates a new stats table.
    * 
    * @param columnNames
    *           the column names
    */
   public StatsTable(String[] columnNames) {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      tableModel = new StatsTableModel(columnNames);
      JTable table = new JTable(tableModel);
      table.setPreferredScrollableViewportSize(new Dimension(500, 70));

      //Create the scroll pane and add the table to it.
      JScrollPane scrollPane = new JScrollPane(table);

      //Add the scroll pane to this panel.
      label = new JLabel("");
      add(label);
      add(scrollPane);
   }

   /**
    * Sets the data.
    * 
    * @param timeStamp
    *           the time stamp
    * @param overallUsage
    *           the overall usage
    * @param units
    *           the units
    * @param data
    *           the data
    */
   public void setData(Calendar timeStamp, long overallUsage, String units,
         List<Object[]> data) {
      SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
      String text =
            "Overall Usage : " + overallUsage + " " + units + "  "
                  + sdf.format(timeStamp.getTime());
      label.setText(text);
      tableModel.setData(data);
   }

   /**
    * The Class StatsTableModel.
    */
   class StatsTableModel extends AbstractTableModel {

      /** The column names. */
      private String[] columnNames;

      /** The data. */
      private List<Object[]> data;

      /**
       * Instantiates a new stats table model.
       * 
       * @param columnNames
       *           the column names
       */
      StatsTableModel(String[] columnNames) {
         this.columnNames = columnNames;
         data = new Vector();
      }

      /* (non-Javadoc)
       * @see javax.swing.table.TableModel#getColumnCount()
       */
      public int getColumnCount() {
         return columnNames.length;
      }

      /* (non-Javadoc)
       * @see javax.swing.table.TableModel#getRowCount()
       */
      public int getRowCount() {
         return data.size();
      }

      /* (non-Javadoc)
       * @see javax.swing.table.AbstractTableModel#getColumnName(int)
       */
      public String getColumnName(int col) {
         return columnNames[col];
      }

      /* (non-Javadoc)
       * @see javax.swing.table.TableModel#getValueAt(int, int)
       */
      public Object getValueAt(int row, int col) {
         return ((Object[]) data.get(row))[col];
      }

      /*
       * JTable uses this method to determine the default renderer/
       * editor for each cell.
       */
      /* (non-Javadoc)
       * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
       */
      public Class getColumnClass(int c) {
         if (c == 0) {
            return String.class;
         } else {
            return Long.class;
         }
      }

      /**
       * Sets the data.
       * 
       * @param data
       *           the new data
       */
      public void setData(List<Object[]> data) {
         this.data = data;
         fireTableDataChanged();
      }
   }
}
