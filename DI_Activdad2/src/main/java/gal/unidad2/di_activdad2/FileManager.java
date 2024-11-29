/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gal.unidad2.di_activdad2;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyEditorManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author yago.martinezloureda
 */
public class FileManager extends javax.swing.JFrame {
  public DefaultMutableTreeNode root;
  public Icon closedIcon = new ImageIcon("src/main/resources/images/closed_folder.png");
  public Icon openIcon = new ImageIcon("src/main/resources/images/open_folder.png");
  public Icon leaf = new ImageIcon("src/main/resources/images/leaf.png");
  public JPopupMenu popup = new JPopupMenu();
  public boolean cambiosRealizados = false;

    /**
     * Creates new form FileManager
     */
    public FileManager() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("File manager");
        
        jSplitPane1.setResizeWeight(0.3); 
        jSplitPane1.setContinuousLayout(true);
      
        jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) jTree1.getCellRenderer();
        
        // Creación del popup menu
        renderer.setOpenIcon(openIcon);
        renderer.setClosedIcon(closedIcon);
        renderer.setLeafIcon(leaf);
   
        JMenuItem renameItem = new JMenuItem("Renombrar");
        JMenuItem refreshItem = new JMenuItem("Refrescar");
        JMenuItem newFolderItem = new JMenuItem("Nueva carpeta");
        JMenuItem selectAllItem = new JMenuItem("Select All");

        renameItem.addActionListener(e -> renameNode());
        refreshItem.addActionListener(e -> refreshTree());
        newFolderItem.addActionListener(e -> createNewFolder());
        selectAllItem.addActionListener(e -> selectAllNodes());

        popup.add(renameItem);
        popup.add(refreshItem);
        popup.add(newFolderItem);
        popup.addSeparator();
        popup.add(selectAllItem);
        
        // Implementación de las funciones de los menús
      
        jTree1.addMouseListener(new MouseAdapter() {
           public void mouseReleased(MouseEvent me) {
              showPopup(me); 
              jTree1.setEditable(true);
           }
        }) ;

      }
    
    void showPopup(MouseEvent me) {
          if (me.isPopupTrigger()) {
              DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
              if (selectedNode != null) {
                  popup.show(me.getComponent(), me.getX(), me.getY());
              }
          }
      }
     private void renameNode() {
           DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
          if (selectedNode != null) {
              String newName = JOptionPane.showInputDialog(this, "Renombrar:", selectedNode.getUserObject());
              if (newName != null && !newName.trim().isEmpty()) {
                  selectedNode.setUserObject(newName);
                  modelo.reload();
              }
          }
      }

      private void refreshTree() {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
          if (selectedNode != null) {
              Arbol(new File(selectedNode.getUserObject().toString()));
          }
      }

      private void createNewFolder() {
              DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
          if (selectedNode != null) {
              String folderName = JOptionPane.showInputDialog(this, "Nombre de la nueva carpeta:");
              if (folderName != null && !folderName.trim().isEmpty()) {
                  DefaultMutableTreeNode newFolder = new DefaultMutableTreeNode(folderName);
                  selectedNode.add(newFolder);
                  modelo.reload();
              }
          }
      }

      private void selectAllNodes() {
          for (int i = 0; i < jTree1.getRowCount(); i++) {
              jTree1.addSelectionRow(i);
          }
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(500, 500));

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTree1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });
        jSplitPane1.setRightComponent(jTabbedPane1);

        jMenu1.setText("File");

        abrir.setText("Open");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jMenu1.add(abrir);

        guardar.setText("Save");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jMenu1.add(guardar);

        menu.add(jMenu1);

        jMenu2.setText("Save");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        menu.add(jMenu2);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
    int returnVal = fileChooser.showOpenDialog(this);
    
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File f = fileChooser.getSelectedFile(); 
        if (f != null && f.exists()) {
            if (f.isDirectory()) {
                Arbol(f);
            } else if (f.isFile() && f.getName().toLowerCase().endsWith(".txt")) {
                abrirPestana(f);
            } else {
                JOptionPane.showMessageDialog(this, "Solo se pueden abrir archivos de texto (.txt).", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se puede acceder al archivo o directorio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("No se seleccionó ningún archivo o directorio.");
    }
    }//GEN-LAST:event_abrirActionPerformed

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        // Cerrar pestañas
    if (evt.getButton() == MouseEvent.BUTTON2) { 
        int tabIndex = jTabbedPane1.indexAtLocation(evt.getX(), evt.getY());
        if (tabIndex != -1) {
            JTextArea textArea = (JTextArea) ((JScrollPane) jTabbedPane1.getComponentAt(tabIndex)).getViewport().getView();
            String contenidoActual = textArea.getText(); 

            
            boolean cambiosRealizados = textArea.getDocument().getLength() > 0; 

            if (cambiosRealizados) {
                int res = JOptionPane.showConfirmDialog(this, "¿Quieres guardar los cambios?", "Guardar cambios", JOptionPane.YES_NO_CANCEL_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    guardarArchivo(new File(jTabbedPane1.getTitleAt(tabIndex)), contenidoActual); 
                } else if (res == JOptionPane.CANCEL_OPTION) {
                    return; 
                }
            }
            jTabbedPane1.remove(tabIndex); 
        }
    }
    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void jTree1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MousePressed
        // Abrir pestañas
        
        if (evt.getClickCount() == 2) {  
        int row = jTree1.getRowForLocation(evt.getX(), evt.getY());
        if (row != -1) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getPathForRow(row).getLastPathComponent();
            File file = new File(node.getUserObject().toString());
            
            if (file.isDirectory()) {
                Arbol(file);
            } else if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                abrirPestana(file);
            } else {
                JOptionPane.showMessageDialog(this, "Solo se pueden abrir archivos de texto (.txt).", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_jTree1MousePressed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
     

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_guardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileManager().setVisible(true);
            }
        });
    }
  public DefaultTreeModel modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables
    public void Arbol(File f) {
       root = new DefaultMutableTreeNode(f.getName()); 
       modelo = new DefaultTreeModel(root);
       Crear(root, f);
       jTree1.setModel(modelo);
   }

   public void Crear(DefaultMutableTreeNode dm, File f) {
       File[] ff = f.listFiles();
       if (f != null && ff != null) {
           for (File arch : ff) {
               DefaultMutableTreeNode son = new DefaultMutableTreeNode(arch.getName()); 
               dm.add(son);
               if (arch.isDirectory()) {
                   Crear(son, arch); 
               }
           }
       }
   }

   private void abrirPestana(File file) {
       StringBuilder sb = new StringBuilder();

       for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
           if (jTabbedPane1.getTitleAt(i).equals(file.getName())) {
               jTabbedPane1.setSelectedIndex(i);
               return;
           }
       }

       try (BufferedReader br = new BufferedReader(new FileReader(file))) {
           String cadena;
           while ((cadena = br.readLine()) != null) {
               sb.append(cadena).append(System.lineSeparator());
           }
       } catch (IOException e) {
           JOptionPane.showMessageDialog(this, "Error al abrir el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           return; 
       }

       JTextArea textArea = new JTextArea(sb.toString());


       textArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
           public void insertUpdate(javax.swing.event.DocumentEvent e) {

           }

           public void removeUpdate(javax.swing.event.DocumentEvent e) {

           }

           public void changedUpdate(javax.swing.event.DocumentEvent e) {

           }
       });

       jTabbedPane1.addTab(file.getName(), new JScrollPane(textArea));
       jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1); 
   }


    private void guardarArchivo(File file, String contenido) {
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
           bw.write(contenido);
           bw.flush();
       } catch (IOException e) {
           JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
   }


}


