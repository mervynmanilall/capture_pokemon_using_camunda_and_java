package com.example.java_capture_a_pokemon.data_classes;

public class ImportantTaskInfo{
        private String id;
        private String taskDefinitionKey;

    public ImportantTaskInfo(String receivedId, String receivedTaskDefinitionKey) {
        id = receivedId;
        taskDefinitionKey = receivedTaskDefinitionKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }
}
