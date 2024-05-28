package co.develhope.CrudTest;

import co.develhope.CrudTest.entities.Student;
import co.develhope.CrudTest.repositories.StudentRepository;
import co.develhope.CrudTest.services.StudentService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class StudentControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentService studentService;

	private Student student;

	@BeforeEach
	public void setup() {
		studentRepository.deleteAll();
		student = new Student();
		student.setName("Marco");
		student.setSurname("Rossi");
		student.setCodiceFiscale("A1");
		student.setIsWorking(false);
		studentRepository.save(student);
	}

	@Test
	public void testGetAllStudents() throws Exception {
		mvc.perform(get("/students")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("Marco"))
				.andExpect(jsonPath("$[0].surname").value("Rossi"))
				.andExpect(jsonPath("$[0].codiceFiscale").value("A1"))
				.andExpect(jsonPath("$[0].isWorking").value(false));
	}

	@Test
	public void testCreateStudent() throws Exception {
		String newStudentJson = "{\"name\":\"Marco\",\"surname\":\"Rossi\",\"codiceFiscale\":\"B2\",\"isWorking\":true}";

		mvc.perform(post("/students")
						.contentType(MediaType.APPLICATION_JSON)
						.content(newStudentJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Marco"))
				.andExpect(jsonPath("$.surname").value("Rossi"))
				.andExpect(jsonPath("$.codiceFiscale").value("B2"))
				.andExpect(jsonPath("$.isWorking").value(true));
	}
	@Test
	public void testPostStudentIllegalArgumentEx() {
		Student existingStudent = new Student();
		existingStudent.setName("Nome");
		existingStudent.setSurname("Cognome");
		existingStudent.setCodiceFiscale("D1");
		existingStudent.setIsWorking(true);

		studentRepository.save(existingStudent);

		Student newStudent = new Student();
		newStudent.setCodiceFiscale("D1");

		try {
			studentService.postStudent(newStudent);
		} catch (IllegalArgumentException ignored) {

		}
	}


		@Test
	public void testGetStudentById() throws Exception {
		mvc.perform(get("/students/" + student.getId())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Marco"))
				.andExpect(jsonPath("$.surname").value("Rossi"))
				.andExpect(jsonPath("$.codiceFiscale").value("A1"))
				.andExpect(jsonPath("$.isWorking").value(false));
	}

	@Test
	public void testUpdateStudent() throws Exception {
		String updatedStudentJson = "{\"name\":\"Giulio\",\"surname\":\"Bianchi\",\"codiceFiscale\":\"C3\",\"isWorking\":false}";

		mvc.perform(put("/students/" + student.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(updatedStudentJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Giulio"))
				.andExpect(jsonPath("$.surname").value("Bianchi"))
				.andExpect(jsonPath("$.codiceFiscale").value("C3"))
				.andExpect(jsonPath("$.isWorking").value(false));
	}

	@Test
	public void testUpdateIsWorking() throws Exception {
		mvc.perform(put("/students/" + student.getId() + "/is-working")
						.param("isWorking", "true")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.isWorking").value(true));
	}

	@Test
	public void testDeleteStudent() throws Exception {
		mvc.perform(delete("/students/" + student.getId())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("Student deleted"));
	}
}
