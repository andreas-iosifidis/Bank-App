
package bankapp;





import java.io.IOException;

import java.util.ArrayList;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

import java.time.LocalDateTime;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import javafx.scene.layout.CornerRadii;

import javafx.scene.layout.VBox;




public class BankApp extends Application {
       
   

    Stage stage,stage3;
    Scene Login,index,index3,Analipsi,Katathesi,kiniseis;
    GridPane loginPane,indexPane,indexPane2,analipsiPane,katathesiPane,kiniseisPane;
    BorderPane loginPane1,indexPane1,analipsiPane1,katathesiPane1,kiniseisPane1;
    HBox loginPane2,analipsiPane3,katathesiPane3,kiniseis3;
    VBox analipsibox;
    Label Welcome,username,password,error2,error3,MoneY,AccountHistory;
    Button close,login,logout,analipsi,katathesi,istoriko,back,confirm,cancel,confirm2,back2,confirm3,back3,print;
    TextArea area;
    TextField Username,posoKatathesis;
    PasswordField Password,p1,p2;
    
    MenuBar indexBar;
    Menu menu1,menu2;
    MenuItem indexMenuItem1,indexMenuItem2,indexMenuItem3;
    static Label error,fill,inform,inform2;
    RadioButton box1,box2,box3,box4;
    Account user=new Account(0,0);
    Account userNull=new Account(0,0);
   
    Account account1=new Account(11110001,1234); 
    Account account2=new Account(11110002,5678); 
    Account account3=new Account(11110003,2345); 
    
