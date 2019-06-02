package info.polarissolutions.moneymanager.money;

import java.util.Date;

import info.polarissolutions.moneymanager.model.Record;
import info.polarissolutions.moneymanager.scene.MoneyManagerView;
import info.polarissolutions.moneymanager.service.MoneyService;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MoneyView implements MoneyManagerView {
	
	private MoneyService moneyService;
	private VBox vBox;
	
	public MoneyView(MoneyService ms) {
		moneyService = ms;
		vBox = new VBox();
		vBox.setSpacing(10);
		
		TableView<Record> table = new TableView<>();
		
		TableColumn<Record, Date> createdColumn= new TableColumn<>("Date");
		createdColumn.setMinWidth(220);
		createdColumn.setCellValueFactory(new PropertyValueFactory<Record, Date>("created"));
		
		TableColumn<Record, Date> descColumn= new TableColumn<>("Description");
		descColumn.setMinWidth(320);
		descColumn.setCellValueFactory(new PropertyValueFactory<Record, Date>("desc"));
		
		TableColumn<Record, Date> amountColumn= new TableColumn<>("Amount");
		amountColumn.setMinWidth(50);
		amountColumn.setCellValueFactory(new PropertyValueFactory<Record, Date>("amount"));
		
		table.getColumns().addAll(createdColumn, descColumn, amountColumn);
		table.getItems().setAll(moneyService.findAllRecords());
		
		HBox hBox1 = new HBox();
		String sum = String.valueOf(moneyService.findAllRecords().stream().mapToDouble( el -> el.getAmount()).sum());
		Label sumLabel = new Label("SUM: "+ sum);
		Separator s = new Separator();
		hBox1.getChildren().addAll(sumLabel, s);
		
		
		HBox hBox2 = new HBox();
		TextField desc = new TextField();
		desc.setPromptText("insert description");
		TextField amunt = new TextField();
		amunt.setPromptText("insert amount");

		hBox2.getChildren().addAll(desc, amunt);
		
		Button add = new Button("Add");
		add.setOnAction(el -> {
			String descTxt = desc.getText();
			if(validateNewRecord(descTxt, amunt.getText())) {
				moneyService.addRecrd(new Date() ,descTxt, Double.valueOf(amunt.getText()));
				table.getItems().setAll(moneyService.findAllRecords());
				sumLabel.setText("SUM: "+ String.valueOf(moneyService.findAllRecords().stream().mapToDouble( e -> e.getAmount()).sum()));
			} 
			desc.setText("");
			amunt.setText("");
	
		});
		
		
		vBox.getChildren().addAll(table, hBox1, hBox2, add);
	}
	
	private boolean validateNewRecord(String descTxt, String amount) {
		
		if (descTxt == null || descTxt.isEmpty()) {
			return false;
		}

		try {
			Double.valueOf(amount);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	@Override
	public Parent getView() {
		return vBox;
	}

}
