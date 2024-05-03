import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;

public class CurrencyView extends Application{

    private CurrencyController controller;

    @Override
    public void start(Stage stage) {


        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>();

        choiceBox1.getItems().addAll(CurrencyModel.EUR, CurrencyModel.USD, CurrencyModel.GBP);
        choiceBox2.getItems().addAll(CurrencyModel.EUR, CurrencyModel.USD, CurrencyModel.GBP);

        VBox root1 = new VBox(choiceBox1);
        VBox root2 = new VBox(choiceBox2);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label currencyLabel = new Label("Currency you want to convert: ");
        Label checkBox1 = new Label("Select your currency:");
        currencyLabel.setId("currencyLabel");
        TextField textField = new TextField();
        textField.setId("textField");
        Label conversionLabel = new Label("Conversion: ");
        Label checkBox2 = new Label("Select the currency " +
                "you want:");
        conversionLabel.setId("conversionLabel");
        Label conversion = new Label();
        conversion.setId("conversion");

        Button convert = new Button("Convert");

        gridPane.addRow(0, currencyLabel, checkBox1);
        gridPane.addRow(1, textField, root1);
        gridPane.addRow(2, conversionLabel, checkBox2);
        gridPane.addRow(3, conversion, root2);
        gridPane.addRow(4, convert);


        convert.setOnAction(actionEvent -> {
            try {
                Double userInput = Double.valueOf(textField.getText());
                String type1 = choiceBox1.getValue();
                String type2 = choiceBox2.getValue();
                Double defined = controller.startConversion(userInput, type2, type1);
                conversion.setText(String.valueOf(defined));
            } catch (NumberFormatException e) {
                conversion.setText("Please put a number. ");
            }
            });
        Scene scene = new Scene(gridPane, 500, 400);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Currency converter");
        stage.show();
    }

    public void init() {
        controller = new CurrencyController(this);
    }
}