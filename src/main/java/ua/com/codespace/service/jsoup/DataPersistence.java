package ua.com.codespace.service.jsoup;

import java.io.IOException;

public interface DataPersistence {
    void savePopulation() throws IOException;
    void saveArea() throws IOException;
    void saveAvgLifeDuration() throws IOException;
    void saveLifeQualityIndex() throws IOException;
}
