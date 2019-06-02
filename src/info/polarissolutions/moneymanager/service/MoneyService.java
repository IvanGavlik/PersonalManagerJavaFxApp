package info.polarissolutions.moneymanager.service;

import java.util.Date;

import info.polarissolutions.moneymanager.model.Record;
import javafx.collections.ObservableList;

public interface MoneyService {
	
	ObservableList<Record> findAllRecords();

	void addRecrd(Date created, String descTxt, Double amount);

}
