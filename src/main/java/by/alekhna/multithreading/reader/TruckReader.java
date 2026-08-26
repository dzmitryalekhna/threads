package by.alekhna.multithreading.reader;

import by.alekhna.multithreading.exception.LogisticsBaseException;

import java.util.List;

public interface TruckReader {
  List<String> readTruckInfo(String filepath) throws LogisticsBaseException;
}
