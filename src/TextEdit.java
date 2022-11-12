
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        textarea=new  JTextArea();
        frame.add(textarea);

        //initialise menuitems
        newFile=new JMenuItem("New File");
        openFile=new JMenuItem("Open File");
        saveFile=new JMenuItem("Save File");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

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

        frame.setTitle("Text Editor");




        frame.setBounds(100, 100, 400 , 400);
        frame.setVisible(true);

    }
    public static void main(String[] args){
        TextEdit textEditor = new TextEdit();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==newFile){

        }
        if(e.getSource()==saveFile){

        }
        if(e.getSource()==openFile){

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
