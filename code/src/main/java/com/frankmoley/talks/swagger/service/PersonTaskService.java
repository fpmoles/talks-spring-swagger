package com.frankmoley.talks.swagger.service;

import com.frankmoley.talks.swagger.data.PersonEntity;
import com.frankmoley.talks.swagger.data.PersonRepository;
import com.frankmoley.talks.swagger.data.TaskEntity;
import com.frankmoley.talks.swagger.data.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Frank P. Moley III.
 */
@Service
public class PersonTaskService {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;

    @Autowired
    public PersonTaskService(PersonRepository personRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }

    public Map<Long, String> getPersonMap(){
        Map<Long, String> resultMap = new HashMap<>();
        Iterable<PersonEntity> people = this.personRepository.findAll();
        people.forEach(person->{
            resultMap.put(person.getId(), person.getEmailAddress());
        });
        return resultMap;
    }

    public PersonalTasks addPerson(Person person){
        PersonEntity entity = new PersonEntity();
        entity.setEmailAddress(person.getEmailAddress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity = this.personRepository.save(entity);
        return this.getPersonalTasks(entity.getId());
    }

    public PersonalTasks getPersonalTasks(long personId){
        PersonEntity personEntity = this.personRepository.findOne(personId);
        if(null==personEntity){
            return null;
        }
        PersonalTasks personalTasks = new PersonalTasks();
        personalTasks.setEmailAddress(personEntity.getEmailAddress());
        personalTasks.setFirstName(personEntity.getFirstName());
        personalTasks.setPersonId(personEntity.getId());
        personalTasks.setLastName(personEntity.getLastName());
        List<TaskEntity> taskEntities = this.taskRepository.findByPersonId(personId);
        if(null!=taskEntities){
            List<Task> tasks = new ArrayList<>(taskEntities.size());
            taskEntities.forEach(taskEntity -> {
                Task task = new Task();
                task.setId(taskEntity.getId());
                task.setTask(taskEntity.getTask());
                task.setCompleted(taskEntity.isCompleted());
                tasks.add(task);
            });
            personalTasks.setTasks(tasks);
        }
        return personalTasks;
    }
}
