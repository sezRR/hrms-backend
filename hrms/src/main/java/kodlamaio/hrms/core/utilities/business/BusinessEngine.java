package kodlamaio.hrms.core.utilities.business;

import kodlamaio.hrms.core.utilities.results.Result;

public class BusinessEngine {
    public static Result run(Result ...logics){
        for (Result logic : logics){
            if (!logic.isSuccess()){
                return logic;
            }
        }

        return null;
    }
}
