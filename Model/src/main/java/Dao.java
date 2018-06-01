import java.io.IOException;
import java.io.Serializable;

public interface Dao<T extends Serializable >{
    T read() throws ClassNotFoundException, IOException;
    void write(T sthToWrite) throws IOException, ConnectionErrorException;
}
