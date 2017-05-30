package com.fiskra.sample.vaadin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fiskra.sample.vaadin.model.Student;
import com.fiskra.sample.vaadin.repo.StudentRepository;
import com.fiskra.sample.vaadin.ui.StudentEditor;
import static org.mockito.BDDMockito.*;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

@RunWith(MockitoJUnitRunner.class)
public class StudentEditorTest {

	private static final String FIRST_NAME = "fiskra";
	private static final String LAST_NAME = "lastFiskra";
	private static final String PHONE = "99";
	private static final String EMAIL = "fiskra@";

	@Mock
	StudentRepository studentRepository;
	@InjectMocks
	StudentEditor editor;

	@Test
	public void shouldStoreStudentInRepoWhenEditorSaveClicked() {
		this.editor.firstName.setValue(FIRST_NAME);
		this.editor.lastName.setValue(LAST_NAME);
		studentDataWasFilled();

		this.editor.save.click();

		then(this.studentRepository).should().save(argThat(studentMatchesEditorFields()));
	}

	private void studentDataWasFilled() {
		this.editor.editStudent(new Student(FIRST_NAME, LAST_NAME, PHONE, EMAIL, null));
	}

	private TypeSafeMatcher<Student> studentMatchesEditorFields() {
		return new TypeSafeMatcher<Student>() {
			@Override
			public void describeTo(Description description) {
			}

			@Override
			protected boolean matchesSafely(Student item) {
				return FIRST_NAME.equals(item.getFirstName()) && LAST_NAME.equals(item.getLastName());
			}
		};
	}

}
