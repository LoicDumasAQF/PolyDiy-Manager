package common.facade;

import logic.ModifyAccountHandler;


/**
 * This class contains all functions to modify account
 * 
 * @author Faustine GEOFFRAY
 * @version 1.0
 * @since 2016-21-03
 */

public class FacadeModifyAccount {
	public FacadeModifyAccount(){	
	}
	
	//fonction updateAccount
	public void updateAccount(int accountID, String updateLogin, String updatefirstName, String updatelastName) throws Exception {
		ModifyAccountHandler handler = new ModifyAccountHandler();
		handler.update(accountID, updateLogin, updatefirstName, updatelastName);
	}

	public String getLogin(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String login = handler.getLogin(ID);
		return login;
	}
	
	
}
