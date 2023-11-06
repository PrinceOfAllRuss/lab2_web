package com.main.lab2_2.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Validator {
    public boolean inputDataCheck(String x, String y, String r, String event) throws JsonProcessingException {
        if (event.equals("submitForm")) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Double.parseDouble(x);
                objectMapper.readValue(y, double[].class);
                Double.parseDouble(r);
            } catch (NumberFormatException | JsonProcessingException e) {
                return false;
            }
            double numberX = Double.parseDouble(x);
            double[] numberY = objectMapper.readValue(y, double[].class);
            double numberR = Double.parseDouble(r);

            if (Math.abs(numberX) > 5 || numberR < 0 || numberR > 3) {
                return false;
            } else {
                for (double elY : numberY) {
                    if (Math.abs(elY) > 2) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    public void checkPointInArea(ElementForTable element) {

        double numberX = Double.parseDouble(element.x);
        double numberY = Double.parseDouble(element.y);
        double numberR = Double.parseDouble(element.r);

        if (numberX == 0 && numberY == 0) {
            element.condition = true;
        }
        //первая четверть
        else if (numberX >= 0 && numberY >= 0) {
            //проверка на точку на оси Y
            if (numberX == 0) {
                if (numberY <= numberR) {
                    element.condition = true;
                }
            //проверка на точку на оси X
            } else if (numberY == 0) {
                if (numberX <= numberR / 2) {
                    element.condition = true;
                }
            //проверка на точку в треугольнике
            } else if (numberX <= numberR / 2 && numberY <= numberR / 2) {
                if (numberY / (numberX - numberR / 2) >= -1) {
                    element.condition = true;
                }
            }
        }
        //вторая четверть
        else if (numberX <= 0 && numberY >= 0) {
            if (numberY <= numberR && numberX >= -numberR / 2) {
                element.condition = true;
            }
        }
        //третья четверть
        else if (numberX <= 0 && numberY <= 0) {
            if (Math.abs(numberX) <= numberR && Math.abs(numberY) <= numberR) {
                if (Math.pow(numberX, 2) + Math.pow(numberY, 2) <= Math.pow(numberR, 2)) {
                    element.condition = true;
                }
            }
        }
    }
}
