package info.polarissolutions.moneymanager.service;

import java.util.Date;

import info.polarissolutions.moneymanager.database.FileDB;
import info.polarissolutions.moneymanager.model.Record;
import javafx.collections.ObservableList;

public class MoneyServiceImpl implements MoneyService {

	private ObservableList<Record> records;
	

	public MoneyServiceImpl() {
		records = FileDB.fetchRecords();
	}
	
	@Override
	public ObservableList<Record> findAllRecords() {
		return records;
	}

	@Override
	public void addRecrd(Date created, String descTxt, Double amount) {
		records.add(new Record(created, descTxt, amount));
		FileDB.saveRecordsToFile(records);
	}

}
