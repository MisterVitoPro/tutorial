package com.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by MisterVitoPro on 1/14/2016.
 */
public class MyTestResults {

    int passed;
    int failed;
    int skipped;

    public int getPassed(){
        return this.passed;
    }

    public int getFailed(){
        return this.failed;
    }

    public int getSkipped(){
        return this.skipped;
    }

    public int getTotalTests(){
        return (this.passed + this.failed + this.skipped);
    }

    public void incrementPassed(){
        this.passed++;
    }

    public void incrementFailed(){
        this.failed++;
    }

    public void incrementSkipped(){
        this.skipped++;
    }

    public void write() throws IOException {
        File file = new File("myTestResults.txt");

        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(fw)) {
            bWriter.write("PASSED="+this.passed+"\n");
            bWriter.write("FAILED="+this.failed+"\n");
            bWriter.write("SKIPPED="+this.skipped+"\n");
            bWriter.write("TOTAL="+this.getTotalTests()+"\n");
        }
    }

    public void writeToCSV() throws IOException {
        File file = new File("myTestResults.csv");
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(fw)) {
            bWriter.write("PASSED,"+this.passed+"\n");
            bWriter.write("FAILED,"+this.failed+"\n");
            bWriter.write("SKIPPED,"+this.skipped+"\n");
            bWriter.write("TOTAL,"+this.getTotalTests()+"\n");
        }
    }
}
