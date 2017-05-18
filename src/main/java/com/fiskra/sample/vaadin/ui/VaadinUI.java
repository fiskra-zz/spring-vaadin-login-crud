package com.fiskra.sample.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class VaadinUI extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private final StudentRepository repo;
	
	//private final StudentEditor editor;
	
	private final LoginForm loginForm;
	
	//final Grid<Student> grid;

	//final TextField filter;

	//private final Button addNewBtn;

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		
	//	HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
	//	VerticalLayout left = new VerticalLayout(actions,grid);
		
		//HorizontalLayout mainLayout = new HorizontalLayout(left, editor);
		VerticalLayout mainLayout = new VerticalLayout(loginForm);
		mainLayout.setSizeFull();
		mainLayout.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
		
		setContent(mainLayout);

		/*grid.setHeight("600px");
		grid.setWidth("1000px");
		grid.setColumns("id", "firstName", "lastName", "phone", "eMail", "birthDate");

		filter.setPlaceholder("Filter by first or last name");*/

		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		//filter.setValueChangeMode(ValueChangeMode.LAZY);
		//filter.addValueChangeListener(e -> listStudents(e.getValue()));

		// Connect selected Student to editor or hide if none is selected
		/*grid.asSingleSelect().addValueChangeListener(e -> {
			editor.editStudent(e.getValue());
		});*/

		// Instantiate and edit new Student the new button is clicked
		//addNewBtn.addClickListener(e -> editor.editStudent(new Student()));

		// Listen changes made by the editor, refresh data from backend
		/*editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listStudents(filter.getValue());
		});*/

		// Initialize listing
		//listStudents(null);
	}
	
	@Autowired
	public VaadinUI(LoginForm loginForm) {
	//	this.repo = repo;
		this.loginForm = loginForm;
	//	this.editor = editor;
	//	this.grid = new Grid<>(Student.class);
		//this.filter = new TextField();
		//this.addNewBtn = new Button("New Student", FontAwesome.PLUS);
		//addNewBtn.setWidth("100%");
	}

	/*private void listStudents(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
	        grid.setItems(repo.findAll());
		}else{
			if(repo.findByLastNameStartsWithIgnoreCase(filterText) != null)
				grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
			else
				grid.setItems(repo.findByFirstNameStartsWithIgnoreCase(filterText));
				
			
		}
	}*/
}
