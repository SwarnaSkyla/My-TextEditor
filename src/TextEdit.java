
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEdit implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JMenu file, edit,format;
    JMenuItem newFile, openFile, saveFile,print;
    JMenuItem cut, copy, paste, selectAll,close;



    JMenuItem fontfamily;
    JMenuItem fontstyle;
    JMenuItem fontsize;

    JList familylist,stylelist,sizelist;


    JTextArea textarea;
    
    Font newFont;
    
    int fsize=17;
    String []FontFamilyValues={"AgencyFB","Antiqua","Architect","Arial","Calibri","Comic Sans","Courier","Cursive","Impact","Serif"};
    String []FontSizeValues={"5","10","15","20","25","30","35","40","45","50","55","60","65","70"};
    String []FontStyleValues={"PLAIN","BOLD","ITALIC"};
    int []stylevalue={Font.PLAIN,Font.BOLD,Font.ITALIC};
    
    String fontFamily,fontSize,fontStyle;
    int fstyle;



    TextEdit(){
        //Initialized this frame
        frame = new JFrame();
        //Initializing menubar in the frame
        menuBar=new JMenuBar();

        file= new JMenu("File");
        edit=new JMenu("Edit");
        format=new JMenu("Format");


        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(format);

        frame.setJMenuBar(menuBar);
        //initializing textarea

        textarea=new  JTextArea();
        frame.add(textarea);

        //initialise menuitems to file
        newFile=new JMenuItem("New File");
        openFile=new JMenuItem("Open File");
        saveFile=new JMenuItem("Save File");
        print=new JMenuItem("Print");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
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


        //adding scrollbar
        JScrollPane scrollPane=new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel panel=new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        panel.add(scrollPane);
        frame.add(panel);

        //Initializing to format
        fontfamily=new JMenuItem("Font Family");
        fontstyle=new JMenuItem("Font Style");
        fontsize=new JMenuItem("Font Size");
        
        format.add(fontfamily);
        format.add(fontstyle);
        format.add(fontsize);

        fontfamily.addActionListener(this);
        fontstyle.addActionListener(this);
        fontsize.addActionListener(this);

        familylist=new JList(FontFamilyValues);
        stylelist=new JList(FontStyleValues);
        sizelist=new JList(FontSizeValues);

        familylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stylelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sizelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



        textarea.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);



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
                   // frame.setTitle(file.getPath());  adds path at tittle
                }catch (Exception exception){
                    System.out.println(exception);
                }
            }

        }
        if(e.getSource()==print){
            try{
                textarea.print();
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(frame,exception.getMessage());
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
        if(e.getSource()==fontfamily){
            JOptionPane.showConfirmDialog(null,familylist,"Choose Font Family",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            fontFamily=String.valueOf(familylist.getSelectedValue());
             newFont=new Font(fontFamily,fstyle,fsize);
            textarea.setFont(newFont);
        }
        if(e.getSource()==fontstyle){
            JOptionPane.showConfirmDialog(null,stylelist,"Choose Font Style",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
           fontStyle=String.valueOf(stylelist.getSelectedValue());
            fstyle=stylevalue[stylelist.getSelectedIndex()];
            newFont=new Font(fontFamily,fstyle,fsize);
            textarea.setFont(newFont);
        }
        if(e.getSource()==fontsize){
            JOptionPane.showConfirmDialog(null,sizelist,"Choose Font Style",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            fontSize=String.valueOf(sizelist.getSelectedValue());
            fsize=Integer.parseInt(fontSize);
             newFont=new Font(fontFamily,fstyle,fsize);
            textarea.setFont(newFont);
        }



    }
}
