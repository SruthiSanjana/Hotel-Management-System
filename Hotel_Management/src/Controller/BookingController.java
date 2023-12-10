package Controller;


import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class BookingController implements Initializable {

    @FXML
    private Button closeButton;

    @FXML
    private Label labelPrice;
    
    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldAddress;

    @FXML
    private TextField fieldPhone;

    @FXML
    private TextField fieldIdentityNumber;
    
    @FXML
    private DatePicker dateFrom;

    @FXML
    private DatePicker dateTo;

    @FXML
    private CheckBox CheckBoxExtraBed;
    
    @FXML
    private TextField fieldRoomNumber;

    @FXML
    private TextField fieldRoomType;

    @FXML
    private TextField fieldCost;
    /**
     * Initializes the controller class.
     */
    @FXML
    public void closeForm() {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void setRoomInfo(int roomNo, String roomType, int roomPrice) {
       
        
       fieldRoomNumber.setText(String.valueOf(roomNo));
       fieldRoomType.setText(roomType);
       labelPrice.setText(String.valueOf(roomPrice));
    }
    
    public void calculateCost() {
        LocalDate from = dateFrom.getValue();
        LocalDate end = dateTo.getValue();
        int days = (int) ChronoUnit.DAYS.between(from, end);
        
        int cost = days * Integer.valueOf(labelPrice.getText());
        
        if(CheckBoxExtraBed.isSelected()){
            cost = cost + 100;
        }
        
        /*
         * Convert cost integer to rupiah currency
         * And Dispay cost in rupiah to cost field
         */
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
 
        formatRp.setCurrencySymbol("$. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
 
        kursIndonesia.setDecimalFormatSymbols(formatRp);
//        System.out.printf("Harga Rupiah: %s %n", kursIndonesia.format(harga));
 
        NumberFormat kurensiIndonesia = NumberFormat.getCurrencyInstance(new Locale("us","USD"));
        fieldCost.setText(String.valueOf(kurensiIndonesia.format(cost)));
    }
    
    public void submitForm(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Dashboard.fxml"));
            Parent root = (Parent) loader.load();
            
            DashboardController DashboardController = loader.getController();
            
            //Get Room Number
            
            //Update status to booked
            String query = "UPDATE sanjanadivya_rooms SET Status='Booked' WHERE Room_no="+fieldRoomNumber.getText()+"";
            DashboardController.executeQuery(query);
            
            //Insert guest data
            query = "INSERT INTO `sanjanadivya_guests` (`name`, `phone`, `identity_number`, `room_no`) "
                    + "values('"+fieldName.getText()+"','"+fieldPhone.getText()+"','"
                    +fieldIdentityNumber.getText()+"','"+fieldRoomNumber.getText()+"')";
            DashboardController.executeQuery(query);
            
            DashboardController.reloadTable();
            
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
