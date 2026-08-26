package by.alekhna.multithreading;

import by.alekhna.multithreading.entity.Truck;
import by.alekhna.multithreading.entity.TruckData;
import by.alekhna.multithreading.exception.LogisticsBaseException;
import by.alekhna.multithreading.factory.TruckFactory;
import by.alekhna.multithreading.factory.impl.TruckFactoryImpl;
import by.alekhna.multithreading.parser.TruckParser;
import by.alekhna.multithreading.parser.impl.TruckParserImpl;
import by.alekhna.multithreading.reader.TruckReader;
import by.alekhna.multithreading.reader.impl.TruckReaderImpl;
import java.util.List;

public class Main {
  private static final String FILEPATH = "data/trucks.txt";

  public static void main(String[] args) throws LogisticsBaseException {
    TruckReader reader = new TruckReaderImpl();
    List<String> trucksInfo = reader.readTruckInfo(FILEPATH);
    TruckParser truckParser = new TruckParserImpl();
    List<TruckData> trucksData = truckParser.parse(trucksInfo);
    TruckFactory factory = new TruckFactoryImpl();
    List<Truck> trucks = factory.createTrucks(trucksData);
    trucks.stream()
            .filter(Truck::isPerishable)
            .forEach(truck -> {
              Thread thread = new Thread(truck);
              thread.setPriority(Thread.MAX_PRIORITY);
              thread.start();
            });
    trucks.stream()
            .filter(truck -> !truck.isPerishable())
            .forEach(truck -> {
              Thread thread = new Thread(truck);
              thread.setPriority(Thread.MIN_PRIORITY);
              thread.start();
            });
  }
}