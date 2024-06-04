package com.esde.rectangles.util;

import com.esde.rectangles.exeption.InvalidRectangleDataException;
import com.esde.rectangles.validator.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.esde.rectangles.constant.RectangleConstant.DELIMITER;

public class TxtParser {

        private static final Logger logger = LogManager.getLogger();
        public TxtParser(){
        }
        public static List<Double[]> parseRectanglesTxt(String file) throws InvalidRectangleDataException {
            InputValidator inputValidator = new InputValidator();
            List<Double[]> parsedData = new ArrayList<>();
            try (Stream<String> lines = Files.lines(Paths.get(Objects.requireNonNull(TxtParser.class.getResource(file)).toURI()))) {// todo think to todo
                lines.forEach(line -> {
                    String[] rectangleData = line.split(DELIMITER);
                    if (inputValidator.hasEightParameters(rectangleData)) {
                        Double [] rectangle = inputValidator.validParams(rectangleData);
                        if (rectangle !=null){
                            parsedData.add(rectangle );
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

