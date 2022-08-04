package app.raiko.model.datasource;

public interface DataSource<T> {
    T connect();
}
