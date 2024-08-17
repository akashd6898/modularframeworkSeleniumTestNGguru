package com.guru99.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreeshotUtils {

    private TakesScreenshot camera;

    public ScreeshotUtils(WebDriver driver) {
        camera = (TakesScreenshot) driver; /* TakesScreenshot implements WebDriver class, hence driver object is casting interface so that it can be used with Takesscreenshot methods/variable.*/
    }
        public void captureAndSaveScreenshot(String filename) throws Exception
        {
            filename = filename.trim();
            File imgFile, tmpFile;
            imgFile = new File(filename);

            if(imgFile.exists())
            {
                throw new Exception("File already exists");
            }

            tmpFile = camera.getScreenshotAs(OutputType.FILE);

            FileUtils.moveFile(tmpFile, imgFile);
    }
}
