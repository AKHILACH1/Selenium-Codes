package com.obsqura.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name="NewDeliveryBoyRecord")
	public Object[][] getDataFromDataprovider(){
		return new Object[][]
		{
			{"John Samuel","john123@gmail.com","556485226"},
			{"John ","jo123@gmail.com","556485226"},
			{"Samuel","Samuel@gmail.com","556485226"}
		};
	}

}
