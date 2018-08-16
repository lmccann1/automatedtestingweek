package com.qa.cucumberpractice.cucumberpractice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googleHome {

	@FindBy(id = "lst-ib")
	private WebElement searchBox;
	
	//@FindBy(id = )
		
	
	public void sendKeysToSearch(String textToSearch) {
		searchBox.sendKeys(textToSearch);
		searchBox.submit();
	}

}
