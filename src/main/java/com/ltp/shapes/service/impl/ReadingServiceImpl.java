package com.ltp.shapes.service.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.service.ReadingService;
import com.ltp.shapes.validator.ShapeValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadingServiceImpl implements ReadingService {

    private static final Logger LOGGER = LogManager.getLogger(ReadingServiceImpl.class);
    private static ReadingServiceImpl instance;

    public static ReadingServiceImpl getInstance(){
        if(instance == null){
            instance = new ReadingServiceImpl();
        }

        return instance;
    }

    @Override
    public String read(String filename) throws ShapeException {
        if(!ShapeValidator.validateFile(filename)){
            LOGGER.log(Level.ERROR, String.format("Unable to open file '%s'", filename));
            throw new ShapeException("No input file found");
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));

            String result = null, current;
            Iterator<String> lineIterator = lines.iterator();

            while(lineIterator.hasNext()){
                current = lineIterator.next();

                if(ShapeValidator.validateLine(current)){
                    result = current;
                    break;
                }
            }

            if(result != null) return result;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Error while reading data");
        }

        throw new ShapeException("No valid line found");
    }
}
