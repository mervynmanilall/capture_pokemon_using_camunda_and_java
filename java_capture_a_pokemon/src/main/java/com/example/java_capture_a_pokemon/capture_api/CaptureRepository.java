package com.example.java_capture_a_pokemon.capture_api;

import com.example.java_capture_a_pokemon.data_classes.ImportantTaskInfo;
import com.example.java_capture_a_pokemon.data_classes.TaskDetailDataClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;

@Component
public class CaptureRepository {
    static ImportantTaskInfo getTaskInfo(String executionIdVariable) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("http://localhost:8081/engine-rest/task")
                ).header("Content-type", "application/json")
                .GET()
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type collectionType = new TypeToken<Collection<TaskDetailDataClass>>(){}.getType();
        List<TaskDetailDataClass> obj = new Gson().fromJson(response.body(), collectionType);

//        TaskDetailDataClass[] obj = new Gson().fromJson(response.body(), TaskDetailDataClass[].class);
//        System.out.println(obj);

        ImportantTaskInfo tDeail = obj.stream().
                filter(taskDetail -> taskDetail.getExecutionId().equals(executionIdVariable))
                .map(thetaskDetail -> new ImportantTaskInfo(thetaskDetail.getId(), thetaskDetail.getTaskDefinitionKey()))
                .findFirst().orElse(null);

        return tDeail;
    }
}