        public void loginProcess(){
        if((Username.getText().equals(account1.GetIDtoString())) && (Password.getText().equals(account1.GetPasswordtoString()))){              
                user.copyAccount( account1);
                account1.logged=true;account2.logged=false;account3.logged=false;
                stage.setScene(index);MoneY.setText("Your balance is : "+account1.getMoney()+" $");
                
         } else if((Username.getText().equals(account2.GetIDtoString())) && (Password.getText().equals(account2.GetPasswordtoString()))){
                user.copyAccount( account2);
                account2.logged=true;account1.logged=false;account3.logged=false;
                stage.setScene(index);   MoneY.setText("Your balance is : "+account2.getMoney()+" $");      
                
         }
         else if((Username.getText().equals(account3.GetIDtoString())) && (Password.getText().equals(account3.GetPasswordtoString()))){
                user.copyAccount( account3);
                account3.logged=true;account1.logged=false;account2.logged=false;
                stage.setScene(index); MoneY.setText("Your balance is : "+account3.getMoney()+" $");
                
         }
        
        else{ error.setVisible(true);  } }
    @Override
    public void start(Stage primaryStage) throws IOException {
    stage=primaryStage;

    
    stage.setTitle("MyBank");
    loginPane=new GridPane();
    loginPane1=new BorderPane();
    loginPane1.setCenter(loginPane);
    username=new Label("Username");
    password=new Label("password");
    Username=new TextField();Username.setPrefColumnCount(10);
    Password=new PasswordField();Password.setPrefColumnCount(10);
    error=new Label("Wrong Credentials please try again");
    error.setFont(new Font("Verdana",14));
    error.setTextFill(Color.RED);
    error.setVisible(false);
     Welcome=new Label(""); 
     Welcome.setText("Welcome");
     Welcome.setFont(new Font("Verdana",20));
     stage.setResizable(false);
    loginPane.setAlignment(Pos.CENTER);
    loginPane.addRow(0, Welcome);
    loginPane.addRow(1,new Text("please fill your credentials"));
    loginPane.addRow(2, username,Username);
    loginPane.addRow(3,password,Password);
    loginPane.addRow(4, error);
    loginPane.setHgap(-180);loginPane.setVgap(10);
    loginPane1.setPadding(new Insets(10,10,10,10));
    close=new Button("Close");
    Region spacer=new Region();
    login=new Button("Login");login.setDefaultButton(true);
    login.setFocusTraversable(true);login.requestFocus();
    loginPane2=new HBox();loginPane2.setPadding(new Insets(10,10,10,10));
    HBox.setHgrow(spacer, Priority.ALWAYS);
    loginPane2.getChildren().addAll(close,spacer,login);
    loginPane1.setBottom(loginPane2);
    Login= new Scene(loginPane1,500,500);
    stage.setScene(Login);
    close.setOnAction(g->{ confirmationBox a=new confirmationBox();a.show();});
   
    login.setOnAction(e->{loginProcess(); } );
    login.setOnKeyPressed(Key->{if(Key.getCode()==KeyCode.ENTER){loginProcess();}});
    Region spacer3=new Region();
    menu1=new Menu("Your Account");
    menu2=new Menu("Help");
    
    
    indexBar=new MenuBar();
    indexMenuItem1=new MenuItem("change password");
    indexMenuItem1.setOnAction(jj->{passwordChangeStage();});
    indexMenuItem2=new MenuItem("Account info");
    LocalDateTime localdate= LocalDateTime.now();String Date=localdate.format(ISO_LOCAL_DATE);
    String Time=localdate.format(ISO_LOCAL_TIME);
    indexMenuItem2.setOnAction(e->{success("Username :"+String.valueOf(user.getAccountID())
    +"\n"+"Password :"+String.valueOf(user.getPassword())+"\n"+
            "Entered at date :"+Date+" "+Time);} );
            
    indexMenuItem3=new MenuItem("Log Out");
    indexMenuItem3.setOnAction(e->{  account1.logged=false; account2.logged=false;user.copyAccount( userNull);
    account3.logged=false; stage.setScene(Login);   clearArea();
    Username.setText(null);  Password.setText(null); error.setVisible(false);});
    SeparatorMenuItem separator=new SeparatorMenuItem();
    menu1.getItems().addAll(indexMenuItem1,separator,indexMenuItem3);
    menu2.getItems().add(indexMenuItem2);
    indexBar.getMenus().addAll(menu1,menu2);
     indexPane=new GridPane();
     indexPane1=new BorderPane();
     
     indexPane1.setTop(indexBar);indexBar.setOpacity(5);
     indexPane1.setCenter(indexPane);
     Label action=new Label("Please select an action.");
     Label action2=new Label("Welcome to BankApp");
     action2.setFont(Font.font("Verdana",FontWeight.BOLD,20));
     action.setAlignment(Pos.CENTER_LEFT);
     action2.setAlignment(Pos.TOP_CENTER);
     action.setFont(new Font("Verdana",14));
     analipsi=new Button("Withdrawal"); analipsi.setPrefSize(100, 50);
     
     
     analipsi.setFont(new Font("Verdana",14));
     katathesi=new Button("Deposit"); katathesi.setPrefSize(100, 50);
     katathesi.setFont(new Font("Verdana",14));
     istoriko=new Button("History"); istoriko.setPrefSize(100, 50);
     istoriko.setFont(new Font("Verdana",14));
     indexPane.setVgap(10);indexPane.setAlignment(Pos.CENTER);
     MoneY=new Label(); MoneY.setStyle("-fx-border-color: black;");
     indexPane.addRow(0,action2);
     indexPane.addRow(1,action);
     indexPane.addRow(2,analipsi);
     indexPane.addRow(3,katathesi);
     indexPane.addRow(4,istoriko);indexPane1.setRight(MoneY);
    index=new Scene(indexPane1,500,500);
    indexPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    analipsiPane1=new BorderPane();
    analipsiPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    analipsiPane=new GridPane();
    analipsiPane1.setCenter(analipsiPane);
     

    MoneY.setFont(new Font("Verdana",15));
    MoneY.setTextFill(Color.RED);MoneY.setPadding(new Insets(10,10,10,10));
   
    
    Analipsi=new Scene(analipsiPane1,500,500);
    Label lbl=new Label("Please select the amount of money.");
    lbl.setFont(new Font("Verdana",14));
    box1=new RadioButton(String.valueOf(Account.poso));
    box2=new RadioButton(String.valueOf(Account.poso1));
    box3=new RadioButton(String.valueOf(Account.poso2));
    box4=new RadioButton(String.valueOf(Account.poso3));
    
    ToggleGroup box=new ToggleGroup();
    box1.setToggleGroup(box);
    box2.setToggleGroup(box);
    box3.setToggleGroup(box);
    box4.setToggleGroup(box);
    inform=new Label("Unfortunately your balance is not enough.");
    inform.setFont(new Font("Verdana",14));inform.setTextFill(Color.RED);
    inform.setVisible(false);
    cancel=new Button("Back");
    confirm2=new Button("Confirm");
    analipsiPane.setPadding(new Insets(10,10,10,10));analipsiPane.setVgap(10);
    analipsiPane.setAlignment(Pos.CENTER);
    analipsiPane.addRow(0, lbl);
    analipsiPane.addRow(1, box1);
    analipsiPane.addRow(2, box2);
    analipsiPane.addRow(3, box3);
    analipsiPane.addRow(4, box4);
    analipsiPane.addRow(5, inform);
    analipsi.setOnAction(e->stage.setScene(Analipsi));
    Region spacer2=new Region();
    HBox.setHgrow(spacer2, Priority.ALWAYS);
    analipsiPane3=new HBox(cancel,spacer2,confirm2);analipsiPane3.setPadding(new Insets(10,10,10,10));
    analipsiPane1.setBottom(analipsiPane3);
    cancel.setOnAction(e->stage.setScene(index));
    confirm2.setOnAction(e->{
        try {if(Account.isON(account1)){Withdraw(account1);}
        else if(Account.isON(account2)){Withdraw(account2);}
        else if(Account.isON(account3)){Withdraw(account3);}
            
        } catch (IOException ex) {
            Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    katathesiPane=new GridPane();
    katathesiPane.setPadding(new Insets(10,10,10,10));
    katathesiPane.setVgap(10);
    katathesiPane1=new BorderPane();
    katathesiPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    katathesiPane1.setCenter(katathesiPane);
    katathesiPane.setAlignment(Pos.CENTER);
     posoKatathesis=new TextField();
    inform2=new Label("Please insert the quantity to deposit."+"\n"+"(Only numbers allowed)");
    error3=new Label("Please insert numbers between 50 and 1000");
    error3.setVisible(false);
    katathesiPane.addRow(0, inform2);
    katathesiPane.addRow(1,posoKatathesis);
    katathesiPane.addRow(2, error3);
    back2=new Button("Back");
    confirm3=new Button("Confirm");
    Region spacer4=new Region();
    katathesiPane1.setPadding(new Insets(10,10,10,10));
    HBox.setHgrow(spacer4, Priority.ALWAYS);
    katathesiPane3=new HBox(back2,spacer4,confirm3);
    katathesiPane1.setBottom(katathesiPane3);
    Katathesi=new Scene(katathesiPane1,500,500);
    katathesi.setOnAction(e->stage.setScene(Katathesi));
    back2.setOnAction(e->{stage.setScene(index);posoKatathesis.setText(null);});
    
    error3.setFont(new Font("Verdana",14));
    error3.setTextFill(Color.RED);
    confirm3.setOnAction(e->{
        try {if(Account.isON(account1)){Deposit(account1);}
        else if(Account.isON(account2)){Deposit(account2);}
        else if(Account.isON(account3)){Deposit(account3);}
            
        } catch (IOException ex) {
            Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    kiniseisPane=new GridPane();
    kiniseisPane1=new BorderPane();
 
    kiniseisPane1.setCenter(kiniseisPane);
    kiniseisPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    kiniseis=new Scene(kiniseisPane1,500,500);
    area=new TextArea();
    AccountHistory=new Label("Account history movement");
    AccountHistory.setAlignment(Pos.CENTER);AccountHistory.setPadding(new Insets(10,10,10,10));
    AccountHistory.setFont(new Font("Verdana",20));
    area.setPrefSize(300, 400);area.setEditable(false);
    String d="Date"; String s="Deposit/withdraw"; String f="Quantity";
    area.setText(String.format("%s"+"%35s"+"%20s", d,s,f));
    back3=new Button("back");back3.setOnAction(e->stage.setScene(index));
    print=new Button("print");print.setOnAction(e->success(""));
    kiniseisPane1.setTop(new VBox(AccountHistory));
    kiniseisPane.add(area,0,0);kiniseisPane.setAlignment(Pos.CENTER);
    Region spacer5=new Region();
    kiniseis3=new HBox();kiniseis3.setPadding(new Insets(10,10,10,10));
    HBox.setHgrow(spacer5, Priority.ALWAYS);
    kiniseis3.getChildren().addAll(back3,spacer5,print);
    kiniseisPane1.setBottom(kiniseis3);
    istoriko.setOnAction(e->stage.setScene(kiniseis));
    stage.show();
    
    
     
     
    }
    
    
    
    public void clearArea(){ String d="Date"; String s="Deposit/withdraw"; String f="Quantity";
    area.setText(String.format("%s"+"%35s"+"%20s", d,s,f));}
    
   LocalDateTime localdate2= LocalDateTime.now();String Date1=localdate2.format(ISO_LOCAL_DATE);
   
   public void Withdraw(Account account) throws IOException{ String text="Succesfull procedure, you earned ";String g="Withdraw";
    String f="1111xxxx";
   if((box4.isSelected()) && (account.getMoney()>=Account.poso3)){account.setMoney(account.getMoney()-Account.poso3);
   MoneY.setText("Your balance is : "+account.getMoney()+" $");
   inform.setVisible(false);
   area.appendText("\n"+String.format("%s"+"%20s"+"%28d",Date1,g,Account.poso3));
   String b=String.format("%s"+"%20s"+"%30d",Date1,g,Account.poso3)+"\n";
   account.saveToFile(account,b);
   success2("********************************"+"\n"+String.format(
                "User ID: %s %n Action: %s %n Quantity: %d %n Date: %s"
                ,f, g,Account.poso3,Date1)+"\n"+
                "********************************");}
   else if((box3.isSelected()) && (account.getMoney()>=Account.poso2)){account.setMoney(account.getMoney()-Account.poso2);
   MoneY.setText("Your balance is : "+account.getMoney()+" $");
   inform.setVisible(false);
   area.appendText("\n"+String.format("%s"+"%20s"+"%28d",Date1,g,Account.poso2));
   account.saveToFile(account,String.format("%s"+"%20s"+"%30d",Date1,g,Account.poso2));
   success2("********************************"+"\n"+String.format(
                "User ID: %s %n Action: %s %n Quantity: %d %n Date: %s"
                ,f, g,Account.poso2,Date1)+"\n"+
                "********************************");
   }
   else if((box2.isSelected()) && (account.getMoney()>=Account.poso1)){account.setMoney(account.getMoney()-Account.poso1);
   MoneY.setText("Your balance is : "+account.getMoney()+" $");
   inform.setVisible(false);
   area.appendText("\n"+String.format("%s"+"%20s"+"%28d",Date1,g,Account.poso1));
   account.saveToFile(account,String.format("%s"+"%20s"+"%30d"+"\n",Date1,g,Account.poso1));
   success2("********************************"+"\n"+String.format(
                "User ID: %s %n Action: %s %n Quantity: %d %n Date: %s"
                ,f, g,Account.poso1,Date1)+"\n"+
                "********************************");}
   else if((box1.isSelected()) && (account.getMoney()>=Account.poso)){account.setMoney(account.getMoney()-Account.poso);
   inform.setVisible(false);
   area.appendText("\n"+String.format("%s"+"%20s"+"%28d",Date1,g,Account.poso));
   MoneY.setText("Your balance is : "+account.getMoney()+" $");
   account.saveToFile(account,String.format("%s"+"%20s"+"%30d",Date1,g,Account.poso));
   success2("********************************"+"\n"+String.format(
                "User ID: %s %n Action: %s %n Quantity: %d %n Date: %s"
                ,f, g,Account.poso,Date1)+"\n"+
                "********************************");}
   else if(((box4.isSelected())&& (account.getMoney()<Account.poso3)) ||
           ((box3.isSelected()) && (account.getMoney()<Account.poso2)) || 
           ((box2.isSelected()) && (account.getMoney()<Account.poso1)) ||
           ((box1.isSelected()) && (account.getMoney()<Account.poso))){inform.setVisible(true);}
    
    }
    
    public void Deposit(Account account) throws IOException{String g="Deposit"; String f="1111xxxx";
        try{if((Integer.valueOf(posoKatathesis.getText())<=1000) && (Integer.valueOf(posoKatathesis.getText())>=50)){
        if(Integer.valueOf(posoKatathesis.getText())>0){account.setMoney(Integer.valueOf(posoKatathesis.getText())+account.getMoney());
        account.saveToFile(account,String.format("%s"+"%20s"+"%30d",Date1,g,Integer.valueOf(posoKatathesis.getText())));
        success2("********************************"+"\n"+String.format(
                "User ID: %s %n Action: %s %n Quantity: %d %n Date: %s"
                ,f, g,Integer.valueOf(posoKatathesis.getText()),Date1)+"\n"+
                "********************************");
        MoneY.setText("Your balance is : "+account.getMoney()+" $");
       error3.setVisible(false); 
        area.appendText("\n"+String.format("%s"+"%20s"+"%30d",Date1,g,Integer.valueOf(posoKatathesis.getText())));
        posoKatathesis.setPromptText(null);}}
        else{error3.setVisible(true);posoKatathesis.setText(null);
            
        }}
        catch(NumberFormatException e){error3.setVisible(true);}
    }
    
    
    public static void main(String[] args) {

 
        launch(args);
    }
    
    
   
    
   
    
    class confirmationBox {
            
    Stage stage2;
    HBox confirmation,confirmation3;
    BorderPane confirmation2;
    Scene scene2;
    Label confirm;
    Button ok,cancel2;
    Region spacer2;
    
    
    public void show(){
       stage2=new Stage();
        
        stage2.setTitle("Are you sure?");stage2.setResizable(false);
            confirm=new Label();
            ok=new Button("OK"); cancel2=new Button("cancel");
            ok.defaultButtonProperty().bind(ok.focusedProperty());
            confirmation=new HBox(confirm);confirmation.setAlignment(Pos.CENTER);
            confirmation2=new BorderPane(confirmation);
            confirmation2.setCenter(confirmation);
            confirmation2.setPadding(new Insets(10,10,10,10));
            spacer2=new Region();
            HBox.setHgrow(spacer2, Priority.ALWAYS);
            confirmation3=new HBox(cancel2,spacer2,ok);
            confirmation2.setBottom(confirmation3);
            scene2=new Scene(confirmation2,300,50);
            stage2.setScene(scene2);
            confirm.setFont(new Font("Verdana",15));
            confirm.setText("Press OK to exit.");
            ok.setFocusTraversable(true);
            ok.setOnAction(e->{stage2.close(); stage.close();});
            ok.setOnKeyPressed(key->{if(key.getCode()==KeyCode.ENTER){stage2.close();stage.close();}});
            stage2.show();
            cancel2.setOnAction(e->{stage2.close();});
            }
    
    
        }
    
    public void success(String s){
    Label l=new Label(s);
    Button OK=new Button("OK");
    Stage stage4=new Stage();
    VBox vbox=new VBox(l,OK);
    Scene scene=new Scene(vbox,300,300);
    stage4.setScene(scene);
    vbox.setAlignment(Pos.CENTER);
    vbox.setPadding(new Insets(10,10,10,10));
    OK.setOnAction(e->{stage4.close();});
    stage4.setResizable(false);
    vbox.setVisible(true);
    stage4.show();
    }
    public void success2(String s){
    Label l=new Label();
    l.setText(s);
     cancel=new Button("Cancel");
     print=new Button("Print");
    Stage stage5=new Stage(); 
    VBox vbox5=new VBox(l);
    BorderPane pane5=new BorderPane();
    pane5.setCenter(vbox5);
    Region spacer=new Region();
    HBox.setHgrow(spacer, Priority.ALWAYS);
    pane5.setBottom(new HBox(cancel,spacer,print));
    pane5.setPadding(new Insets(10,10,10,10));
    Scene scene=new Scene(pane5,300,300);
    stage5.setScene(scene);
    vbox5.setAlignment(Pos.CENTER);
    vbox5.setPadding(new Insets(10,10,10,10));
    cancel.setOnAction(e->{stage5.close();});
    stage5.setResizable(false);
    vbox5.setVisible(true);
    pane5.setVisible(true);
    stage5.show();
    }
    
    
    public void passwordChangeStage(){
     stage3=new Stage(); stage3.setTitle("Password Change"); stage3.setResizable(false);
    Button A=new Button("Cancel"); A.setOnAction(w->{stage3.close();});
    Button B=new Button("Confirm"); 
    
    Label PassChange=new Label("Please type old and new password.");
     error2=new Label("Input mismatch, please try again.");
    error2.setFont(new Font("Verdana",15)); error2.setTextFill(Color.RED);
    error2.setVisible(false);
    fill=new Label("Please fill in your password.");fill.setVisible(false);
    fill.setFont(new Font("Verdana",15));   fill.setTextFill(Color.RED);
    Label newpass=new Label("New password"); Label newpass1=new Label("Confirm password");
    Font f=new Font("Verdana",13); PassChange.setFont(f);
     p1=new PasswordField(); p2=new PasswordField();
     
    GridPane grid=new GridPane(); grid.setHgap(-80); grid.setVgap(10);grid.setPadding(new Insets(10,10,10,10));
    grid.addRow(0, PassChange);
    grid.addRow(1,newpass,p1);  grid.addRow(2,newpass1,p2);
    grid.addRow(3, error2);
    grid.addRow(4, fill);
    grid.addRow(5, A,B);
    Scene passChange=new Scene(grid,380,350);grid.setVisible(true);
    stage3.setScene(passChange);stage3.show();grid.setAlignment(Pos.CENTER);
    B.setOnAction(e->{if(Account.isON(account1)){passChange(account1);}
    else if(Account.isON(account2)){passChange(account2);}
    else if(Account.isON(account3)){passChange(account3);}});
    indexPane2=new GridPane();
    Button ok=new Button("OK");
    Label lbl=new Label("Your password has changed" );
    Label lbl1=new Label("press OK to return to HomePage");
    indexPane2.setAlignment(Pos.CENTER);
    indexPane2.addRow(0, lbl);
    indexPane2.addRow(1, lbl1);
    indexPane2.addRow(2, ok);
    ok.setOnAction(e->stage3.close());
    index3=new Scene(indexPane2,380,350);
    }
     
    public void passChange(Account account) {
        
       if(!(p1.getText().isEmpty()) && !(p2.getText().isEmpty())){
           try{
       if(p1.getText().equals(p2.getText())){user.SetPassword(Integer.valueOf(p1.getText()));
       stage3.setScene(index3);
      account.SetPassword(user.getPassword());
       }}
           catch(NumberFormatException e){e.getMessage();
      
       error2.setVisible(true);}
    
            }
       else{fill.setVisible(true);}
    }
    
 
}


    

