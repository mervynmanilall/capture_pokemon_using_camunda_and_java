package com.example.java_capture_a_pokemon.capture_api;

import com.example.java_capture_a_pokemon.data_classes.CreateTaskDataClass;
import com.example.java_capture_a_pokemon.data_classes.ImportantTaskInfo;
import com.example.java_capture_a_pokemon.data_classes.TaskDetailDataClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;

import static com.example.java_capture_a_pokemon.capture_api.CaptureRepository.getTaskInfo;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/trainer-action")
@Component
public class CaptureController {
    @PostMapping("/start")
//    https://www.baeldung.com/kotlin/fuel#:~:text=In%20this%20tutorial%2C%20we'll,POST%2C%20DELETE%2C%20etc.)
    static CreateTaskDataClass initiateSearch() throws IOException, InterruptedException {

        var message = """
                {}
                """;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                URI.create("http://localhost:8081/engine-rest/process-definition/key/pokemon_capture_rules/start")
        ).header("Content-type", "application/json")
         .POST(HttpRequest.BodyPublishers.ofString(message))
         .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        CreateTaskDataClass obj = new Gson().fromJson(response.body(), CreateTaskDataClass.class);

        return obj;
    }

    @GetMapping("/getTaskId/{executionIdVariable}")
    static ImportantTaskInfo getTaskId(@PathVariable String executionIdVariable) throws IOException, InterruptedException {

        ImportantTaskInfo taskInfo = getTaskInfo(executionIdVariable);

        return taskInfo;

    }

    @PostMapping("/complete/{executionIdVariable}")
    static String CompleteTask(@PathVariable String executionIdVariable) throws IOException, InterruptedException {
        ImportantTaskInfo taskInfo = getTaskInfo(executionIdVariable);
        String taskId = taskInfo.getId();
        String currentStage = taskInfo.getTaskDefinitionKey();

        System.out.println("taskId"+taskId);
        System.out.println("currentStage"+currentStage);

        var message = """
                {}
                """;

        if (currentStage.equals("initiate_battle")) {
            message = """
                {
                    "variables": {
                        "isTired": {
                            "value": true
                        }
                    }
                }
                """;
        }

        System.out.println("message"+message);

        String completeTaskUrl = "http://localhost:8081/engine-rest/task/"+taskId+"/complete";
        System.out.println("completeTaskUrl"+completeTaskUrl);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(completeTaskUrl)
                ).header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String messageToDisplay = "";

        if (currentStage.equals("initiate_battle")){
            if (message.contains("true") && response.statusCode() == 204) {
                messageToDisplay = "You have succeeded champion";
            } else {
                messageToDisplay = "You are still a champion but need to try again";
            }
        } else {
            messageToDisplay = "You have succeeded champion";
        }

        return messageToDisplay;

    }

}
