package com.dummy.myerp.consumer.db.helper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class ResultSetHelperTest {
	
	private ResultSet rsMock;
	private String colName = "test";
	
	
	@Before
	public void setUp() {
		rsMock = Mockito.mock(ResultSet.class);
	}
	
	
	@Test
	public void getInteger() throws SQLException {
		Integer i = 22;
		
		Mockito.when(rsMock.getInt(colName)).thenReturn(i);
		
		
		Assert.assertEquals(i, ResultSetHelper.getInteger(rsMock, colName));
	}
	
	
	@Test
	public void getLong() throws SQLException {
		Long l = (long) 37;
		
		Mockito.when(rsMock.getLong(colName)).thenReturn(l);
		
		
		Assert.assertEquals(l, ResultSetHelper.getLong(rsMock, colName));
	}
	
	
	@Test
	public void getDate() throws SQLException {
		Date date = new Date(0);
		
		Mockito.when(rsMock.getDate(colName)).thenReturn(date);
		
		
		Assert.assertEquals(date, ResultSetHelper.getDate(rsMock, colName));
	}
	
}
