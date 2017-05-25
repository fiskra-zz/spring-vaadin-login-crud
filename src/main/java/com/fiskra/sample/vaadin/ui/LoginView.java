package com.fiskra.sample.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiskra.sample.vaadin.model.User;
import com.fiskra.sample.vaadin.repo.UserRepository;
import com.vaadin.data.Binder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class LoginView extends CustomComponent implements View{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final UserRepository userRepository;
	
	public User user;
	
	//private Navigator navigator;
	
	TextField userName = new TextField("username");
	TextField password = new TextField("password");
	Button login = new Button("Login");
	
	Binder<User> binder = new Binder<User>();
	
	
	@Autowired
	public LoginView(UserRepository userRepository) {
		this.userRepository = userRepository;
		//this.navigator =  getUI().getNavigator();
		
		// Create a panel with a caption.
		Panel loginPanel = new Panel("Login");
		loginPanel.setSizeUndefined();
		loginPanel.setWidth(null);
		
		// Create a layout inside the panel
		final FormLayout loginLayout = new FormLayout();
		// Add some components inside the layout
		loginLayout.addComponent(userName);
		loginLayout.addComponent(password);
		loginLayout.addComponent(login);
		
		setSizeUndefined();
		// Have some margin around it.
		loginLayout.setMargin(true);
		
		// set required indicator for text fields
		userName.setRequiredIndicatorVisible(true);
		password.setRequiredIndicatorVisible(true);
		
		
		// Set the layout as the root layout of the panel
		 
		loginPanel.setContent(loginLayout);
		
		setCompositionRoot(loginPanel);
		

		// login button onclick event implementation
		login.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				String userNameVal = userName.getValue();
				String passVal = password.getValue();
				User loggedUser = userRepository.findByUserNameAndPassword(userNameVal, passVal);
				System.out.println("-----" + loggedUser.getUserName() + loggedUser.getPassword()+ "-----");				
				getUI().getNavigator().navigateTo("crud");
				
			}
		});
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
