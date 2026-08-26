package by.alekhna.multithreading.factory;

import by.alekhna.multithreading.entity.Truck;
import by.alekhna.multithreading.entity.TruckData;
import by.alekhna.multithreading.exception.LogisticsBaseException;

import java.util.List;

public interface TruckFactory {
  List<Truck> createTrucks(List<TruckData> trucksData) throws LogisticsBaseException;
}
