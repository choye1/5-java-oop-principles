package com.example.task04;

import com.example.task04.Levels;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;



public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();

    private Levels level;
    private final String name;


    public Logger(String name) {
        this.name = name;
        this.level = Levels.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, Levels level) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
    }

    public String getName(){
      return name;
    }

    public Levels getLevel(){
        return level;
    }

    public void setLevel(Levels level){
        this.level = level;
    }

    public void log(String message) {
        System.out.println(this.name + ": " + message);
    }

    public static Logger getLogger(String name){

        if(loggers.get(name) == null){
            loggers.put(name,new Logger(name));
        }
        return loggers.get(name);
    }


    public void log(Levels level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String printMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, name, message);
            System.out.println(printMessage);
        }
    }

    public void log(Levels level, String format, Object... objects) {
        if (this.level.ordinal() <= level.ordinal()){
            System.out.println(MessageFormat.format(format, objects));
        }
    }


    public void debug(String message){
        this.log(Levels.DEBUG, message);
    }

    public void debug(String format, Object... args){
        this.log(Levels.DEBUG, format, args);
    }

    public void info(String message){
        this.log(Levels.INFO, message);

    }

    public void info(String format, Object... args){
        this.log(Levels.INFO, format, args);
    }

    public void warning(String message){
        this.log(Levels.WARNING, message);
    }

    public void warning(String format, Object... args){
        this.log(Levels.WARNING, format, args);

    }

    public void error(String message){
        this.log(Levels.ERROR, message);
    }

    public void error(String format, Object... args){
        this.log(Levels.ERROR, format, args);
    }



}
