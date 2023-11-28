package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entity.Task;

import java.util.List;


@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @GET
    public List<Task> getAllTasks() {
        return Task.listAll();
    }

    @POST
    @Transactional
    public void addTask(String taskName) {
        Task task = new Task();
        task.name= taskName;
        task.persist();
    }
}