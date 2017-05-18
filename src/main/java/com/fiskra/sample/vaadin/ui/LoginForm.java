package com.fiskra.sample.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiskra.sample.vaadin.model.User;
import com.fiskra.sample.vaadin.repo.UserRepository;
import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
@SpringComponent
@UIScope
public class LoginForm extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final UserRepository userRepository;
	
	public User user;
	
	TextField userName = new TextField("username");
	TextField password = new TextField("password");
	Button login = new Button("Login");

	Binder<User> binder = new Binder<User>();
	
	@Autowired
	public LoginForm(UserRepository userRepository) {
		this.userRepository = userRepository;
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
		
		// Have some margin around it.
		loginLayout.setMargin(true);
		
		// set required indicator for text fields
		userName.setRequiredIndicatorVisible(true);
		password.setRequiredIndicatorVisible(true);
		
		
		// Set the layout as the root layout of the panel
		loginPanel.setContent(loginLayout);
		addComponents(loginPanel);
		
		
		// Set the position of login panel
		setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);

		// login button onclick event implementation
		login.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				String userNameVal = userName.getValue();
				String passVal = password.getValue();
				User loggedUser = userRepository.findByUserNameAndPassword(userNameVal, passVal);
				System.out.println("-----" + loggedUser.getUserName() + loggedUser.getPassword()+ "-----");
				
				
			}
		});
	}
}
