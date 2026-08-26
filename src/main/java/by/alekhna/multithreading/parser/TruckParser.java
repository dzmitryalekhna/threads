package by.alekhna.multithreading.parser;

import by.alekhna.multithreading.entity.TruckData;

import java.util.List;

public interface TruckParser {
  List<TruckData> parse(List<String> trucksInfo);
}
