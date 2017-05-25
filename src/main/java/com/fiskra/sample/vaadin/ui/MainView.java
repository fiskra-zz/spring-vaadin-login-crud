package com.fiskra.sample.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.fiskra.sample.vaadin.model.Student;
import com.fiskra.sample.vaadin.repo.StudentRepository;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class MainView extends CustomComponent implements  View {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final StudentEditor editor;
	
	final Grid<Student> grid;

	final TextField filter;

	private final Button addNewBtn;
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public MainView(StudentRepository studentRepository, StudentEditor editor) {
		this.studentRepository = studentRepository;
		this.editor = editor;
		this.grid = new Grid<>(Student.class);
		this.filter = new TextField();
		this.addNewBtn = new Button("New student", FontAwesome.PLUS);
		
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
				
		
		
	    grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "firstName", "lastName");

		filter.setPlaceholder("Filter by last name");

		setCompositionRoot(mainLayout);
		
		// Connect selected Customer to editor or hide if none is selected
				grid.asSingleSelect().addValueChangeListener(e -> {
					editor.editStudent(e.getValue());
				});

				// Instantiate and edit new Customer the new button is clicked
				addNewBtn.addClickListener(e -> editor.editStudent(new Student("", "","","",null)));

				// Listen changes made by the editor, refresh data from backend
				editor.setChangeHandler(() -> {
					editor.setVisible(false);
					listStudents(filter.getValue());
				});

				// Initialize listing
				listStudents(null);
				
	}
	
	private void listStudents(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(studentRepository.findAll());
		}
		else {
			grid.setItems(studentRepository.findByLastNameStartsWithIgnoreCase(filterText));
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
