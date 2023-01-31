package com.example.recipeapp.services.impl;

import com.example.recipeapp.services.FilesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceImpl implements FilesService {
    @Value("${path.to.data.file}")
    private String dataFilePath;
    @Value("${name.of.data.file}")
    private String ingredientDataFileName;
    @Value("${name.of.data.file1}")
    private String recipeDataFileName;

    @Override
    public boolean saveToFile(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, ingredientDataFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromFile() {
        try {
            Path path = Path.of(dataFilePath, ingredientDataFileName);
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getIngredientDataFile() {
        return new File(dataFilePath + "/" + ingredientDataFileName);
    }



    @Override
    public File getRecipeDataFile() {
        return new File(dataFilePath + "/" + recipeDataFileName);
    }

    @Override
    public boolean cleanDataFile() {
        try {
            Path path = Path.of(dataFilePath, ingredientDataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean saveToFileRecipe(String json) {
        try {
            cleanDataFileRecipe();
            Files.writeString(Path.of(dataFilePath, recipeDataFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromFileRecipe() {
        try {
            return Files.readString(Path.of(dataFilePath, recipeDataFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanDataFileRecipe() {
        try {
            Path path = Path.of(dataFilePath, recipeDataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Path createTempFile(String suffix) {
        try {
            return Files.createTempFile(Path.of(dataFilePath), "tempFile", suffix);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

