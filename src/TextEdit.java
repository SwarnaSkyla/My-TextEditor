
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEdit implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JMenu file, edit;
    JMenuItem newFile, openFile, saveFile;
    JMenuItem cut, copy, paste, selectAll, close;
    JTextArea textarea;

    TextEdit(){
        //Initialized this frame
        frame = new JFrame();
        menuBar=new JMenuBar();
        file= new JMenu("File");
        edit=new JMenu("Edit");

        menuBar.add(file);
        menuBar.add(edit);

        frame.setJMenuBar(menuBar);
        //initializing textarea

        textarea=new  JTextArea();
        frame.add(textarea);

        //initialise menuitems to file
        newFile=new JMenuItem("New File");
        openFile=new JMenuItem("Open File");
        saveFile=new JMenuItem("Save File");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        //initialise menuitems to edit

        cut=new JMenuItem("cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        selectAll=new JMenuItem("Select All");
        close= new JMenuItem("Close");


        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);


        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        JScrollPane scrollPane=new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel panel=new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        panel.add(scrollPane);
        frame.add(panel);


        frame.setTitle("Text Editor");




        frame.setBounds(100, 100, 400 , 400);
        frame.setVisible(true);

    }
    public static void main(String[] args){
        TextEdit textEditor = new TextEdit();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==newFile){
            TextEdit newtexteditor= new TextEdit();

        }
        if(e.getSource()==saveFile){
            JFileChooser fileChooser=new JFileChooser("C:");
            fileChooser.setApproveButtonText("Save");
            int chooseoption=fileChooser.showSaveDialog(null);

            if(chooseoption==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                String filepath=file.getPath();
                try{
                    BufferedWriter outfile=null;
                    outfile =new BufferedWriter(new FileWriter(file));
                    textarea.write(outfile);
                    outfile.close();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }

        }
        if(e.getSource()==openFile){
            JFileChooser fileChooser=new JFileChooser("C:");
            int chooseoption=fileChooser.showOpenDialog(null);

            if(chooseoption==JFileChooser.APPROVE_OPTION){
                File file=fileChooser.getSelectedFile();
                String filepath=file.getPath();

                try{
                    BufferedReader bufferedreader=new BufferedReader(new FileReader(filepath));
                    String intermmediate="",output="";
                    while((intermmediate=bufferedreader.readLine())!=null){
                        output+=intermmediate+"\n";
                    }
                    textarea.setText(output);
                }catch (Exception exception){
                    System.out.println(exception);
                }
            }

        }
        if(e.getSource()==cut){
            textarea.cut();
        }
        if(e.getSource()==copy){
            textarea.copy();

        }
        if(e.getSource()==paste){
            textarea.paste();

        }
        if(e.getSource()==selectAll){
            textarea.selectAll();

        }
        if(e.getSource()==close){
            System.exit(0);

        }

    }
}
