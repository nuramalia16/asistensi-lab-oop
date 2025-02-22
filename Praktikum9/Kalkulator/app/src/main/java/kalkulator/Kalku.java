// /*
//  * This Java source file was generated by the Gradle 'init' task.
//  */
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kalkulator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;



public class Kalku extends Application {
    private Stage stage;

    @Override
    public void start(Stage mainStage) {
        //handling stage
        stage = mainStage;

        //stage
        stage.setTitle("Aplikasi Kalkulator");
        stage.setScene(getScene1());
        stage.setResizable(false);
        stage.show();
    }
    private Scene getScene1() {
        Text tTitle = new Text("KALKULATOR SEDERHANA");
        Button mulai = new Button("MULAI"); 
        VBox sectionRight = new VBox(tTitle, mulai);  
        sectionRight.setSpacing(10); 
        sectionRight.setAlignment(Pos.CENTER);
        mulai.setStyle("-fx-background-color: yellow;");
        mulai.setOnAction(v -> {
            stage.setScene(getScene2()); 
        });

        Image kalku1 = new Image(getClass().getClassLoader().getResourceAsStream("images/kalku1.png"));
        ImageView viewKalku1 = new ImageView(kalku1);
        viewKalku1.setFitWidth(200);
        viewKalku1.setFitHeight(200);
     
        VBox rootNode = new VBox(viewKalku1, sectionRight);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setSpacing(10);
        BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY,null,null);
        Background background = new Background(backgroundFill);
        rootNode.setBackground(background);
        Scene scene = new Scene(new StackPane(rootNode), 300, 480);
        return scene;
    }
    private Scene getScene2() {
        Text tTitle = new Text("PILIH MENU");
        Button bKalkulator1 = new Button("LUAS PERSEGI");
        Button bKalkulator2 = new Button("KELILING PERSEGI");
        Button bKalkulator3 = new Button("LUAS PERSEGI PANJANG");
        VBox sectionRight = new VBox(tTitle, bKalkulator1, bKalkulator2, bKalkulator3);
        sectionRight.setSpacing(15);
        sectionRight.setAlignment(Pos.TOP_CENTER);
        sectionRight.setPrefWidth(30);
        bKalkulator1.setStyle("-fx-background-color: yellow;");
        bKalkulator2.setStyle("-fx-background-color: yellow;");
        bKalkulator3.setStyle("-fx-background-color: yellow;");
        
        //Action untuk Button

        bKalkulator1.setOnAction(v -> {
            stage.setScene(getScene3("Luas Persegi", true));
        });

        bKalkulator2.setOnAction(v -> {
            stage.setScene(getScene3("Keliling Persegi", true));
        });

        bKalkulator3.setOnAction(v -> {
            stage.setScene(getScene3("Luas Persegi Panjang", false));
        });
        //rootNode
        VBox rootNode = new VBox(sectionRight);
        BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY,null,null);
        Background background = new Background(backgroundFill);
        rootNode.setBackground(background);
        Scene scene = new Scene(new StackPane(rootNode), 300, 480);
        return scene;
    }  
    private Scene getScene3(String kalkulator, boolean LuasPersegi) {
        Text tTitle = new Text("Jenis Kalkulator : " + kalkulator);
        Label lInput1 = new Label("Sisi"); 
        TextField tInput1 = new TextField("0"); // Buat taruh tempat input
        Label lInput2 = new Label("Panjang");
        TextField tInput2 = new TextField("0");
        Label linput3 =  new Label("Lebar");
        TextField tinput3 = new TextField("0");
        Label lHasil = new Label();

        Button bClear = new Button("CLEAR");
        Button bCalculate = new Button("CALCULATE");
        Button bBackToHome = new Button("BACK TO HOME");
        bClear.setStyle("-fx-background-color: yellow;");
        bCalculate.setStyle("-fx-background-color: yellow;");
        bBackToHome.setStyle("-fx-background-color: yellow;");

        VBox sectionRight;
        if (LuasPersegi) {
            sectionRight = new VBox(tTitle, lInput1, tInput1, lHasil, bClear, bCalculate, bBackToHome);

        } else  {
            sectionRight = new VBox(tTitle, lInput2, tInput2,linput3,tinput3, lHasil, bClear, bCalculate,
                    bBackToHome);
        }
        sectionRight.setSpacing(15);
        sectionRight.setAlignment(Pos.TOP_CENTER);
        sectionRight.setPrefWidth(0);
        //Action untuk Button
        bClear.setOnAction(v -> {
            tInput1.clear();
            tInput2.clear();
            tinput3.clear();
        });
   
        bCalculate.setOnAction(v -> {
            try {
                double sisi = 0;
                double panjang = 0;
                double lebar = 0;;
                if (!tInput1.getText().isEmpty()) {
                    sisi = Double.parseDouble(tInput1.getText());
                }
                if (!tInput2.getText().isEmpty()) {
                    panjang = Double.parseDouble(tInput2.getText());
                }
                if (!tinput3.getText().isEmpty()) {
                    lebar = Double.parseDouble(tinput3.getText());
                }
                double hasil = 0;
                if (LuasPersegi) {
                    hasil = sisi * sisi;
                    if (kalkulator.equalsIgnoreCase("Keliling Persegi")) {
                        hasil = 4 * sisi;
                } 
                } else {
                    hasil = 2 * (panjang + lebar);
                }
                 lHasil.setText("Hasil: " + hasil);   

            } catch (NumberFormatException e) {
                lHasil.setText("Input tidak Valid");
            
            }       
        });
        bBackToHome.setOnAction(v -> {
            stage.setScene(getScene2());
        });
        VBox rootNode = new VBox(sectionRight);
        BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY,null,null);
        Background background = new Background(backgroundFill);
        rootNode.setBackground(background);
        Scene scene = new Scene(new StackPane(rootNode), 300, 480);
        return scene;
    }
    public static void main(String[] args) {
        launch();
    }

}