package java.come.esde.Cube.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.come.esde.Cube.exeption.InvalidRectangleDataException;
import java.come.esde.Cube.validator.InputValidator;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TxtParser {

        private static final Logger logger = LogManager.getLogger();

        private static final String DELIMITER = ",";

        public TxtParser(){
        }

        public static List<Double[]> parseCubesTxt(String file) throws InvalidRectangleDataException {
            InputValidator inputValidator = new InputValidator();
            List<Double[]> parsedData = new ArrayList<>();
            try (Stream<String> lines = Files.lines(Paths.get(TxtParser.class.getResource(file).toURI()))) {// todo think to todo
                lines.forEach(line -> {
                    String[] cubeData = line.split(DELIMITER);
                    if (inputValidator.hasEightParameters(cubeData)) {
                        Double [] cube = inputValidator.validParams(cubeData);
                        if (cube!=null){
                            parsedData.add(cube);
                        }
                    } else {
                        logger.warn("invalid format line:" + line);
                    }
                });
            } catch (IOException | URISyntaxException | NullPointerException e) {
                logger.error(e);
                throw new InvalidRectangleDataException("Error creating with reader", e);
            }
            return parsedData;
        }
    }

