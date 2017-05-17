package com.fiskra.sample.vaadin.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiskra.sample.vaadin.model.Student;
import com.fiskra.sample.vaadin.repo.StudentRepository;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class StudentEditor extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final StudentRepository studentRepository;
	
	public Student student;
	
	/* Fields to edit properties in Student entity */
	TextField firstName = new TextField("First name");
	TextField lastName = new TextField("Last name");
	TextField phone = new TextField("Phone");
	TextField eMail = new TextField("E mail");
	//DateField birthDate = new DateField("Birth date");
	
	/* Action buttons */
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);

	Binder<Student> binder = new Binder<>(Student.class);
	
	//private static class StockPriceConverter extends SqlDateLocaleConverter
	
	@Autowired
	public StudentEditor(StudentRepository repository) {
		this.studentRepository = repository;
		addComponents(firstName, lastName, phone, eMail, actions);
		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> repository.save(student));
		delete.addClickListener(e -> repository.delete(student));
		cancel.addClickListener(e -> editStudent(student));
		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editStudent(Student s) {
		if (s == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = s.getId() != null;
		if (persisted) {
			// Find fresh entity for editing
			student = studentRepository.findOne(s.getId());
		}
		else {
			student = s;
		}
		cancel.setVisible(persisted);

		// Bind customer properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(student);

		setVisible(true);

		// A hack to ensure the whole form is visible
		save.focus();
		// Select all text in firstName field automatically
		firstName.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
