package game;


import lombok.extern.slf4j.Slf4j;
import model.*;
import simulator.SquareTable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


@Slf4j
public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        log.info("Game starts, get commands from file : " + fileName);

        SquareTable table = new SquareTable();

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            PlaceCommandDetector detector = new PlaceCommandDetector();
            lines.forEach(line -> {

                if(detector.isPlaceCommand(line)){
                    int[] placePosition = detector.parsePlacePosition(line);
                    table.placeRobot(placePosition[0],placePosition[1],detector.parsePlaceDirection(line));
                    return;
                }

                Command command = Command.parse(line);
                table.feedCommandToRobot(command);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
