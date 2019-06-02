package info.polarissolutions.moneymanager.database;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import info.polarissolutions.moneymanager.model.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FileDB {
	
	private static final String filepath="/home/ivgavlik/Desktop/db";
	 
	public static void saveRecordsToFile(ObservableList<Record> records) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			for(Record rec : records) {
				objectOut.writeObject(rec);
			}
			
			objectOut.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static ObservableList<Record> fetchRecords() {
		ObservableList<Record> list = FXCollections.observableArrayList();
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		try {
			fi = new FileInputStream(filepath);
			oi = new ObjectInputStream(fi);
			Object obj = oi.readObject();
			
			while(true) {
				list.add((Record) obj);
				obj = oi.readObject();
			}
			
		} catch (EOFException ex) {
		} catch (Exception ex) {
			ex.printStackTrace();
		}  finally {
			try { 
				if(oi != null)
					oi.close(); 
			}
			catch (Exception e) { e.printStackTrace(); }
		}
		return list;
	}
	
}
