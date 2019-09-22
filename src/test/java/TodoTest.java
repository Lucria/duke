import controllers.ConsoleInputController;
import controllers.TaskFactory;
import exceptions.DukeException;
import models.tasks.ITask;
import models.tasks.ToDos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TodoTest {
    TaskFactory taskFactory = new TaskFactory();

    @Test
    public void alwaysTrue() {
        assertEquals(2, 2);
    }

    @Test
    public void creationValidToDo() {
        String input = "todo borrow book";
        ITask expectedTask;
        try {
            expectedTask = taskFactory.createTask(input);
            ITask dummyTask =  new ToDos("borrow book");
            assertEquals(expectedTask.getDescription(), dummyTask.getDescription());
            assertEquals(expectedTask.getInitials(), dummyTask.getInitials());
            assertEquals(expectedTask.getStatusIcon(), dummyTask.getStatusIcon());
            dummyTask.markAsDone();
            assertNotEquals(expectedTask.getStatusIcon(), dummyTask.getStatusIcon());
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void creationInvalidToDo() throws DukeException {
        String input = "todo";
        assertThrows(DukeException.class, () -> taskFactory.createTask(input));
    }
}
