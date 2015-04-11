package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/*
 class  "CachingResultSetTableModel" is a convenience class for easy viewing of SQL-results in a JTable-component
 An instance goes as argument when constructing the JTable
 */
public class CachingResultSetTableModel extends AbstractTableModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Object[]> cache = null; // to cache all datarows
	private String[] colnames = null; // to cache the coloumnnames
	private int colcnt = 0;

	public CachingResultSetTableModel() {
	}

	public CachingResultSetTableModel(ResultSet rs) {
		// this.rs = rs;
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			colcnt = rsmd.getColumnCount();
			colnames = new String[colcnt];
			for (int i = 0; i < colcnt; i++) { // caching loop for all
												// coloumnnames
				colnames[i] = rsmd.getColumnName(i + 1);
			}
			cache = new ArrayList<Object[]>();
			while (rs.next()) { // caching loop for all datarows
				Object[] row = new Object[colcnt];
				for (int j = 0; j < row.length; j++)
					row[j] = rs.getObject(j + 1); // combining the row
				cache.add(row);
			}
		} catch (SQLException e) {
			System.out.println("CachingResultSetTableModel Error " + e);
		}
	}

	// **********************************************************
	// Oppfyller resten av kontrakten for interface TableModel.
	// AbstractTableModels har allerede oppfylt de andre.
	// ----------------------------------------------------------

	public int getRowCount() {
		return cache.size();
	}

	public int getColumnCount() {
		return colcnt;
	}

	public Object getValueAt(int r, int c) {
		if (r < cache.size()) {
			return ((Object[]) cache.get(r))[c];
		} else {
			return null;
		}
	}

	// --------------------------------
	// Ferdig med kontrakten.
	// ********************************

	// **********************************************************************************
	// Overstyrer AbstractTableModel::getColumnName for å forenkle henting av
	// kolonnenavn
	// ----------------------------------------------------------------------------------

	public String getColumnName(int c) {
		return colnames[c];
	}

	public ArrayList<Object[]> getCache() {
		return cache;
	}

	public void setCache(ArrayList<Object[]> cache) {
		this.cache = cache;
	}

	public int getColcnt() {
		return colcnt;
	}

	public void setColcnt(int colcnt) {
		this.colcnt = colcnt;
	}

	public String[] getColnames() {
		return colnames;
	}

	public void setColnames(String[] colnames) {
		this.colnames = colnames;
	}

	// ----------------------------------------------------------------------------------
	// **********************************************************************************

}
