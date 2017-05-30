package com.fiskra.sample.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiskra.sample.vaadin.repo.StudentRepository;
import com.fiskra.sample.vaadin.repo.UserRepository;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@SpringViewDisplay
public class VaadinUI extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private final UserRepository repo;
	
	@Autowired
	private final StudentRepository studentRepository;
	
	private Navigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		
		VerticalLayout mainLayout = new VerticalLayout();
		
		LoginView loginView = new LoginView(repo);
		
		mainLayout.addComponent(loginView);
		
		mainLayout.setSizeFull();
		
		mainLayout.setComponentAlignment(loginView, Alignment.MIDDLE_CENTER);
		
		setContent(mainLayout);
		
		StudentEditor studentEditor = new StudentEditor(studentRepository);
		
		MainView mainView = new MainView(studentRepository, studentEditor);
		
		// build navigator
		navigator = new Navigator(this, mainLayout);
		
		navigator.addView(loginView.VIEW_NAME, loginView);
		navigator.addView(mainView.VIEW_NAME, mainView);
		navigator.navigateTo(loginView.VIEW_NAME);
		
	}
	
	@Autowired
	public VaadinUI(UserRepository repo, StudentRepository studentRepository) {
		this.repo = repo;
		this.studentRepository = studentRepository;
		 
	}
}
