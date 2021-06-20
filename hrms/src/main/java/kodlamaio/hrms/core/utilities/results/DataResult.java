package kodlamaio.hrms.core.utilities.results;

import java.io.Serializable;

public class DataResult<T> extends Result implements Serializable {

    private T data;

    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public T getData(){
        return this.data;
    }
}
