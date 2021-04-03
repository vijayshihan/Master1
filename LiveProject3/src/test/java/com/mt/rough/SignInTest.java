package com.mt.rough;

import com.mt.base.Page;
import com.mt.pages.actions.SigninPage;

public class SignInTest {

	
	public static void main(String[] args) {
		
		Page.initConfiguration();
		SigninPage signin = Page.topNav.gotoSignIn();
		signin.doLogin("abcdef@gmail.com", "1233432");
		Page.quitBrowser();
		
	}
}
